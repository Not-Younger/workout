package com.jonathanyoung.workout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonathanyoung.workout.model.Workout;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> {
  
}
