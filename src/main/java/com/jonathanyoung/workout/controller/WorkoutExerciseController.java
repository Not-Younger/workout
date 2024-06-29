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
  public String addExerciseToWorkout(@Argument String exerciseName, @Argument String workoutName) {
    return workoutExerciseService.addExerciseToWorkout(exerciseName, workoutName);
  }
  
}
