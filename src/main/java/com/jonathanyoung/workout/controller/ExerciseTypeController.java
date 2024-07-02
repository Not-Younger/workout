package com.jonathanyoung.workout.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jonathanyoung.workout.model.ExerciseType;
import com.jonathanyoung.workout.service.ExerciseTypeService;

@Controller
public class ExerciseTypeController {

  private final ExerciseTypeService exerciseTypeService;

  public ExerciseTypeController(ExerciseTypeService exerciseTypeService) {
    this.exerciseTypeService = exerciseTypeService;
  }

  @QueryMapping
  public ExerciseType exerciseType(@Argument Long id) {
    return exerciseTypeService.getExerciseType(id);
  }

  @QueryMapping
  public List<ExerciseType> exerciseTypes() {
    return exerciseTypeService.getExerciseTypes();
  }

  @MutationMapping
  public ExerciseType addExerciseType(@Argument String name, @Argument String description) {
    return exerciseTypeService.addExerciseType(name, description);
  }

  @MutationMapping
  public ExerciseType updateExerciseType(@Argument Long id, @Argument String name, @Argument String description) {
    return exerciseTypeService.updateExerciseType(id, name, description);
  }

  @MutationMapping
  public String deleteExerciseType(@Argument Long id) {
    return exerciseTypeService.deleteExerciseType(id);
  }
}
