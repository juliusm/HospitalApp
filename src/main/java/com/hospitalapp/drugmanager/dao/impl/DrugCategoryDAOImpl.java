package com.hospitalapp.drugmanager.dao.impl;

import com.hospitalapp.commons.dao.AbstractDAO;
import com.hospitalapp.drugmanager.dao.DrugCategoryDAO;
import com.hospitalapp.drugmanager.domain.DrugCategory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("drugCategoryDAO")
public class DrugCategoryDAOImpl extends AbstractDAO implements DrugCategoryDAO {

    @Override
    public void save(DrugCategory drugCategory) {
        getSessionFactory().getCurrentSession().save(drugCategory);
    }

    @Override
    public void update(DrugCategory drugCategory) {
        getSessionFactory().getCurrentSession().update(drugCategory);
    }

    @Override
    public DrugCategory findById(Long id) {
        Session session = getSessionFactory().getCurrentSession();
        return (DrugCategory)session.get(DrugCategory.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DrugCategory> list() {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(DrugCategory.class);
        return criteria.list();
    }

    @Override
    public void delete(DrugCategory drugCategory) {
        getSessionFactory().getCurrentSession().delete(drugCategory);
    }
}
