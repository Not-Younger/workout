package com.jonathanyoung.workout.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathanyoung.workout.model.ExerciseType;
import com.jonathanyoung.workout.repository.ExerciseTypeRepository;

@Service
public class ExerciseTypeService {

  private final ExerciseTypeRepository exerciseTypeRepository;

  public ExerciseTypeService(ExerciseTypeRepository exerciseTypeRepository) {
    this.exerciseTypeRepository = exerciseTypeRepository;
  }

  public ExerciseType getExerciseType(Long id) {
    return exerciseTypeRepository.findById(id).orElseThrow();
  }

  public List<ExerciseType> getExerciseTypes() {
    return exerciseTypeRepository.findAll();
  }

  public ExerciseType addExerciseType(String name, String description) {
    ExerciseType exerciseType = new ExerciseType(name, description);
    return exerciseTypeRepository.save(exerciseType);
  }

  public ExerciseType updateExerciseType(Long id, String name, String description) {
    ExerciseType exerciseType = exerciseTypeRepository.findById(id).orElseThrow();
    exerciseType.setName(name);
    exerciseType.setDescription(description);
    ExerciseType updatedExerciseType = exerciseTypeRepository.save(exerciseType);
    return updatedExerciseType;
  }

  public String deleteExerciseType(Long id) {
    exerciseTypeRepository.deleteById(id);
    return "Deleted exercise type with id : " + id;
  }
}
