package com.mrle.testtask.testtask.service;

import java.util.List;
import java.util.UUID;

import com.mrle.testtask.testtask.entity.User;
import com.mrle.testtask.testtask.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /*
     * Create and update can be one endpoint with name "save" if write in User
     * entity that id is auto generated. I did two because in task write that should
     * be "create" AND "update"
     */
    public User create(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    public User update(User user) {
        
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
