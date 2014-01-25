package com.hospitalapp.uam.service;

import com.hospitalapp.commons.Exception.EntryNotFoundException;
import com.hospitalapp.uam.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> list();

    void save(Role role);

    Role findById(long id);

    void update(Role role) throws EntryNotFoundException;
}
