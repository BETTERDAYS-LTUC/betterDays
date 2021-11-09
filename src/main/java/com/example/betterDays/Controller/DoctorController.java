package com.example.betterDays.Controller;

import com.example.betterDays.Entities.DoctorEntity;
import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
@Controller
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PasswordEncoder encoder;
//@GetMapping("/doctor")
//    public String getDoctor(){
//    return "doctorpro";
//}
@GetMapping("/doctor")
    public String getDoctorAcc(){
    DoctorEntity doctor=new DoctorEntity("doctor111", encoder.encode("0"));
    doctorRepository.save(doctor);
    return "index";
}
//@GetMapping("/doctorProfile")
//public String getDoctorProfile(Principal principal, Model model) {
//    DoctorEntity doctor = doctorRepository.findByUsername(principal.getName());
//    model.addAttribute("patient", doctor);
//    return "profile";
//}

    @GetMapping ("/alldoctor")
    public String home(Model m, Principal p){
        m.addAttribute("doctor",doctorRepository.findAll());
        return ("allDoctor");
    }
}

