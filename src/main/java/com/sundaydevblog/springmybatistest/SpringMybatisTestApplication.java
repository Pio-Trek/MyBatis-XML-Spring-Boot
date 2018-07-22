package com.sundaydevblog.springmybatistest;

import com.sundaydevblog.springmybatistest.controller.UserController;
import com.sundaydevblog.springmybatistest.dto.UserDto;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sundaydevblog.springmybatistest.dao")
public class SpringMybatisTestApplication implements CommandLineRunner {

    private final UserController userController;

    @Autowired
    public SpringMybatisTestApplication(UserController userController) {
        this.userController = userController;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisTestApplication.class, args);
    }


    @Override
    public void run(String... args) {

        /*
         * Add new users
         */
        System.out.print("\n");
        System.out.println("Create users --------->>>>>>>");
        userController.crateUser("John Bravo", "jbravo@eds.com", "04324323287");
        userController.crateUser("Abi Hoode", "abi.hoode@willsq.com", "04324323287");
        userController.crateUser("Herbert M. Ridley", "HerbertMRidley@jourrapide.com", "713-519-6530");

        // This should throw an exception -> name is empty
        userController.crateUser("", "abc@test.com", "07927139172");

        /*
         * Fetch all users
         */
        System.out.print("\n");
        System.out.println("Get users --------->>>>>>>");
        for (UserDto user : userController.fetchUsers()) {
            System.out.println(user);
        }

        /*
         * Fetch single user
         */
        System.out.print("\n");
        System.out.println("Get single user --------->>>>>>>");
        UserDto user3 = userController.fetchUserById(3L);
        System.out.println(user3);

        /*
         * Update user
         */
        System.out.print("\n");
        System.out.println("Update user --------->>>>>>>");
        userController.updateUser(2L, "aaa", "bb@asd.com", "12321321");

        /*
         * Delete user
         */
        System.out.print("\n");
        System.out.println("Delete user --------->>>>>>>");
        userController.deleteUser(1L);

        /*
         * Fetch users after a changes
         */
        System.out.print("\n");
        System.out.println("Get users after a changes --------->>>>>>>");
        for (UserDto user : userController.fetchUsers()) {
            System.out.println(user);
        }
    }
}
