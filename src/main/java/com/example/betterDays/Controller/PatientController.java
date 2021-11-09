package com.example.betterDays.Controller;

import com.example.betterDays.Entities.DoctorEntity;
import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Repositories.DoctorRepository;
import com.example.betterDays.Entities.Story;
import com.example.betterDays.Repositories.PatientRepository;
import com.example.betterDays.Repositories.StoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PatientController {

    @Autowired
    PatientRepository patientRepository;
    @Autowired

    DoctorRepository doctorRepository;
    StoryRepo storyRepo;



    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/testResult")
    public String getSolution(Principal principal, @RequestParam int submit, Model model) {
        Patient patient = patientRepository.findByUsername(principal.getName());
        if (submit < 3) {
            patient.setTestResult("Initiation");
            model.addAttribute("patient", patient);
            return "index";
        } else if (submit == 3) {
            patient.setTestResult("Experimentation stage");
            return "level3";
        } else if (submit >= 4 && submit < 7) {
            patient.setTestResult("Regular Usage");
            return "level3";
        } else if (submit >= 7 && submit < 10) {
            patient.setTestResult("Risky Usage");
            return "level1";
        } else {
            patient.setTestResult("Crisis/Treatment ");
            return "level1";
        }
    }

    @GetMapping("/test")
    public String getTest() {
        return "test";
    }

    @GetMapping("/patientProfile")
    public String getPatientProfile(Principal principal, Model model) {
        Patient patient = patientRepository.findByUsername(principal.getName());
        DoctorEntity doctor = doctorRepository.findByUsername(principal.getName());
if(patient!=null) {
    model.addAttribute("patient", patient);
    return "profile";
}else if (doctor!=null){
    model.addAttribute("patient", doctor);
    return "doctorpro";
}else {
    return "index";
}
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String nickName,
                                @RequestParam String userName,
                                @RequestParam String email,
                                @RequestParam String password,
                                @RequestParam int age, Principal principal,
                                Model model) {
        Patient patientToUpdate = patientRepository.findByUsername(principal.getName());

        patientToUpdate.setFirstName(firstName);
        patientToUpdate.setLastName(lastName);
        patientToUpdate.setAge(age);
        patientToUpdate.setEmail(email);
        patientToUpdate.setPassword(encoder.encode(password));
        patientToUpdate.setUserName(userName);
        patientToUpdate.setNickName(nickName);

        patientRepository.save(patientToUpdate);
        model.addAttribute("patient", patientToUpdate);

        return "profile";

    }

    @PostMapping("/addDoctorToBooking/{id}")
    public RedirectView profile(@PathVariable int id, Model m, Principal principal){
        DoctorEntity doctor  = doctorRepository.findById(id).get();
        Patient patient = patientRepository.findByUsername(principal.getName());
        patient.setDoctorEntity(doctor);
        doctor.addPatient(patient);
        patientRepository.save(patient);
        doctorRepository.save(doctor);
        return new RedirectView("/calender");


    }


    @PostMapping("/addstory")
    public String addStory(@RequestParam String body,@RequestParam String title  ,Principal p, Model model){
        Patient patient=patientRepository.findByUsername(p.getName());
        Story newStory=new Story(patient,body,title);
        model.addAttribute("storyy",newStory);
        storyRepo.save(newStory);
        return "index";
    }



}
