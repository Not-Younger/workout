package com.jonathanyoung.workout.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.jonathanyoung.workout.model.User;
import com.jonathanyoung.workout.service.UserService;

@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @QueryMapping
  public User user(@Argument Long id) {
    return userService.getUser(id);
  }

  @QueryMapping
  public List<User> users() {
    return userService.getUsers();
  }

  @MutationMapping
  public User createUser(@Argument String username, @Argument String email) {
    return userService.createUser(username, email);
  }

  @MutationMapping
  public User updateUser(@Argument Long id, @Argument String username, @Argument String email) {
    return userService.updateUser(id, username, email);
  }

  @MutationMapping
  public String deleteUser(@Argument Long id) {
    return userService.deleteUser(id);
  }
  
}
