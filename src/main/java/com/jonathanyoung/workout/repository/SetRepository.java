package com.jonathanyoung.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jonathanyoung.workout.model.Set;

@Repository
public interface SetRepository extends JpaRepository<Set, Long> {
  
}
