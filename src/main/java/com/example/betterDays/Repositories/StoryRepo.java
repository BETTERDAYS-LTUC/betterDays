package com.example.betterDays.Repositories;

import com.example.betterDays.Entities.Patient;
import com.example.betterDays.Entities.Story;
import org.springframework.data.repository.CrudRepository;

public interface StoryRepo extends CrudRepository<Story,Integer> {
}
