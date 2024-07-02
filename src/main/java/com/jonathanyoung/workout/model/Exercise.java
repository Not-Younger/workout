package com.jonathanyoung.workout.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "workout_id")
  private Workout workout;
  
  @ManyToOne
  @JoinColumn(name = "exercise_type_id")
  private ExerciseType exerciseType;

  @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Set> sets = new ArrayList<>();

  public Exercise() {
  }

  public Exercise(ExerciseType exerciseType) {
    this.exerciseType = exerciseType;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public ExerciseType getExerciseType() {
    return exerciseType;
  }
  public void setExerciseType(ExerciseType exerciseType) {
    this.exerciseType = exerciseType;
  }
  public List<Set> getSets() {
    return sets;
  }
  public void setSets(List<Set> sets) {
    this.sets = sets;
  }
  public Workout getWorkout() {
    return workout;
  }
  public void setWorkout(Workout workout) {
    this.workout = workout;
  }

  public void addSet(Set set) {
    sets.add(set);
    set.setExercise(this);
  }
  public void removeSet(Set set) {
    sets.remove(set);
    set.setExercise(null);
  }
}
