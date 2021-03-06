package com.project.covid19.repository;

import com.project.covid19.models.Covid19Status;
import com.project.covid19.models.VaccinationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Covid19Repository extends JpaRepository<Covid19Status, Integer> {
    Boolean existsByRecordId(int recordId);
    List<Covid19Status> findByNic(String nic);
}