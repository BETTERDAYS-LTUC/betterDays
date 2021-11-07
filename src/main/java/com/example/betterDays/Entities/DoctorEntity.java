package com.example.betterDays.Entities;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class DoctorEntity {
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

//    @OneToMany(mappedBy="Patient")
//    private List<Patient> patient ;

//    @OneToMany(mappedBy="applicationUser")
//    private List<Post> posts ;


    public DoctorEntity(String password, String email) {
        this.password = password;
        this.email = email;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
