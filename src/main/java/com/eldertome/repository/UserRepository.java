package com.eldertome.repository;

import java.util.UUID;

import com.eldertome.entity.User;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, UUID> {

  // This class can be left empty as PanacheRepositoryBase provides all necessary
  // methods
  // for basic CRUD operations. You can add custom methods if needed.

  // Example of a custom method:
  // public List<User> findByName(String name) {
  // return find("name", name).list();
  // }

}
