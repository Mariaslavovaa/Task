package com.example.egt.controller;

import com.example.egt.dto.ApiRequestDTO;
import com.example.egt.model.FixerResponse;
import com.example.egt.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/json_api")
@RequiredArgsConstructor
public class JsonController {
    private final StatisticsService service;

    @PostMapping("/current")
    public ResponseEntity<FixerResponse> current(@RequestBody ApiRequestDTO dto){
        String serviceName = "service: ".concat(JsonController.class.getName()).concat("; ep: current");
        return ResponseEntity.ok(service.current(dto.getRequestId(), dto.getTimestamp(), dto.getCurrency(), dto.getClient(), serviceName));
    }

    @PostMapping("/history")
    public ResponseEntity<List<FixerResponse>> history(@RequestBody ApiRequestDTO dto){
        String serviceName = "service: ".concat(JsonController.class.getName()).concat("; ep: history");
        return ResponseEntity.ok(service.history(dto.getRequestId(), dto.getTimestamp(), dto.getClient(),dto.getHours(),serviceName));
    }

}
