package com.example.egt.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "FixerResponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FixerResponse implements Serializable {
    @Id
    @Column(name = "timestamp")
    private Long timestamp;

    @Column(name = "success")
    private Boolean success;

    @Column(name = "base")
    private String base;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany
    @JoinColumn(name = "currency")
    private List<Rate> rates;

}
