package com.example.betterDays.Repositories;

import com.example.betterDays.Entities.DoctorEntity;
import com.example.betterDays.Entities.DoctorWaiting;
import org.springframework.data.repository.CrudRepository;

public interface Doctorwait extends CrudRepository<DoctorWaiting,Integer> {
    DoctorWaiting findByUsername(String userName);

}
