package com.example.betterDays.Entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
public class DoctorEntity implements UserDetails {
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
     private String authority;




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    //------------------------------patient list------------------------------
    @OneToMany(mappedBy="doctorEntity")
    private List<Patient> patient ;
    @OneToMany(mappedBy="doctor")
    private List<Event> bookingList ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(authority);
      List<SimpleGrantedAuthority> grantedAuthorities=new ArrayList<SimpleGrantedAuthority>();
        grantedAuthorities.add(simpleGrantedAuthority);
        return grantedAuthorities;
    }
// -----------------------------------------auth----------------------------------------------
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
//---------------------------------------------------------------------------------
//    @OneToMany(mappedBy="applicationUser")
//    private List<Post> posts ;

//------------------------------getter and setter------------------------------------------------
    public DoctorEntity(String username, String password) {
        this.username = username;
        this.password = password;
        this.authority= "role_doctor";
    }


//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //----------------------------------------------------------------------------

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }

    public List<Event> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Event> bookingList) {
        this.bookingList = bookingList;
    }
}
