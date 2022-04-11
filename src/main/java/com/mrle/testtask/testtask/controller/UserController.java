package com.mrle.testtask.testtask.controller;

import java.util.List;

import com.mrle.testtask.testtask.entity.User;
import com.mrle.testtask.testtask.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*
     * Create and update can be one endpoint with name "save" if write in User
     * entity that id is auto generated. I did two because in task write that should
     * be "create" AND "update"
     */
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) {
        if (user.id != null) {
            return userService.update(user);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User should have id");
        }
    }

    @PostMapping("/delete")
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
}
