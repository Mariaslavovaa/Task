package com.example.egt.repository;


import com.example.egt.model.FixerResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixerResponseRepository extends CrudRepository<FixerResponse, Long> {

    @Query("SELECT fr FROM FixerResponse fr Where fr.base = :currency ORDER BY fr.timestamp DESC LIMIT 1")
    FixerResponse findLast(@Param("currency") String currency);

    @Query("SELECT fr " +
            "FROM FixerResponse fr " +
            "where TIMESTAMPADD(SECOND, cast(fr.timestamp as Integer), cast('1970-01-01 00:00:00' as LocalDateTime)) >= TIMESTAMPADD(hour, :hours, CURRENT_TIMESTAMP) " +
            "ORDER BY TIMESTAMPADD(SECOND, cast(fr.timestamp as Integer), cast('1970-01-01 00:00:00' as LocalDateTime)) DESC")
    List<FixerResponse> getHistory(@Param("hours") Integer hours);
}
