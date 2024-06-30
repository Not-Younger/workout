package com.jonathanyoung.workout.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.jonathanyoung.workout.service.WorkoutExerciseService;

@Controller
public class WorkoutExerciseController {

  private final WorkoutExerciseService workoutExerciseService;

  public WorkoutExerciseController(WorkoutExerciseService workoutExerciseService) {
    this.workoutExerciseService = workoutExerciseService;
  }

  @MutationMapping
  public String addExerciseToWorkout(@Argument Long exerciseId, @Argument Long workoutId, @Argument Integer sets, @Argument Integer reps, @Argument Float weight, @Argument Integer rest) {
    return workoutExerciseService.add(exerciseId, workoutId, sets, reps, weight, rest);
  }

  @MutationMapping
  public String updateExerciseWorkout(@Argument Long id, @Argument Long exerciseId, @Argument Long workoutId) {
    return workoutExerciseService.update(id, exerciseId, workoutId);
  }
  
}
