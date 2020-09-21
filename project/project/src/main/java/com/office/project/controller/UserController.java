package com.office.project.controller;

import com.office.project.dto.UserDTO;
import com.office.project.model.User;
import com.office.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO) {
        LOGGER.info("Receiving user registration request...");

        return this.userService.save(userDTO);
    }

    @GetMapping
    public List<User> getAllUsers() {
        LOGGER.info("Searching for all users...");

        return this.userService.getAllUsers();
    }
}
