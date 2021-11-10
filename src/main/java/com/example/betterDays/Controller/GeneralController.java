package com.example.betterDays.Controller;
import com.example.betterDays.Entities.DoctorEntity;
import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Entities.Story;
import com.example.betterDays.Repositories.DoctorRepository;
import com.example.betterDays.Repositories.PatientRepository;
import com.example.betterDays.Repositories.StoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    StoryRepo storyRepo;
    @GetMapping("/")
    public String getHome(){
// DoctorEntity doctor=new DoctorEntity("doctor1", encoder.encode("0"));
// doctorRepository.save(doctor);
        return "index";
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
// Authentication authentication = new UsernamePasswordAuthenticationToken(patient, null, new ArrayList<>());
// SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/login");
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/calender")
    public String getcalender(){
        return "index1";
    }
    @GetMapping("/stories")
    public String getStory(Model model){
        ArrayList <Story> allstories=(ArrayList<Story>) storyRepo.findAll();
        model.addAttribute("story",allstories);
        return "stories";
    }
}
