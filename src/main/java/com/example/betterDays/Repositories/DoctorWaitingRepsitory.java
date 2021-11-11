package com.example.betterDays.Repositories;

import com.example.betterDays.Entities.DoctorWaiting;
import org.springframework.data.repository.CrudRepository;

public interface DoctorWaitingRepsitory extends CrudRepository<DoctorWaiting,Integer> {
    DoctorWaiting findByUsername(String userName);
}
