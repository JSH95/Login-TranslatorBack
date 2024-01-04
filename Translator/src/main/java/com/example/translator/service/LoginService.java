package com.example.translator.service;

import com.example.translator.dto.LoginDto;
import com.example.translator.entity.User;
import com.example.translator.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final HttpServletRequest httpServletRequest;

    public boolean loginProc(LoginDto dto){
        User user = userRepository.findByIdAndPassword(dto.getId(), dto.getPassword());

        if (user != null){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("loginUser", user.getId());
            return true;
        } else {
            return false;
        }
    }
}
