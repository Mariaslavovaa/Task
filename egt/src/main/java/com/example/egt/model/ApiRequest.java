package com.example.egt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="API_REQUEST")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiRequest {
    @Id
    @Column(name = "REQUEST_ID")
    private UUID requestId;

    @Column(nullable = false)
    private String timestamp;

    @Column(nullable = false)
    private String client;

    @Column(name = "SERVICE_NAME")
    private String serviceName;
}
