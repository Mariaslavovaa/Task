package com.example.egt.service;

import com.example.egt.model.ApiRequest;
import com.example.egt.model.FixerResponse;
import com.example.egt.repository.ApiRequestRepository;
import com.example.egt.repository.FixerResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService{
    private final ApiRequestRepository apiRequestRepository;
    private final FixerResponseRepository fixerRepo;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FixerResponse current(String id, String timestamp, String currency, String client, String serviceName) {
        if (apiRequestRepository.existsById(UUID.fromString(id))){
            throw new IllegalArgumentException("A request with such id already exists");
        }
        apiRequestRepository.save(new ApiRequest(UUID.fromString(id), timestamp, client, serviceName));
        return fixerRepo.findLast(currency);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<FixerResponse> history(String id, String timestamp, String client, Integer hours, String serviceName) {
        if (apiRequestRepository.existsById(UUID.fromString(id))){
            throw new IllegalArgumentException("A request with such id already exists");
        }
        apiRequestRepository.save(new ApiRequest(UUID.fromString(id), timestamp, client, serviceName));
        return fixerRepo.getHistory(-1 * (hours+2)); //+2 because the data is stored in UTC time zone which is diff to ours
    }

}
