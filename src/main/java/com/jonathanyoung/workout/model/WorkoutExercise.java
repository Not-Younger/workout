package com.jonathanyoung.workout.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "workout_exercise")
public class WorkoutExercise {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "workout_id")
  private Long workoutId;

  @Column(name = "exercise_id")
  private Long exerciseId;

  private Integer sets;
  private Integer reps;
  private Integer weight;
  private Integer rest;

  public WorkoutExercise() {
  }

  public WorkoutExercise(Long exerciseId, Long workoutId) {
    this.exerciseId = exerciseId;
    this.workoutId = workoutId;
  }

  public WorkoutExercise(Long id, Long workoutId, Long exerciseId, Integer sets, Integer reps, Integer weight, Integer rest) {
    this.id = id;
    this.workoutId = workoutId;
    this.exerciseId = exerciseId;
    this.sets = sets;
    this.reps = reps;
    this.weight = weight;
    this.rest = rest;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getWorkoutId() {
    return workoutId;
  }
  public void setWorkoutId(Long workoutId) {
    this.workoutId = workoutId;
  }
  public Long getExerciseId() {
    return exerciseId;
  }
  public void setExerciseId(Long exerciseId) {
    this.exerciseId = exerciseId;
  }
  public Integer getSets() {
    return sets;
  }
  public void setSets(Integer sets) {
    this.sets = sets;
  }
  public Integer getReps() {
    return reps;
  }
  public void setReps(Integer reps) {
    this.reps = reps;
  }
  public Integer getWeight() {
    return weight;
  }
  public void setWeight(Integer weight) {
    this.weight = weight;
  }
  public Integer getRest() {
    return rest;
  }
  public void setRest(Integer rest) {
    this.rest = rest;
  }

  @Override
  public String toString() {
    return "WorkoutExercise [id=" + id + ", workoutId=" + workoutId + ", exerciseId=" + exerciseId + ", reps=" + reps + ", rest=" + rest + ", sets="
        + sets + ", weight=" + weight + "]";
  }
}
