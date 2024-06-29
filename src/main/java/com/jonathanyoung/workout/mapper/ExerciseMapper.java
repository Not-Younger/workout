package com.jonathanyoung.workout.mapper;

import com.jonathanyoung.workout.dto.ExerciseDto;
import com.jonathanyoung.workout.model.Exercise;

public class ExerciseMapper {
 
  public static Exercise mapToExercise(ExerciseDto exerciseDto) {
    return new Exercise(
      exerciseDto.id(),
      exerciseDto.name(),
      exerciseDto.instruction()
    );
  }
  
  public static ExerciseDto mapToExerciseDto(Exercise exercise) {
    return new ExerciseDto(
      exercise.getId(),
      exercise.getName(),
      exercise.getInstruction()
    );
  }

}
