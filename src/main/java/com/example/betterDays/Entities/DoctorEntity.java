package com.example.betterDays.Entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.sql.Date;
import java.util.*;
@Entity
public class DoctorEntity implements UserDetails {
    // @Column(unique = true)
    private String username;
    private String password;
    // @Column(unique = true)
    private String email;
    private String authority;
    private String firstName;
    private String lastName;
    private int age;
    private String bio ;



    public DoctorEntity() {
    }
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
// @OneToMany(mappedBy="applicationUser")
// private List<Post> posts ;
//------------------------------getter and setter------------------------------------------------
    public DoctorEntity(String username, String password) {
        this.username = username;
        this.password = password;
        this.authority= "role_doctor";
        this.email = "email@gmail.com";
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.age = 0;
        this.bio="yourbio";
    }

    // public String getUsername() {
// return username;
// }
//
// public void setUsername(String username) {
// this.username = username;
// }
//
// public String getPassword() {
// return password;
// }
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
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void addPatient(Patient patient){
        if (this.patient.contains(patient))
            System.out.println("already a patient");
        else
            this.patient.add(patient);
    }
    public void addEvent(Event event){
        if (this.bookingList.contains(event))
            System.out.println("already booked");
        else
            this.bookingList.add(event);
    }
}
