package com.jonathanyoung.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonathanyoung.workout.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

