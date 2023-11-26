package com.example.egt.repository;


import com.example.egt.model.FixerResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixerResponseRepository extends CrudRepository<FixerResponse, Long> {


}
