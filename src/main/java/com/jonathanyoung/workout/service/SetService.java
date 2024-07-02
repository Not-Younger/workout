package com.jonathanyoung.workout.service;

import org.springframework.stereotype.Service;

import com.jonathanyoung.workout.model.Exercise;
import com.jonathanyoung.workout.model.Set;
import com.jonathanyoung.workout.repository.SetRepository;

@Service
public class SetService {
  
  private final SetRepository setRepository;

  private final ExerciseService exerciseService;

  public SetService(SetRepository setRepository, ExerciseService exerciseService) {
    this.setRepository = setRepository;
    this.exerciseService = exerciseService;
  }

  public Set createSet(Long exerciseId) {
    Exercise exercise = exerciseService.getExercise(exerciseId);
    Set set = new Set();
    exercise.addSet(set);
    Set createdSet = setRepository.save(set);
    return createdSet;
  }

  public Set updateSet(Long id, int reps, int weight, int rest) {
    Set set = setRepository.findById(id).orElseThrow();
    set.setReps(reps);
    set.setWeight(weight);
    set.setRest(rest);
    Set updatedSet = setRepository.save(set);
    return updatedSet;
  }

  public String deleteSet(Long id) {
    setRepository.deleteById(id);
    return "Deleted set with id : " + id;
  }

}
