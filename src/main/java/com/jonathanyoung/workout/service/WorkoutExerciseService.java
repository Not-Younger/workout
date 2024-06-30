package com.jonathanyoung.workout.service;

import org.springframework.stereotype.Service;

import com.jonathanyoung.workout.exception.NotFoundException;
import com.jonathanyoung.workout.model.WorkoutExercise;
import com.jonathanyoung.workout.repository.WorkoutExerciseRepository;

@Service
public class WorkoutExerciseService {

  private final WorkoutExerciseRepository workoutExerciseRepository;
  
  public WorkoutExerciseService(WorkoutExerciseRepository workoutExerciseRepository, WorkoutService workoutService, ExerciseService exerciseService) {
    this.workoutExerciseRepository = workoutExerciseRepository;
  }

  public String add(Long exerciseId, Long workoutId, Integer sets, Integer reps, Float weight, Integer rest) {
    WorkoutExercise workoutExercise = new WorkoutExercise(null, exerciseId, workoutId, sets, reps, weight, rest);
    WorkoutExercise createdExerciseWorkout = workoutExerciseRepository.save(workoutExercise);
    return "Added exercise with id : " + exerciseId + " to workout with id : " + workoutId + " on table workout_exercise with id : " + createdExerciseWorkout.getId();
  }

  public String update(Long id, Long exerciseId, Long workoutId) {
    WorkoutExercise workoutExercise = workoutExerciseRepository.findById(id).orElseThrow(() -> new NotFoundException("WorkoutExercise not found with id : " + id));
    workoutExercise.setWorkoutId(workoutId);
    workoutExercise.setExerciseId(exerciseId);
    workoutExerciseRepository.save(workoutExercise);
    return "WorkoutExercise with id : " + id + " updated to have exercise_id : " + exerciseId + " and workout_id : " + workoutId; 
  }
}
