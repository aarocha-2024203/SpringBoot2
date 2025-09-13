package com.aarocha.sportfinal.service;

import com.aarocha.sportfinal.model.User;
import jakarta.persistence.Id;

import java.util.List;

public interface UserService {
    List<User>getAllUsers();
    User getUserById (Integer id);
    User saveUser(User user);
    User updateUser(Integer id, User user);
    void deleteUser(Integer id);
}
