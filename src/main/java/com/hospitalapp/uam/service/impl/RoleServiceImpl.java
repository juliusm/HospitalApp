package com.hospitalapp.uam.service.impl;

import com.hospitalapp.commons.Exception.EntryNotFoundException;
import com.hospitalapp.uam.dao.RoleDAO;
import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

    private RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO){
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> list() {
        return roleDAO.list();
    }

    @Override
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Override
    public Role findById(long id) {
        return roleDAO.findById(id);
    }

    public void update(Role role) throws EntryNotFoundException{
        Role persistedRole = roleDAO.findById(role.getId());
        if(persistedRole == null){
            throw new EntryNotFoundException("Role doesn't exist");
        }
        persistedRole.setModules(role.getModules());
        roleDAO.update(persistedRole);
    }
}
