package com.hospitalapp.uam.service.impl;

import com.hospitalapp.commons.exception.EntryNotFoundException;
import com.hospitalapp.uam.dao.RoleDAO;
import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

    private RoleDAO roleDAO;

    private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class.getName());

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

    @Override
    @CacheEvict(value = "allowedUrls", allEntries = true)
    public void update(Role role) throws EntryNotFoundException{
        Role persistedRole = roleDAO.findById(role.getId());
        if(persistedRole == null){
            throw new EntryNotFoundException("Role doesn't exist");
        }
        persistedRole.setModules(role.getModules());
        roleDAO.update(persistedRole);
    }
}
