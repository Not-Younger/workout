package com.jonathanyoung.workout.repository;

import org.springframework.data.repository.CrudRepository;

import com.jonathanyoung.workout.model.WorkoutExercise;

public interface WorkoutExerciseRepository extends CrudRepository<WorkoutExercise, Long>{
  
}
