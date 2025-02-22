package com.jonathanyoung.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonathanyoung.workout.model.ExerciseType;

@Repository
public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Long> {
  
}
