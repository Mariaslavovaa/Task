package com.example.egt.repository;

import com.example.egt.model.ApiRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApiRequestRepository extends JpaRepository<ApiRequest, UUID> {

}
