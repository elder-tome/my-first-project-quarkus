package com.eldertome.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.eldertome.entity.User;
import com.eldertome.services.UserServices;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/api/users")
public class UserController {

  @Inject
  private UserServices userServices;

  @POST
  @Transactional
  public User insertUser(@Valid User payload) {
    User user = null;
    try {
      user = userServices.addUser(payload);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return user;
  }

  @GET
  public List<User> listUsers(
      @QueryParam("page") @DefaultValue("0") int page,
      @QueryParam("size") @DefaultValue("10") int size) {

    List<User> users = new ArrayList<>();

    try {
      users = userServices.findAllUsers(page, size);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return users;
  }

  @GET
  @Path("/{id}")
  public User listUserById(@PathParam("id") UUID id) {
    User user = null;

    try {
      user = userServices.findUserById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return user;
  }

}
