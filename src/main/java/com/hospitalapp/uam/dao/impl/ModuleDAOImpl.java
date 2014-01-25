package com.hospitalapp.uam.dao.impl;

import com.hospitalapp.commons.dao.AbstractDAO;
import com.hospitalapp.uam.dao.ModuleDAO;
import com.hospitalapp.uam.domain.Module;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("moduleDAO")
public class ModuleDAOImpl extends AbstractDAO implements ModuleDAO{

    @Override
    public Module findById(long id) {
        Session session = getSessionFactory().getCurrentSession();
        return (Module)session.get(Module.class, id);
    }
}
