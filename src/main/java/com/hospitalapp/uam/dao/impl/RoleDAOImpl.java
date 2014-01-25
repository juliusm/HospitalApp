package com.hospitalapp.uam.dao.impl;

import com.hospitalapp.commons.dao.AbstractDAO;
import com.hospitalapp.uam.dao.RoleDAO;
import com.hospitalapp.uam.domain.Role;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("roleDAO")
public class RoleDAOImpl extends AbstractDAO implements RoleDAO{

    @Override
    public List<Role> list() {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Role.class);
        List<Role> result = criteria.list();
        Collections.sort(result);
        return result;
    }

    @Override
    public void save(Role role) {
        getSessionFactory().getCurrentSession().save(role);
    }

    @Override
    public Role findById(long id) {
        Session session = getSessionFactory().getCurrentSession();
        return (Role)session.get(Role.class, id);
    }

    @Override
    public void update(Role role) {
        getSessionFactory().getCurrentSession().update(role);
    }
}
