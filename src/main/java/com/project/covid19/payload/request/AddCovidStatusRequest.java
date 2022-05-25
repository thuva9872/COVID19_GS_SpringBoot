package com.project.covid19.payload.request;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class AddCovidStatusRequest {
  @NotNull
  @Size(min=9,max = 12)
  private String nic;
  @NotBlank
  @Size(max = 200)
  private String reason;
  @NotBlank
  @Temporal(TemporalType.DATE)
  private Date quarantineStartDate;
  @NotBlank
  @Temporal(TemporalType.DATE)
  private Date quarantineFinishDate;

  public String getNic(){return nic;}

  public void setNic(String nic){this.nic=nic;}

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Date getQuarantineStartDate(){return quarantineStartDate;}

  public void setQuarantineStartDate(Date quarantineStartDate){this.quarantineStartDate=quarantineStartDate;}

  public Date getQuarantineFinishDate(){return quarantineFinishDate;}

  public void setQuarantineFinishDate(Date quarantineFinishDate){this.quarantineFinishDate=quarantineFinishDate;}

}
