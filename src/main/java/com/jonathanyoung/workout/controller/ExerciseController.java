package com.jonathanyoung.workout.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jonathanyoung.workout.dto.ExerciseDto;
import com.jonathanyoung.workout.service.ExerciseService;

@Controller
public class ExerciseController {
  
  private final ExerciseService exerciseService;

  public ExerciseController(ExerciseService exerciseService) {
    this.exerciseService = exerciseService;
  }

  @QueryMapping
  public ExerciseDto findExerciseById(@Argument Long id) {
    return exerciseService.getById(id);
  }

  @QueryMapping
  public List<ExerciseDto> findAllExercises() {
    return exerciseService.getAll();
  }

  @MutationMapping
  public ExerciseDto createExercise(@Argument String name, @Argument String instruction) {
    ExerciseDto exerciseDto = new ExerciseDto(null, name, instruction);
    return exerciseService.create(exerciseDto);
  }

}
