package com.hospitalapp.uam.dao;

import com.hospitalapp.uam.domain.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> list();

    void save(Role role);

    Role findById(long id);

    void update(Role role);
}
