package com.sundaydevblog.springmybatistest.controller;

import com.sundaydevblog.springmybatistest.dto.UserDto;
import com.sundaydevblog.springmybatistest.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<UserDto> fetchUsers() {
        return userService.getUsers();
    }

    public UserDto fetchUserById(Long id) {
        return userService.getUserById(id);
    }

    public void crateUser(String name, String email, String mobile) {

        try {
            if ("".equals(name)) {
                throw new Exception("Empty mandatory field - name");
            }
            if ("".equals(email)) {
                throw new Exception("Empty mandatory field - email");
            }
            if ("".equals(mobile)) {
                throw new Exception("Empty mandatory field - mobile");
            }

            userService.create(name, email, mobile);
            System.out.println("User: [" + name + ", " + email + ", " + mobile + "] -> Success: OK");

        } catch (Exception ex) {
            System.out.println("Error --> " + ex.getMessage());
        }

    }

    public void updateUser(Long id, String name, String email, String mobile) {

        try {
            if (id == null) {
                throw new Exception("Empty mandatory field - id");
            }
            if ("".equals(name)) {
                throw new Exception("Empty mandatory field - name");
            }
            if ("".equals(email)) {
                throw new Exception("Empty mandatory field - email");
            }
            if ("".equals(mobile)) {
                throw new Exception("Empty mandatory field - mobile");
            }

            userService.update(id, name, email, mobile);
            System.out.println("User: [" + id + ", " + name + ", " + email + ", " + mobile + "] -> Update: OK");

        } catch (Exception ex) {
            System.out.println("Error --> " + ex.getMessage());
        }
    }

    public void deleteUser(Long id) {
        try {
            userService.delete(id);
            System.out.println("User ID: [" + id + "] -> Delete: OK");

        } catch (Exception ex) {
            System.out.println("Error --> " + ex.getMessage());
        }
    }
}
