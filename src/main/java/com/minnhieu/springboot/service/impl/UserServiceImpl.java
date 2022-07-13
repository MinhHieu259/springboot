package com.minnhieu.springboot.service.impl;

import com.minnhieu.springboot.model.Role;
import com.minnhieu.springboot.model.User;
import com.minnhieu.springboot.repository.RoleRepository;
import com.minnhieu.springboot.repository.UserRepository;
import com.minnhieu.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        user.setRole(roleRepository.findById(user.getRole().getId()).get());
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
        return "User Delete SuccessFully";
    }

    @Override
    public List<Role> roleList() {
        return roleRepository.findAll();
    }
}
