package com.jonathanyoung.workout.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonathanyoung.workout.model.Exercise;

@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
  
  public Optional<Exercise> findByName(String name);

}
