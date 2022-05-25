package com.project.covid19.repository;

import com.project.covid19.models.Covid19Status;
import com.project.covid19.models.Person;
import com.project.covid19.models.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {
    Optional<Pharmacy> findById(int id);
    Boolean existsById(int id);
}