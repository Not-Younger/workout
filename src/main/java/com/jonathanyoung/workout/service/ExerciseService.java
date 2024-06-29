package com.jonathanyoung.workout.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathanyoung.workout.dto.ExerciseDto;
import com.jonathanyoung.workout.exception.NotFoundException;
import com.jonathanyoung.workout.mapper.ExerciseMapper;
import com.jonathanyoung.workout.model.Exercise;
import com.jonathanyoung.workout.repository.ExerciseRepository;

@Service
public class ExerciseService {
  
  private final ExerciseRepository exerciseRepository;

  public ExerciseService(ExerciseRepository exerciseRepository) {
    this.exerciseRepository = exerciseRepository;
  }

  public ExerciseDto getById(Long id) {
    Exercise exercise = exerciseRepository.findById(id).orElseThrow(() -> new NotFoundException("Exercise not found with id : " + id));
    return ExerciseMapper.mapToExerciseDto(exercise);
  }

  public List<ExerciseDto> getAll() {
    List<Exercise> exercises = new ArrayList<>();
    exerciseRepository.findAll().forEach(exercises::add);
    return exercises.stream().map(ExerciseMapper::mapToExerciseDto).toList();
  }

  public ExerciseDto create(ExerciseDto exerciseDto) {
    Exercise exercise = ExerciseMapper.mapToExercise(exerciseDto);
    Exercise createdExercise = exerciseRepository.save(exercise);
    return ExerciseMapper.mapToExerciseDto(createdExercise);
  }

}
