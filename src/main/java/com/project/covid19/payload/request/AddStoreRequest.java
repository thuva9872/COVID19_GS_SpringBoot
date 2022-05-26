package com.project.covid19.payload.request;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class AddStoreRequest {
  @NotBlank
  @Size(max = 20)
  private String name;
  @NotBlank
  @Size(max = 200)
  private String address;

  @NotBlank
  private String location;
  @NotBlank
  private String openingTime;
  @NotBlank
  private String closingTime;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
  public String getOpeningTime() {
    return openingTime;
  }

  public void setOpeningTime(String openingTime) {
    this.openingTime = openingTime;
  }

  public String getClosingTime() {
    return closingTime;
  }

  public void setClosingTime(String closingTime) {
    this.closingTime = closingTime;
  }
}
