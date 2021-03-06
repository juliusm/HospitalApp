package com.hospitalapp.uam.dao;

import com.hospitalapp.uam.domain.User;

import java.util.List;

public interface UserDAO {

    List<User> list();

    User findById(long id);

    User findByUsername(String username);

    void save(User user);

    void update(User user);

    void delete(User user);
}
