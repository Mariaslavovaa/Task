package com.example.egt.service;


import com.example.egt.model.ApiRequest;
import com.example.egt.model.FixerResponse;
import com.example.egt.repository.ApiRequestRepository;
import com.example.egt.repository.FixerResponseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Configuration
@EnableScheduling
@Log4j2
public class FixerResponseServiceImpl implements FixerResponseService{
    private final FixerResponseRepository fixerRepo;
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${url}")
    private String url;

    private final ApiRequestRepository apiRequestRepository;


    @Override
    @Scheduled(fixedRateString = "${interval}")
    @Transactional(rollbackFor = Exception.class)
    public FixerResponse fetchFixerData() {
        log.info("Downloading....");

        ResponseEntity<FixerResponse> response = restTemplate.getForEntity(url, FixerResponse.class);
        log.info(restTemplate.getForEntity(url, FixerResponse.class));

        return fixerRepo.save(Objects.requireNonNull(response.getBody()));
    }

}
