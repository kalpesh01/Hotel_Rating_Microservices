package com.userservice.service;

import com.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUsers();

    public User getUserById(Integer id);
}
