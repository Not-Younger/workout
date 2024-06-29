package com.jonathanyoung.workout.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathanyoung.workout.dto.WorkoutDto;
import com.jonathanyoung.workout.exception.NotFoundException;
import com.jonathanyoung.workout.mapper.WorkoutMapper;
import com.jonathanyoung.workout.model.Workout;
import com.jonathanyoung.workout.repository.WorkoutRepository;

@Service
public class WorkoutService {
  
  private final WorkoutRepository workoutRepository;
  
  public WorkoutService(WorkoutRepository workoutRepository) {
    this.workoutRepository = workoutRepository;
  }

  public WorkoutDto getById(Long id) {
    Workout workout = workoutRepository.findById(id).orElseThrow(() -> new NotFoundException("Workout not found with id : " + id));
    return WorkoutMapper.mapToWorkoutDto(workout);
  }

  public WorkoutDto getByTitle(String title) {
    Workout workout = workoutRepository.findByTitle(title).orElseThrow(() -> new NotFoundException("Workout not found with name : " + title));
    return WorkoutMapper.mapToWorkoutDto(workout);
  }

  public List<WorkoutDto> getAll() {
    List<Workout> workouts = new ArrayList<>();
    workoutRepository.findAll().forEach(workouts::add);
    return workouts.stream().map(WorkoutMapper::mapToWorkoutDto).toList();
  }

  public WorkoutDto create(WorkoutDto workoutDto) {
    Workout workout = WorkoutMapper.mapToWorkout(workoutDto);
    Workout createdWorkout = workoutRepository.save(workout);
    return WorkoutMapper.mapToWorkoutDto(createdWorkout);
  }

}
