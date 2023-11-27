package com.example.egt.controller;

import com.example.egt.dto.FixerResponseDto;
import com.example.egt.model.FixerResponse;
import com.example.egt.service.FixerResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("fixer-api/json")
@RequiredArgsConstructor
public class JsonController {
    private final FixerResponseService fixerService;

    @PostMapping("/create")  // return FixerResponseDto but first make HashMap correct
    public ResponseEntity<FixerResponse> create(){
        return new ResponseEntity<>(fixerService.createFixerResponse(), HttpStatus.CREATED);
    }
}
