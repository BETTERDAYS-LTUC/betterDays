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
import org.springframework.web.bind.annotation.RequestParam;
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
// public String getDoctor(){
// return "doctorpro";
//}
    @GetMapping("/doctor")
    public String getDoctorAcc(){
        DoctorEntity doctor=new DoctorEntity("Kim","Adams","I completed my bachelor's degree in 2011 from New York University, where I majored in Art History and minored in Psychology. I completed my masters degree in 2013; receiving a MA in Creative Arts Therapy from Hofstra University.","kimadams12","kim@gmail.com", encoder.encode("000"),33);
        doctorRepository.save(doctor);
        return "index";
    }
    // @GetMapping("/doctorProfile")
// public String getDoctorProfile(Principal principal, Model model) {
// DoctorEntity doctor = doctorRepository.findByUsername(principal.getName());
// model.addAttribute("doctor", doctor);
// return "doctorpro";
// }
    @GetMapping ("/alldoctor")
    public String home(Model m, Principal p){
        m.addAttribute("doctor",doctorRepository.findAll());
        return ("allDoctor");
    }
    @PostMapping("/updateProfileDoctor")
    public String updateProfile(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String userName,
                                @RequestParam String email,
                                @RequestParam String password,
                                @RequestParam int age,
                                @RequestParam String bio,
                                Principal principal,
                                Model model) {
        DoctorEntity doctorToUpdate = doctorRepository.findByUsername(principal.getName());
        doctorToUpdate.setFirstName(firstName);
        doctorToUpdate.setLastName(lastName);
        doctorToUpdate.setAge(age);
        doctorToUpdate.setEmail(email);
        doctorToUpdate.setPassword(encoder.encode(password));
        doctorToUpdate.setUsername(userName);
        doctorToUpdate.setBio(bio);
        doctorRepository.save(doctorToUpdate);
        model.addAttribute("patient", doctorToUpdate);
        return "index";
    }
}
