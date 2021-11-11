package com.example.betterDays.Entities;

import javax.persistence.*;

@Entity
public class DoctorWaiting {
    //    @Column(unique = true)
    private String username;
    private String password;
    //    @Column(unique = true)
    private String email;
    private String authority;
    private String firstName;
    private String lastName;
    private int age;
    private String bio ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @ManyToOne
    private Patient doctorWatingEntity;

    public DoctorWaiting() {}
    public DoctorWaiting(String firstName , String lastName, String bio, String username,String email, String password,int age) {
        this.username = username;
        this.password = password;
        this.authority= "role_doctor";
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.bio=bio;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getDoctorWatingEntity() {
        return doctorWatingEntity;
    }

    public void setDoctorWatingEntity(Patient doctorWatingEntity) {
        this.doctorWatingEntity = doctorWatingEntity;
    }

}
