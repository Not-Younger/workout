package com.jonathanyoung.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonathanyoung.workout.model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
  
}
