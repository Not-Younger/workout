package com.jonathanyoung.workout.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathanyoung.workout.model.User;
import com.jonathanyoung.workout.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUser(Long id) {
    return userRepository.findById(id).orElseThrow();
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User createUser(String username, String email) {
    User user = new User(username, email);
    return userRepository.save(user);
  }

  public User updateUser(Long id, String username, String email) {
    User user = userRepository.findById(id).orElseThrow();
    user.setUsername(username);
    user.setEmail(email);
    User updatedUser = userRepository.save(user);
    return updatedUser;
  }

  public String deleteUser(Long id) {
    userRepository.deleteById(id);
    return "Deleted user with id : " + id;
  }
  
}
