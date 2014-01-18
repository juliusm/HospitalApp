package com.hospitalapp.drugmanager.dao.impl;

import com.hospitalapp.drugmanager.dao.DrugManagerDAO;
import com.hospitalapp.drugmanager.domain.DrugCategory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("drugManagerDAO")
public class DrugManagerDAOImpl implements DrugManagerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveCategory(DrugCategory drugCategory) {
        sessionFactory.getCurrentSession().save(drugCategory);
    }

    @Override
    public void updateCategory(DrugCategory drugCategory) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void findCategoryById(Long id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DrugCategory> listCategories() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(DrugCategory.class);
        return criteria.list();
    }

    @Override
    public void deleteCategory(DrugCategory drugCategory) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
