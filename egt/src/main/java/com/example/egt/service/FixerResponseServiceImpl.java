package com.example.egt.service;


import com.example.egt.model.FixerResponse;
import com.example.egt.repository.FixerResponseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Value("accessKey")
    private String accessKey;

    @Value("format")
    private String format;

    @Override
    @Scheduled(fixedRateString = "${interval}")
    public FixerResponse createFixerResponse() {
        log.info("Downloading....");

        ResponseEntity<FixerResponse> response ;
        log.info(restTemplate.getForEntity(url, String.class)); //Да видя как се подават параметри и където е url да ги подам!
        return null;
    }

    @Override
    public FixerResponse create(FixerResponse fixerResponse) {
        return fixerRepo.save(fixerResponse);
    }
}
