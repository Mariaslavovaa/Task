package com.example.egt.controller;

import com.example.egt.model.FixerResponse;
import com.example.egt.service.FixerResponseService;
import com.example.egt.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fixer-api/xml",
        produces = "application/xml")
@RequiredArgsConstructor
public class XmlController {

    private final StatisticsService statisticsService;

    @PostMapping("/command")
    public ResponseEntity<FixerResponse> create(){
        return null;
    }

}
