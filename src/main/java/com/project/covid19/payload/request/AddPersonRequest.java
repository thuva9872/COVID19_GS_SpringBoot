package com.project.covid19.payload.request;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class AddPersonRequest {
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

  public String getNic(){return nic;}

  public void setNic(String nic){this.nic=nic;}

  public String getname() {
    return name;
  }

  public void setname(String name) {
    this.name = name;
  }

  public String getAddress(){return address;}

  public void setAddress(String address){this.address=address;}

  public Date getDateOfBirth(){return dateOfBirth;}

  public void setDateOfBirth(Date dateOfBirth){this.dateOfBirth=dateOfBirth;}

  public String getJob(){return job;}

  public void setJob(String job){this.job=job;}

  public String getJobLocation(){return jobLocation;}

  public void setJobLocation(String jobLocation){this.jobLocation=jobLocation;}

  public int getFamilyId(){return familyId;}

  public void setFamilyId(int familyId){this.familyId=familyId;}
}
