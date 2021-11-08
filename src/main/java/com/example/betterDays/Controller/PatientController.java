package com.example.betterDays.Controller;

import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

@PostMapping("/testResult")
public String getSolution(Principal principal, @RequestParam int submit, Model model){
    Patient patient = patientRepository.findByUserName(principal.getName());
    if (submit < 3){
        patient.setTestResult("You are good, keep it healthy");
        model.addAttribute("patient", patient);
        return "index";
    }else if (submit == 3){
        patient.setTestResult("you have a drinking or drug problem.");
        return "signup";
    }else if (submit >= 4 && submit < 7){
        patient.setTestResult("you are in an early stage of alcoholism or drug addiction.");
        return "signup";
    }else if (submit >= 7 && submit < 10){
        patient.setTestResult("you are in the second stage of alcoholism or drug addiction.");
        return "signup";
    }else {
        patient.setTestResult("you are in the end stage of alcoholism or drug addiction.");
        return "signup";
    }
}

    @GetMapping("/test")
    public String getTest(){
        return "test";
    }
}
