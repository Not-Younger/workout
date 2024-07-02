package com.jonathanyoung.workout.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathanyoung.workout.model.Exercise;
import com.jonathanyoung.workout.model.ExerciseType;
import com.jonathanyoung.workout.model.Workout;
import com.jonathanyoung.workout.repository.ExerciseRepository;

@Service
public class ExerciseService {

  private final ExerciseRepository exerciseRepository;

  private final WorkoutService workoutService;
  private final ExerciseTypeService exerciseTypeService;

  public ExerciseService(ExerciseRepository exerciseRepository, WorkoutService workoutService, ExerciseTypeService exerciseTypeService) {
    this.exerciseRepository = exerciseRepository;
    this.workoutService = workoutService;
    this.exerciseTypeService = exerciseTypeService;
  }

  public Exercise getExercise(Long id) {
    return exerciseRepository.findById(id).orElse(null);
  }

  public List<Exercise> getExercises(Long workoutId) {
    return exerciseRepository.findAll();
  }

  public Exercise addExercise(Long workoutId, Long exerciseTypeId) {
    Workout workout = workoutService.getWorkout(workoutId);
    ExerciseType exerciseType = exerciseTypeService.getExerciseType(exerciseTypeId);
    Exercise exercise = new Exercise(exerciseType);
    workout.addExercise(exercise);
    Exercise createdExercise = exerciseRepository.save(exercise);
    return createdExercise;
  }

  public Exercise updateExercise(Long id, Long exerciseTypeId) {
    Exercise exercise = exerciseRepository.findById(id).orElseThrow();
    ExerciseType exerciseType = exerciseTypeService.getExerciseType(exerciseTypeId);
    exercise.setExerciseType(exerciseType);
    Exercise updatedExercise = exerciseRepository.save(exercise);
    return updatedExercise;
  }

  public String deleteExercise(Long id) {
    exerciseRepository.deleteById(id);
    return "Deleted exercise with id : " + id;
  }

  
}
