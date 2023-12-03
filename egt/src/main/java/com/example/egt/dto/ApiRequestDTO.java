package com.example.egt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiRequestDTO {
    private String requestId;
    private String timestamp;
    private String client;
    private String currency;
    private Integer hours;
}
