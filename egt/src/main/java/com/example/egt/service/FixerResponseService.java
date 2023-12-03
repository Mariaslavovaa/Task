package com.example.egt.service;


import com.example.egt.model.FixerResponse;
import org.springframework.stereotype.Service;

@Service
public interface FixerResponseService {

    FixerResponse fetchFixerData();
}
