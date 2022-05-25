package com.project.covid19.payload.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

public class SignupRequest {
  @NotNull
  private String nic;
  @NotBlank
  @Size(max = 20)
  private String username;
//  @NotBlank
//  @Size(max = 200)
//  private String address;
  @NotBlank
  @Size(max = 120)
  private String password;
//  @NotBlank
//  private Date dateOfBirth;
//  private String job;
//  private String jobLocation;

  public String getNic(){return nic;}

  public void setNic(String nic){this.nic=nic;}

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

//  public String getAddress(){return address;}
//
//  public void setAddress(String address){this.address=address;}
//
//  public Date getDateOfBirth(){return dateOfBirth;}
//
//  public void setDateOfBirth(Date dateOfBirth){this.dateOfBirth=dateOfBirth;}
//
//  public String getJob(){return job;}
//
//  public void setJob(String job){this.job=job;}
//
//  public String getJobLocation(){return jobLocation;}
//
//  public void setJobLocation(String jobLocation){this.jobLocation=jobLocation;}

}
