package com.jonathanyoung.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonathanyoung.workout.model.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}

