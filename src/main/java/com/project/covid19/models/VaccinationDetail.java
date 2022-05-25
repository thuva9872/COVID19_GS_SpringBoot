package com.project.covid19.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(	name = "vaccinationDetail",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "recordId")
        })
public class VaccinationDetail {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int recordId;
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
;
    public VaccinationDetail() {
    }
    public VaccinationDetail(String nic, String vaccineName, Date vaccinationDate, String vaccinationAddress) {
        this.nic=nic;
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
        this.vaccinationAddress = vaccinationAddress;
    }
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccinationAddress() {
        return vaccinationAddress;
    }

    public void setVaccinationAddress(String vaccinationAddress) {
        this.vaccinationAddress = vaccinationAddress;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

}