package com.example.betterDays.Entities;
//
//
import java.time.LocalDateTime;
//
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String text;

    private LocalDateTime start;

    private LocalDateTime end1 ;

    private String color;


    @OneToOne
    private Patient patient;
    @ManyToOne
    private DoctorEntity doctor;

    public Event() {
    }

    public Event(String text, LocalDateTime start, LocalDateTime end1, Patient patient, DoctorEntity doctor) {
        this.text = text;
        this.start = start;
        this.end1 = end1;
        this.patient = patient;
        this.doctor = doctor;
    }

    //
    public Long getId() {
        return id;
    }
//
    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd1() {
        return end1;
    }

    public void setEnd1(LocalDateTime end) {
        this.end1 = end;

    }


    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }
}
