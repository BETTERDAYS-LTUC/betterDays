package com.example.betterDays.Security;

import com.example.betterDays.Entities.DoctorEntity;
import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Repositories.DoctorRepository;
import com.example.betterDays.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DoctorEntity doctor = doctorRepository.findByUsername(username);
        Patient patient=patientRepository.findByUsername(username);
        if (doctor == null && patient == null ) {
            throw new UsernameNotFoundException("Dose not exist");
        }else if(patient != null){
            return patient;
        }else{
            return doctor;
        }
    }
}
