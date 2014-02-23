package com.hospitalapp.uam.dao.impl;

import com.hospitalapp.commons.dao.AbstractDAO;
import com.hospitalapp.uam.dao.UserDAO;
import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDAO implements UserDAO{

    @Override
    public List<User> list() {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> result = criteria.list();
        return result;
    }

    @Override
    public User findById(long id) {
        Session session = getSessionFactory().getCurrentSession();
        return (User)session.get(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return  (User)criteria.uniqueResult();
    }

    @Override
    public void save(User user) {
        getSessionFactory().getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        getSessionFactory().getCurrentSession().merge(user);
    }

    @Override
    public void delete(User user) {
        getSessionFactory().getCurrentSession().delete(user);
    }
}
