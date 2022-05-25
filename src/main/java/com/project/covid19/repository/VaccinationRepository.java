package com.project.covid19.repository;

import com.project.covid19.models.VaccinationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepository extends JpaRepository<VaccinationDetail, Integer> {
    Boolean existsByRecordId(String recordId);
    List<VaccinationDetail> findByNic(String nic);
}