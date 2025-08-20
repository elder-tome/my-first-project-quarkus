package com.eldertome.services;

import java.util.List;
import java.util.UUID;

import com.eldertome.entity.User;
import com.eldertome.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserServices {

  @Inject
  private UserRepository userRepository;

  public User addUser(User user) {
    userRepository.persist(user);
    return user;
  }

  public List<User> findAllUsers(int page, int size) {
    return userRepository.findAll().page(page, size).list();
  }

  public User findUserById(UUID id) {
    return userRepository.findById(id);
  }
  
}
