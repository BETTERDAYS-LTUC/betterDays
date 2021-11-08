package com.example.betterDays.Repositories;

import com.example.betterDays.Entities.DoctorEntity;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository <DoctorEntity,Integer> {
     DoctorEntity findByUsername(String userName);
}
