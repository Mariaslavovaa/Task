package com.example.egt.service;

import com.example.egt.model.FixerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticsService {
    FixerResponse current(String id, String timestamp, String currency, String client, String serviceName);

    List<FixerResponse> history(String id, String timestamp, String client, Integer hours, String serviceName);
}
