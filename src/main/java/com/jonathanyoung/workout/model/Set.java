package com.jonathanyoung.workout.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sets")
public class Set {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int reps;
  private int weight;
  private int rest;

  @ManyToOne
  @JoinColumn(name = "exercise_id")
  private Exercise exercise;
  
  public Set() {
  }
  
  public Set(int reps, int weight, int rest) {
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
  public int getReps() {
    return reps;
  }
  public void setReps(int reps) {
    this.reps = reps;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }
  public int getRest() {
    return rest;
  }
  public void setRest(int rest) {
    this.rest = rest;
  }
  public Exercise getExercise() {
    return exercise;
  }
  public void setExercise(Exercise exercise) {
    this.exercise = exercise;
  }
}
