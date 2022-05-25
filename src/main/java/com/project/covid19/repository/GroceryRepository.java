package com.project.covid19.repository;

import com.project.covid19.models.Grocery;
import com.project.covid19.models.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {
    Optional<Grocery> findById(int id);
    Boolean existsById(int id);
}