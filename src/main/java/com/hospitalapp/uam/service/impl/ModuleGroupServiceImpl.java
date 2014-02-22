package com.hospitalapp.uam.service.impl;

import com.hospitalapp.uam.dao.ModuleGroupDAO;
import com.hospitalapp.uam.domain.ModuleGroup;
import com.hospitalapp.uam.service.ModuleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("moduleGroupService")
@Transactional
public class ModuleGroupServiceImpl implements ModuleGroupService{

    @Autowired
    private ModuleGroupDAO moduleGroupDAO;

    @Override
    public List<ModuleGroup> list() {
        return moduleGroupDAO.list();
    }
}
