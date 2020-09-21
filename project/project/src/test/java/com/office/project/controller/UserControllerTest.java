package com.office.project.controller;

import com.office.project.dto.UserDTO;
import com.office.project.enums.UserType;
import com.office.project.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@SpringBootTest
public class UserControllerTest {

    @Autowired UserController userController;

    @MockBean
    private UserService userService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.userController);
    }

    @Test
    public void registerUserTest() {

        UserDTO userDTO = mock(UserDTO.class);

        when(this.userService.save(userDTO))
                .thenReturn(new UserDTO("Tester", "tester@gmail.com", "12345", UserType.REQUESTER)
                );
    }
}
