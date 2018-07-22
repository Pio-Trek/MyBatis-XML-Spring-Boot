package com.sundaydevblog.springmybatistest.service;

import com.sundaydevblog.springmybatistest.dao.UserDao;
import com.sundaydevblog.springmybatistest.dto.UserDto;
import com.sundaydevblog.springmybatistest.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserDto> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public UserDto getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void create(String name, String email, String mobile) {
        userDao.create(name, email, mobile);
    }

    @Override
    public void update(Long id, String name, String email, String mobile) {
        userDao.update(id, name, email, mobile);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
