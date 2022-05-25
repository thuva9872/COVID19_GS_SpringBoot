package com.project.covid19.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(	name = "covid19Status",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "recordId")
        })
public class Covid19Status {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int recordId;
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

    public Covid19Status() {
    }
    public Covid19Status(String nic, String reason,Date quarantineStartDate,Date quarantineFinishDate) {
        this.nic=nic;
        this.reason = reason;
        this.quarantineStartDate=quarantineStartDate;
        this.quarantineFinishDate=quarantineFinishDate;
    }
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getQuarantineStartDate() {
        return quarantineStartDate;
    }

    public void setQuarantineStartDate(Date quarantineStartDate) {
        this.quarantineStartDate = quarantineStartDate;
    }

    public Date getQuarantineFinishDate() {
        return quarantineFinishDate;
    }

    public void setQuarantineFinishDate(Date quarantineFinishDate) {
        this.quarantineFinishDate = quarantineFinishDate;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }
}