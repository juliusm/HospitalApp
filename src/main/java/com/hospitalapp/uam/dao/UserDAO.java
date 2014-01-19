package com.hospitalapp.uam.dao;

import com.hospitalapp.uam.domain.User;

public interface UserDAO {

    User findByUsername(String username);
}
