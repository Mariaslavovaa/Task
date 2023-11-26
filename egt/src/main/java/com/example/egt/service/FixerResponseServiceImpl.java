package com.example.egt.service;


import com.example.egt.model.FixerResponse;
import com.example.egt.repository.FixerResponseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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



    @Override
    @Scheduled(fixedRate = 10000)
    public FixerResponse createFixerResponse() {
        log.info("Downloading....");
        String fooResourceUrl = "http://data.fixer.io/api/latest?access_key=7541fbea33a14a4f8e39ea6f5930314b&format=1";
        ResponseEntity<FixerResponse> response ;
        log.info(restTemplate.getForEntity(fooResourceUrl, String.class));
        return null;
    }

    @Override
    public FixerResponse create(FixerResponse fixerResponse) {
        return fixerRepo.save(fixerResponse);
    }


}
