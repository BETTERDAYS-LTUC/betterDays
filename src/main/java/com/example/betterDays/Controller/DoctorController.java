package com.example.betterDays.Controller;

import com.example.betterDays.Entities.DoctorEntity;
import com.example.betterDays.Entities.DoctorWaiting;
import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Repositories.DoctorRepository;
import com.example.betterDays.Repositories.DoctorWaitingRepsitory;
import com.example.betterDays.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DoctorWaitingRepsitory doctorWaitingRepsitory;
    @Autowired
    PatientRepository patientRepository;
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
//    @GetMapping("/doctorProfile")
//    public String getDoctorProfile(Principal principal, Model model) {
//        DoctorEntity doctor = doctorRepository.findByUsername(principal.getName());
//        model.addAttribute("doctor", doctor);
//        return "doctorpro";
//    }

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
    @GetMapping("/signupDoctor")
    public String getSignUpPage(){
        return "SingnUpDoctor";
    }

    @PostMapping("/signupDoctor")
    public RedirectView signUpUser(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam String bio,
                                   @RequestParam String userName,
                                   @RequestParam String email,
                                   @RequestParam String password,
                                   @RequestParam int age){
        Patient admin=patientRepository.findById(7).get();
        DoctorWaiting doctorwaiting = new DoctorWaiting(userName, encoder.encode(password));

        doctorWaitingRepsitory.save(doctorwaiting);
        admin.addWattingDoctor(doctorwaiting);

//        Authentication authentication = new UsernamePasswordAuthenticationToken(patient, null, new ArrayList<>());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/login");
    }
    @GetMapping ("/alldoctorwait")
    public String getalldoctorwait(Model m, Principal p){
        m.addAttribute("doctor",doctorWaitingRepsitory.findAll());
        return ("allDoctorWatting");
    }
    @PostMapping("/choosedoctor/{id}")
    public RedirectView profile(@PathVariable int id, Model m, Principal principal){
        DoctorWaiting doctor  = doctorWaitingRepsitory.findById(id).get();
        DoctorEntity doctor1=new DoctorEntity(doctor.getUsername(),encoder.encode(doctor.getPassword()));
//        Patient patient = patientRepository.findByUsername(principal.getName());
//        patient.setDoctorEntity(doctor);
//        doctor.addPatient(patient);
//        patientRepository.save(patient);
        doctorRepository.save(doctor1);
        return new RedirectView("/alldoctorwait");
    }
}

