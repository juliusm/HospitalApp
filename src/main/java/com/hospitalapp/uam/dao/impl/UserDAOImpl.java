package com.hospitalapp.uam.dao.impl;

import com.hospitalapp.commons.dao.AbstractDAO;
import com.hospitalapp.uam.dao.UserDAO;
import com.hospitalapp.uam.domain.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDAO implements UserDAO{

    @Override
    public User findByUsername(String username) {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return  (User)criteria.uniqueResult();
    }
}
