package com.hospitalapp.uam.service.impl;

import com.hospitalapp.uam.dao.ModuleDAO;
import com.hospitalapp.uam.domain.Module;
import com.hospitalapp.uam.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

    private ModuleDAO moduleDAO;

    @Autowired
    public void setModuleDAO(ModuleDAO moduleDAO){
        this.moduleDAO = moduleDAO;
    }

    @Override
    public Module findById(long id) {
        return moduleDAO.findById(id);
    }
}
