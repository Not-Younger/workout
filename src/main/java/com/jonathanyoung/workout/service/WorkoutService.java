package com.jonathanyoung.workout.service;

import org.springframework.stereotype.Service;

import com.jonathanyoung.workout.model.User;
import com.jonathanyoung.workout.model.Workout;
import com.jonathanyoung.workout.repository.WorkoutRepository;

@Service
public class WorkoutService {

  private final UserService userService;
  private final WorkoutRepository workoutRepository;

  public WorkoutService(UserService userService, WorkoutRepository workoutRepository) {
    this.userService = userService;
    this.workoutRepository = workoutRepository;
  }

  public Workout getWorkout(Long id) {
    return workoutRepository.findById(id).orElse(null);
  }

  public Workout createWorkout(Long userId, String title, String notes) {
    User user = userService.getUser(userId);
    Workout workout = new Workout(title, notes);
    user.addWorkout(workout);
    workoutRepository.save(workout);
    return workout;
  }

  public Workout updateWorkout(Long id, String title, String notes) {
    Workout workout = workoutRepository.findById(id).orElseThrow();
    workout.setTitle(title);
    workout.setNotes(notes);
    Workout updatedWorkout = workoutRepository.save(workout);
    return updatedWorkout;
  }

  public String deleteWorkout(Long id) {
    workoutRepository.deleteById(id);
    return "Deleted workout with id : " + id;
  }
  
}
