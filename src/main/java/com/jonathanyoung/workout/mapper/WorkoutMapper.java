package com.jonathanyoung.workout.mapper;

import com.jonathanyoung.workout.dto.WorkoutDto;
import com.jonathanyoung.workout.model.Workout;

public class WorkoutMapper {
 
    public static Workout mapToWorkout(WorkoutDto workoutDto) {
      return new Workout(
        workoutDto.id(),
        workoutDto.title(),
        workoutDto.notes()
      );
    }

    public static WorkoutDto mapToWorkoutDto(Workout workout) {
      return new WorkoutDto(
        workout.getId(),
        workout.getTitle(),
        workout.getNotes()
      );
    }

}
