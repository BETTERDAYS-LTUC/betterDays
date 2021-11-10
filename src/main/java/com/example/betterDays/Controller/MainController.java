package com.example.betterDays.Controller;




import com.example.betterDays.Entities.DoctorEntity;
import com.example.betterDays.Entities.Event;
import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Repositories.DoctorRepository;
import com.example.betterDays.Repositories.EventRepository;
import com.example.betterDays.Repositories.PatientRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import org.daypilot.demo.html5eventcalendarspring.domain.Event;
//import org.daypilot.demo.html5eventcalendarspring.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class MainController {

    @Autowired
    EventRepository er;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @RequestMapping("/api")
    @ResponseBody
    String home() {
        return "Welcome!";
    }


    @GetMapping("/api/events")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    Iterable<Event> events(@RequestParam("start") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime start, @RequestParam("end1") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime end1) {
        return er.findBetween(start, end1);
    }

    @PostMapping("/api/events/create")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    Event createEvent(@RequestBody EventCreateParams params, Principal principal) {

        Patient patient = patientRepository.findByUsername(principal.getName());
        DoctorEntity doctor = doctorRepository.findById(patient.getDoctorEntity().getId()).get();

        Event e = new Event(params.text, params.start,params.end,patient,doctor);
        doctor.addEvent(e);
        er.save(e);

        return e;
    }

    @PostMapping("/api/events/move")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    Event moveEvent(@RequestBody EventMoveParams params) {

        Event e = er.findById(params.id).get();

        e.setStart(params.start);
        e.setEnd1(params.end1);

        er.save(e);

        return e;
    }

    @PostMapping("/api/events/setColor")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    Event setColor(@RequestBody SetColorParams params) {

        Event e = er.findById(params.id).get();
        e.setColor(params.color);
        er.save(e);

        return e;
    }

    public static class EventCreateParams {
        public LocalDateTime start;
        public LocalDateTime end;
        public String text;
        public Long resource;
    }

    public static class EventMoveParams {
        public Long id;
        public LocalDateTime start;
        public LocalDateTime end1;
        public Long resource;
    }

    public static class SetColorParams {
        public Long id;
        public String color;
    }


}
