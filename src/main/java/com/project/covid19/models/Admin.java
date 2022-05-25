package com.project.covid19.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(	name = "admin",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
public class Admin {
    @Id
    @NotNull
    @Size(min=9,max = 12)
    private String nic;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 120)
    private String password;
    public Admin() {
    }
    public Admin(String nic, String username, String password) {
        this.nic=nic;
        this.username = username;
        this.password = password;
    }
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
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

}