package com.example.translator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class LoginDto {
    private String id;
    private String password;
}
