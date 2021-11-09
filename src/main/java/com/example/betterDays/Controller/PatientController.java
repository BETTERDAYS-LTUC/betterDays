package com.example.betterDays.Controller;

import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Repositories.PatientRepository;
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
    PasswordEncoder encoder;

    @PostMapping("/testResult")
    public String getSolution(Principal principal, @RequestParam int submit, Model model) {
        Patient patient = patientRepository.findByUsername(principal.getName());
         String firstName=patient.getFirstName();
        String lastName=patient.getLastName();
        String userName=patient.getUserName();
        String nickName=patient.getNickName();
        String email=patient.getEmail();
        String password=patient.getPassword();
        int id=patient.getId();
        int age=patient.getAge();

        if (submit < 3) {
            patient.setTestResult("Initiation");
            patientRepository.delete(patient);
            Patient patient0=new Patient(firstName,lastName,userName,nickName,email,password,age,"Initiation",id);
            patientRepository.save(patient0);
            System.out.println(patient.getTestResult());
            return "index";
        } else if (submit == 3) {
            patient.setTestResult("Experimentation stage");
            patientRepository.delete(patient);
            Patient patient0=new Patient(firstName,lastName,userName,nickName,email,password,age,"Experimentation stage",id);
            patientRepository.save(patient0);
            System.out.println(patient.getTestResult());
            return "level3";
        } else if (submit >= 4 && submit < 7) {
            patient.setTestResult("Regular Usage");
            patientRepository.delete(patient);
            Patient patient0=new Patient(firstName,lastName,userName,nickName,email,password,age,"Regular Usage",id);
            patientRepository.save(patient0);
            System.out.println(patient.getTestResult());
            return "level3";
        } else if (submit >= 7 && submit < 10) {
            patient.setTestResult("Risky Usage");
            patientRepository.delete(patient);
            Patient patient0=new Patient(firstName,lastName,userName,nickName,email,password,age,"Risky Usage",id);
            patientRepository.save(patient0);
            System.out.println(patient.getTestResult());
            return "level1";
        } else {
            patient.setTestResult("Crisis/Treatment ");
            patientRepository.delete(patient);
            Patient patient0=new Patient(firstName,lastName,userName,nickName,email,password,age,"Crisis/Treatment",id);
            patientRepository.save(patient0);
            System.out.println(patient.getTestResult());
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
        model.addAttribute("patient", patient);
        return "profile";
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
}
