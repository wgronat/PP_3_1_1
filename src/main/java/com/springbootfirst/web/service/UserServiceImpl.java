package com.springbootfirst.web.service;

import com.springbootfirst.web.models.User;
import com.springbootfirst.web.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserByID(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
