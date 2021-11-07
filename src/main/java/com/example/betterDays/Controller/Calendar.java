package com.example.betterDays.Controller;

import com.example.betterDays.Entities.Appointment;
import com.example.betterDays.Entities.MyCalendar;
import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Repositories.CalendarRepository;
import com.example.betterDays.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;

@Controller
public class Calendar {
    @Autowired
    CalendarRepository calendarRepository;
    @GetMapping("/adddate")
    public String addDate(){
        return "appointment";
    }
    @PostMapping("/adddate")
    public RedirectView postCalender(@RequestParam String name,
                                     @RequestParam String date,
                                     @RequestParam int dur,
                                     @RequestParam String place)
    {
        MyCalendar calendar = new MyCalendar(name);
        Appointment appointment=new Appointment(date,dur);
         calendar.createAppointmentSlot(appointment);
           calendar.bookAppointment(name, date, dur, place);
//         calendarRepository.save(calendar);
        return new RedirectView("/");
        
    }


}
