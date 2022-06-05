package com.project.covid19.controllers;

import com.project.covid19.models.*;
import com.project.covid19.payload.request.AddCovidStatusRequest;
import com.project.covid19.payload.request.AddPersonRequest;
import com.project.covid19.payload.request.AddStoreRequest;
import com.project.covid19.payload.request.AddVaccinationRequest;
import com.project.covid19.payload.response.DashboardResponse;
import com.project.covid19.payload.response.MessageResponse;
import com.project.covid19.repository.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/gs")
public class GSController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    Covid19Repository covid19Repository;

    @Autowired
    VaccinationRepository vaccinationRepository;

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    GroceryRepository groceryRepository;

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

    @PostMapping("/addCovidStatus")
    public ResponseEntity<?> addCoivdStatus(@Valid @RequestBody AddCovidStatusRequest addCovidStatusRequest){
        Covid19Status covid19Status=new Covid19Status(addCovidStatusRequest.getNic(),addCovidStatusRequest.getReason(),addCovidStatusRequest.getQuarantineStartDate(),addCovidStatusRequest.getQuarantineFinishDate());
        int recordId=covid19Repository.save(covid19Status).getRecordId();
        if(covid19Repository.existsById(recordId)){
            return ResponseEntity.ok(new MessageResponse("Covid19 status added successfully."));
        }
        return ResponseEntity.badRequest().body("Covid19 status not added. Try again later");
    }

    @GetMapping("/covid19/{nic}")
    public ResponseEntity<?> getCovid19Status(@PathVariable String nic){
        List<Covid19Status> covid19StatusList=covid19Repository.findByNic(nic);
        return ResponseEntity.ok(covid19StatusList);
    }

    @PostMapping("/addVaccinationInfo")
    public ResponseEntity<?> addVaccinationInfo(@Valid @RequestBody AddVaccinationRequest addVaccinationRequest){
        VaccinationDetail vaccinationDetail=new VaccinationDetail(addVaccinationRequest.getNic(),addVaccinationRequest.getVaccineName(),addVaccinationRequest.getVaccinationDate(),addVaccinationRequest.getVaccinationAddress());
        int recordId=vaccinationRepository.save(vaccinationDetail).getRecordId();
        if(vaccinationRepository.existsById(recordId)){
            return ResponseEntity.ok(new MessageResponse("Vaccination info added successfully."));
        }
        return ResponseEntity.badRequest().body("Vaccination info not added. Try again later");
    }

    @GetMapping("/vaccination/{nic}")
    public ResponseEntity<?> getVaccinationDetail(@PathVariable String nic){
        List<VaccinationDetail> vaccinationDetailList=vaccinationRepository.findByNic(nic);
        return ResponseEntity.ok(vaccinationDetailList);
    }

    @GetMapping("/familyDetail/{familyId}")
    public ResponseEntity<?> getFamilyDetails(@PathVariable int familyId){
        List<Person> family=personRepository.findByFamilyId(familyId);
        if(family.isEmpty()){
            return ResponseEntity.ok().body(new MessageResponse("Family not found."));
        }
        return ResponseEntity.ok(family);
    }

//    @GetMapping("/fullFamilyDetail/{familyId}")
//    public ResponseEntity<?> getFullFamilyDetails(@PathVariable int familyId){
//        List<Person> family=personRepository.findByFamilyId(familyId);
//
//        if(family.isEmpty()){
//            List<List<VaccinationDetail>> vaccinationDetailList=new ArrayList<>();
//            family.forEach((e)->{
//                List<VaccinationDetail> details=vaccinationRepository.findByNic(e.getNic());
//                vaccinationDetailList.add(details);
//            });
//            return ResponseEntity.ok().body(new MessageResponse("Family not found."));
//        }
//        return ResponseEntity.ok(family);
//    }

    @PostMapping("/addPharmacy")
    public ResponseEntity<?> addPharmacy(@Valid @RequestBody AddStoreRequest addPharmacyRequest){
        Pharmacy pharmacy=new Pharmacy(addPharmacyRequest.getName(),addPharmacyRequest.getAddress(),
                addPharmacyRequest.getLocation(),addPharmacyRequest.getOpeningTime(),
                addPharmacyRequest.getClosingTime());
        int id=pharmacyRepository.save(pharmacy).getId();
        if(pharmacyRepository.existsById(id)){
            return ResponseEntity.ok(new MessageResponse("Pharmacy added successfully."));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Pharmacy not added successfully"));
    }

    @GetMapping("/getPharmacies")
    public ResponseEntity getPharmacy(){
        List<Pharmacy> nearbyPharmacyList=pharmacyRepository.findAll();
        return ResponseEntity.ok(nearbyPharmacyList);
    }

    @PostMapping("/addGroceryStore")
    public ResponseEntity<?> addGroceryStore(@Valid @RequestBody AddStoreRequest addGroceryRequest){
        Grocery grocery=new Grocery(addGroceryRequest.getName(),addGroceryRequest.getAddress(),
                addGroceryRequest.getLocation(),addGroceryRequest.getOpeningTime(),addGroceryRequest.getClosingTime());
        int id=groceryRepository.save(grocery).getId();
        if(groceryRepository.existsById(id)){
            return ResponseEntity.ok(new MessageResponse("Grocery store added successfully."));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("Grocery store not added successfully"));
    }

    @GetMapping("/getGroceryStores")
    public ResponseEntity getGroceryStores(){
        List<Grocery> nearbyGroceryList=groceryRepository.findAll();
        return ResponseEntity.ok(nearbyGroceryList);
    }

    @GetMapping("/getDashboard")
    public ResponseEntity<?> getDashboard(){
        int population= (int) personRepository.count();
        int covid= (int) covid19Repository.count();
        int vaccination= (int) vaccinationRepository.count();
        DashboardResponse response=new DashboardResponse(population,covid,vaccination);
        return ResponseEntity.ok(response);
    }
}
