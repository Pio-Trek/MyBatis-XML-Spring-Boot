package com.sundaydevblog.springmybatistest.service.interfaces;

import com.sundaydevblog.springmybatistest.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();

    UserDto getUserById(Long id);

    void create(String name, String email, String mobile);

    void update(Long id, String name, String email, String mobile);

    void delete(Long id);
}
