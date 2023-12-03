package com.example.egt.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    private String timestamp;

    @Column(name = "success")
    private Boolean success;

    @Column(name = "base")
    private String base;

    @Column(name = "date")
    private LocalDate date;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition="JSON")
    private Map<String, BigDecimal> rates;

}
