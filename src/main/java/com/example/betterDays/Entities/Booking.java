package com.example.betterDays.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
  private Date date;

@OneToOne
    Patient patient;
    @ManyToOne
    private DoctorEntity doctor;
}
