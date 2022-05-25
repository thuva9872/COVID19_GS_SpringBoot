package com.project.covid19.controllers;

import com.project.covid19.models.Person;
import com.project.covid19.payload.request.AddPersonRequest;
import com.project.covid19.payload.request.LoginRequest;
import com.project.covid19.payload.response.JwtResponse;
import com.project.covid19.payload.response.MessageResponse;
import com.project.covid19.repository.PersonRepository;
import com.project.covid19.security.services.AdminDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/gs")
public class GSController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/addPerson")
    public ResponseEntity<?> addPerson(@Valid @RequestBody AddPersonRequest addPersonRequest) {

        Person person=new Person(addPersonRequest.getNic(),addPersonRequest.getname(),addPersonRequest.getFamilyId(),addPersonRequest.getDateOfBirth(),addPersonRequest.getAddress(),addPersonRequest.getJob(),addPersonRequest.getJobLocation());
        personRepository.save(person);
        if(personRepository.existsByNic(addPersonRequest.getNic())){
            return ResponseEntity.ok(new MessageResponse("Person added successfully"));

        }
        return ResponseEntity.internalServerError().body(new MessageResponse("Person not added. Try again later."));

    }

    @GetMapping("/person/{nic}")
    public ResponseEntity<?> getPerson(@PathVariable String nic){
        Optional<Person> person=personRepository.findByNic(nic);
        if(person.isPresent()){
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Person not found."));
    }
}
