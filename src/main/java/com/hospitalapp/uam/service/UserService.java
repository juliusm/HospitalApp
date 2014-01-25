package com.hospitalapp.uam.service;

import com.hospitalapp.uam.domain.User;

import java.util.List;

public interface UserService{

    List<User> list();

    User findById(long id);

    void save(User user);

    void update(User user);

    void delete(User user);

}
