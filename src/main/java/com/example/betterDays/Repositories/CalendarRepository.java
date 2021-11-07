package com.example.betterDays.Repositories;

import com.example.betterDays.Entities.DoctorEntity;
import com.example.betterDays.Entities.MyCalendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<MyCalendar,Integer> {
//    public DoctorEntity findByUsername(String userName);

}
