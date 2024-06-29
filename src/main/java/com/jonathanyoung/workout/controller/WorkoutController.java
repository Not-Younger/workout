package com.jonathanyoung.workout.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jonathanyoung.workout.dto.WorkoutDto;
import com.jonathanyoung.workout.service.WorkoutService;

@Controller
public class WorkoutController {
  
  private final WorkoutService workoutService;

  public WorkoutController(WorkoutService workoutService) {
    this.workoutService = workoutService;
  }

  @QueryMapping
  public WorkoutDto findWorkoutById(@Argument Long id) {
    return workoutService.getById(id);
  }

  @QueryMapping
  public List<WorkoutDto> findAllWorkouts() {
    return workoutService.getAll();
  }

  @MutationMapping
  public WorkoutDto createWorkout(@Argument String title, @Argument String notes) {
    WorkoutDto workoutDto = new WorkoutDto(null, title, notes);
    return workoutService.create(workoutDto);
  }
  
}
