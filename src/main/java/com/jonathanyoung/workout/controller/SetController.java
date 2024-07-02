package com.jonathanyoung.workout.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.jonathanyoung.workout.model.Set;
import com.jonathanyoung.workout.service.SetService;

@Controller
public class SetController {
  
  private final SetService setService;

  public SetController(SetService setService) {
    this.setService = setService;
  }

  @MutationMapping
  public Set createSet(@Argument Long exerciseId) {
    return setService.createSet(exerciseId);
  }

  @MutationMapping
  public Set updateSet(@Argument Long id, @Argument int reps, @Argument int weight, @Argument int rest) {
    return setService.updateSet(id, reps, weight, rest);
  }

  @MutationMapping
  public String deleteSet(@Argument Long id) {
    return setService.deleteSet(id);
  }
}
