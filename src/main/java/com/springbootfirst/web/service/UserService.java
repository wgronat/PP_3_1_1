package com.springbootfirst.web.service;

import com.springbootfirst.web.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User findUserByID(long id);

    void delete(long id);
}
