package com.jonathanyoung.workout.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.jonathanyoung.workout.model.Exercise;
import com.jonathanyoung.workout.service.ExerciseService;

@Controller
public class ExerciseController {

  private final ExerciseService exerciseService;

  public ExerciseController(ExerciseService exerciseService) {
    this.exerciseService = exerciseService;
  }

  // @QueryMapping
  // public Exercise exercise(@Argument Long id) {
  //   return exerciseService.getExercise(id);
  // }

  // @QueryMapping
  // public List<Exercise> exercises(@Argument Long workoutId) {
  //   return exerciseService.getExercises(workoutId);
  // }

  @MutationMapping
  public Exercise createExercise(@Argument Long workoutId, @Argument Long exerciseTypeId) {
    return exerciseService.addExercise(workoutId, exerciseTypeId);
  }

  @MutationMapping
  public Exercise updateExercise(@Argument Long id, @Argument Long exerciseTypeId) {
    return exerciseService.updateExercise(id, exerciseTypeId);
  }

  @MutationMapping
  public String deleteExercise(@Argument Long id) {
    return exerciseService.deleteExercise(id);
  }
  
}
