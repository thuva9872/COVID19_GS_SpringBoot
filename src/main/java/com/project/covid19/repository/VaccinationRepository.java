package com.project.covid19.repository;

import com.project.covid19.models.Person;
import com.project.covid19.models.VaccinationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccinationRepository extends JpaRepository<VaccinationDetail, Integer> {
    Boolean existsByNic(String nic);

    @Query(value = "SELECT a FROM vaccinationDetail WHERE a.nic = ?1",nativeQuery = true)
    List<VaccinationDetail> findAllVaccinationDetail(String nic);
}