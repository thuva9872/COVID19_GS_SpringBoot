package com.project.covid19.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.covid19.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findByNic(String nic);
    Boolean existsByNic(String nic);

    @Query(value = "SELECT a FROM person WHERE a.familyId = ?1",nativeQuery = true)
    List<Person> findAllInSameFamily(int familyId);
}