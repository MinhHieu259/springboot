package com.minnhieu.springboot.service;

import com.minnhieu.springboot.model.Role;
import com.minnhieu.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> userList();
    User findOne(Long id);
    User addUser(User user);
    String deleteUser(Long id);
    List<Role> roleList();
}
