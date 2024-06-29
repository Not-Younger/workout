package com.jonathanyoung.workout.service;

import org.springframework.stereotype.Service;

import com.jonathanyoung.workout.dto.ExerciseDto;
import com.jonathanyoung.workout.dto.WorkoutDto;
import com.jonathanyoung.workout.mapper.ExerciseMapper;
import com.jonathanyoung.workout.mapper.WorkoutMapper;
import com.jonathanyoung.workout.model.Exercise;
import com.jonathanyoung.workout.model.Workout;
import com.jonathanyoung.workout.model.WorkoutExercise;
import com.jonathanyoung.workout.repository.WorkoutExerciseRepository;

@Service
public class WorkoutExerciseService {

  private final WorkoutExerciseRepository workoutExerciseRepository;

  private final WorkoutService workoutService;
  private final ExerciseService exerciseService;
  
  public WorkoutExerciseService(WorkoutExerciseRepository workoutExerciseRepository, WorkoutService workoutService, ExerciseService exerciseService) {
    this.workoutExerciseRepository = workoutExerciseRepository;
    this.workoutService = workoutService;
    this.exerciseService = exerciseService;
  }

  public String addExerciseToWorkout(String ExerciseName, String WorkoutName) {
    ExerciseDto exerciseDto = exerciseService.getByName(ExerciseName);
    Exercise exercise = ExerciseMapper.mapToExercise(exerciseDto);

    WorkoutDto workoutDto = workoutService.getByTitle(WorkoutName);
    Workout workout = WorkoutMapper.mapToWorkout(workoutDto);

    WorkoutExercise workoutExercise = new WorkoutExercise(exercise.getId(), workout.getId());
    workoutExerciseRepository.save(workoutExercise);

    return "Added " + exercise.getName() + " to " + workout.getTitle() + "!";
  }
}
