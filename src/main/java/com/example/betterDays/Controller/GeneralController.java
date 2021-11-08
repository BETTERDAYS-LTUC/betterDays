package com.example.betterDays.Controller;

import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class GeneralController {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @GetMapping("/level1")
    public String getindex(){
        return "level1";
    }

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView signUpUser(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam String nickName,
                                   @RequestParam String userName,
                                   @RequestParam String email,
                                   @RequestParam String password,
                                   @RequestParam int age){
        Patient patient = new Patient(firstName, lastName, userName, nickName, email, encoder.encode(password),age);
        patientRepository.save(patient);
//        Authentication authentication = new UsernamePasswordAuthenticationToken(patient, null, new ArrayList<>());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/login");
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
