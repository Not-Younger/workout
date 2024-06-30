package com.jonathanyoung.workout.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String email;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Workout> workouts = new ArrayList<>();

  public User() {
  }

  public User(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public List<Workout> getWorkouts() {
    return workouts;
  }
  public void setWorkouts(List<Workout> workouts) {
    this.workouts = workouts;
  }
  public void addWorkout(Workout workout) {
    workouts.add(workout);
    workout.setUser(this);
  }
  public void removeWorkout(Workout workout) {
    workouts.remove(workout);
    workout.setUser(null);
  }
  

}
