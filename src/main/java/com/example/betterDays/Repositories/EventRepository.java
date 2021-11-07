package com.example.betterDays.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import com.example.betterDays.Entities.Event;
//import org.daypilot.demo.html5eventcalendarspring.domain.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public interface EventRepository extends CrudRepository<Event, Long> {
    @Query("from Event e where not(e.end1 < :from or e.start > :to)")
    public List<Event> findBetween(@Param("from") @DateTimeFormat(iso=ISO.DATE_TIME) LocalDateTime start, @Param("to") @DateTimeFormat(iso=ISO.DATE_TIME) LocalDateTime end1);
}
