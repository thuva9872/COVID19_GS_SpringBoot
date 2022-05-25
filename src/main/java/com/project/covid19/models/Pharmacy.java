package com.project.covid19.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(	name = "pharmacy",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        })
public class Pharmacy {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NotBlank
    @Size(max = 20)
    private String name;
    @NotBlank
    @Size(max = 200)
    private String address;
    @NotBlank
    @Temporal(TemporalType.TIME)
    private Date openingTime;
    @NotBlank
    @Temporal(TemporalType.TIME)
    private Date closingTime;

    public Pharmacy() {
    }
    public Pharmacy(int id,String name,String address,Date openingTime,Date closingTime) {
        this.id = id;
        this.name=name;
        this.address=address;
        this.openingTime=openingTime;
        this.closingTime=closingTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }
}