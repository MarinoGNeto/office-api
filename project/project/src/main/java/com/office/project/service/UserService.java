package com.office.project.service;

import com.office.project.dto.UserDTO;
import com.office.project.model.User;
import com.office.project.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final IUserRepository userRepository;


    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserDTO userDTO) {

        this.validate(userDTO);

        LOGGER.info("Registering user...");
        LOGGER.debug("UserDTO: {}", userDTO);

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUserType(userDTO.getUserType());

        user = this.userRepository.save(user);

        LOGGER.info("User of name: {}", userDTO.getName(), " registered!");

        return UserDTO.of(user);
    }

    private void validate(UserDTO userDTO) {

        LOGGER.info("Validating user...");

        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null.");
        }

        if (StringUtils.isEmpty(userDTO.getEmail())) {
            throw new IllegalArgumentException("Email cannot be null/empty.");
        }

        if (StringUtils.isEmpty(userDTO.getPassword())) {
            throw new IllegalArgumentException("Password cannot be null/empty.");
        }

        if (StringUtils.isEmpty(userDTO.getUserType())) {
            throw new IllegalArgumentException("User type cannot be null/empty.");
        }
    }


    public List<User> getAllUsers() {
        List<User> user = this.userRepository.findAll();

        return user;
    }
}
