package com.example.egt.controller;

import com.example.egt.dto.FixerResponseDto;
import com.example.egt.model.FixerResponse;
import com.example.egt.service.FixerResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/fixer-api/xml",
        produces = "application/xml")
@RequiredArgsConstructor
public class XmlController {

    private final FixerResponseService fixerService;

    @PostMapping("/create") // return FixerResponseDto but first make HashMap correct
    public ResponseEntity<FixerResponse> create(){
        return new ResponseEntity<>(fixerService.createFixerResponse(), HttpStatus.CREATED);
    }

}
