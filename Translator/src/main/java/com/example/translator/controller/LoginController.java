package com.example.translator.controller;

import com.example.translator.dto.LoginDto;
import com.example.translator.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequiredArgsConstructor

public class LoginController {


    private final LoginService loginService;

    @GetMapping("/login")

    public ResponseEntity<?> login(LoginDto dto) {

        boolean result = loginService.loginProc(dto);

        if (result) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
                 }
        }
    }