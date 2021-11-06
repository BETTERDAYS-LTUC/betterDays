package com.example.betterDays;

import com.example.betterDays.DoctorEntity;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository <DoctorEntity,Integer> {
    public DoctorEntity findByUsername(String userName);
}
