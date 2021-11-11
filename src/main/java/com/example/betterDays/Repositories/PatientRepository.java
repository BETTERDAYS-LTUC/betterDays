package com.example.betterDays.Repositories;

import com.example.betterDays.Entities.DoctorEntity;
import com.example.betterDays.Entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
    Patient findByUsername(String userName);
}
