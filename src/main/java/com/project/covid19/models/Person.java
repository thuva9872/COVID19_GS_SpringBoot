package com.project.covid19.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(	name = "person",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nic")
        })
public class Person {
    @Id
    @NotNull
    @Size(min=9,max = 12)
    private String nic;
    @NotBlank
    @Size(max = 20)
    private String name;
    @NotBlank
    @Size(max = 200)
    private String address;
    @NotBlank
    private int familyId;
    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String job;
    private String jobLocation;
    public Person() {
    }
    public Person(String nic,String name, int familyId, Date dateOfBirth, String address, String job, String jobLocation) {
        this.nic=nic;
        this.name = name;
        this.address = address;
        this.familyId = familyId;
        this.dateOfBirth=dateOfBirth;
        this.job = job;
        this.jobLocation=jobLocation;
    }
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getFamilyId() {
        return familyId;
    }
    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}