package com.example.translator.controller;

import com.example.translator.dto.HistoryDto;
import com.example.translator.entity.History;
import com.example.translator.repository.HistoryRepository;
import com.example.translator.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/translator")
public class HistoryController {

    private final HistoryRepository historyRepository;
    private final HistoryService historyService;

    @GetMapping("/list")
    public List<History> list(HistoryDto dto, @SessionAttribute(name = "loginUser") String userId){
        List<History> historyList = historyRepository.findById(userId);

        return historyList;
    }

    @GetMapping("/save")
    public ResponseEntity<?> save(HistoryDto dto, @SessionAttribute(name="loginUser") String userId) {

        String result = historyService.translation(dto);

        History history = History.builder().id(userId).searchWord(dto.getSearchWord()).searchLang(dto.getLang()).build();

        historyRepository.save(history);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
