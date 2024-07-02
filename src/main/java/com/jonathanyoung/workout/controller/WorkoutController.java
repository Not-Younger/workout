package com.jonathanyoung.workout.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.jonathanyoung.workout.model.Workout;
import com.jonathanyoung.workout.service.WorkoutService;

@Controller
public class WorkoutController {

  private final WorkoutService workoutService;

  public WorkoutController(WorkoutService workoutService) {
    this.workoutService = workoutService;
  }

  @MutationMapping
  public Workout createWorkout(@Argument Long userId, @Argument String title, @Argument String notes) {
    return workoutService.createWorkout(userId, title, notes);
  }

  @MutationMapping
  public Workout updateWorkout(@Argument Long id, @Argument String title, @Argument String notes) {
    return workoutService.updateWorkout(id, title, notes);
  }

  @MutationMapping
  public String deleteWorkout(@Argument Long id) {
    return workoutService.deleteWorkout(id);
  }
  
}
