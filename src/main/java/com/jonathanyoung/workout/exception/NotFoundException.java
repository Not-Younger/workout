package com.jonathanyoung.workout.exception;

public class NotFoundException extends RuntimeException {
  
  public NotFoundException(String message) {
    super(message);
  }
}
