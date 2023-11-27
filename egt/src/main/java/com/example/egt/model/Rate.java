package com.example.egt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Rate")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rate implements Serializable {
    @Id
    @Column(name = "currency")
    private String currency;

    @Column(name = "rate")
    private BigDecimal rate;

    @ManyToOne
    @JoinColumn(name = "timestamp")
    private FixerResponse fixerResponse;
}
