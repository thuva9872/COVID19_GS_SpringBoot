package com.project.covid19.security.services;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.project.covid19.models.Admin;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.project.covid19.models.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class AdminDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String nic;
    private String username;
    @JsonIgnore
    private String password;
    public AdminDetailsImpl(String nic, String username, String password) {
        this.nic = nic;
        this.username = username;
        this.password = password;
    }
    public static AdminDetailsImpl build(Admin admin) {
        return new AdminDetailsImpl(
                admin.getNic(),
                admin.getUsername(),
                admin.getPassword());
    }
    public String getNic() {
        return nic;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AdminDetailsImpl user = (AdminDetailsImpl) o;
        return Objects.equals(nic, user.nic);
    }
}