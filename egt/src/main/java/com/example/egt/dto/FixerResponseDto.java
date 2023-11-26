package com.example.egt.dto;


import com.example.egt.model.Rate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixerResponseDto {
    private Boolean success;
    private Long timestamp;
    private String base;
    private LocalDate date;
    private List<Rate> rates;
}
