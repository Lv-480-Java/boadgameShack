package com.softserve.boardgameShack.service;

import com.softserve.boardgameShack.entity.User;

import java.util.List;

public interface UserService {

    List<User> getByName(String name);

    User getById(long id);

    List<User> getAll();

    void add(User model, String repeatPassword);

    void delete(User user);
}
