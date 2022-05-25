package com.project.covid19.payload.request;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class AddVaccinationRequest {
  @NotNull
  @Size(min=9,max = 12)
  private String nic;
  @NotBlank
  @Size(max = 200)
  private String vaccineName;
  @NotBlank
  @Temporal(TemporalType.DATE)
  private Date vaccinationDate;
  private String vaccinationAddress;

  public String getNic(){return nic;}

  public void setNic(String nic){this.nic=nic;}

  public String getVaccineName() {
    return vaccineName;
  }

  public void setVaccineName(String vaccineName) {
    this.vaccineName = vaccineName;
  }

  public Date getVaccinationDate(){return vaccinationDate;}

  public void setVaccinationDate(Date vaccinationDate){this.vaccinationDate=vaccinationDate;}

  public String getVaccinationAddress(){return vaccinationAddress;}

  public void setVaccinationAddress(String vaccinationAddress){this.vaccinationAddress=vaccinationAddress;}

}
