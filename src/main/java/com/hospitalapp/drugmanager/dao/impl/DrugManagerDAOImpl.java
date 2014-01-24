package com.hospitalapp.drugmanager.dao.impl;

import com.hospitalapp.commons.dao.AbstractDAO;
import com.hospitalapp.drugmanager.dao.DrugManagerDAO;
import com.hospitalapp.drugmanager.domain.DrugCategory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("drugManagerDAO")
public class DrugManagerDAOImpl extends AbstractDAO implements DrugManagerDAO {

    @Override
    public void saveCategory(DrugCategory drugCategory) {
        getSessionFactory().getCurrentSession().save(drugCategory);
    }

    @Override
    public void updateCategory(DrugCategory drugCategory) {
        getSessionFactory().getCurrentSession().update(drugCategory);
    }

    @Override
    public DrugCategory findCategoryById(Long id) {
        Session session = getSessionFactory().getCurrentSession();
        return (DrugCategory)session.get(DrugCategory.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DrugCategory> listCategories() {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(DrugCategory.class);
        return criteria.list();
    }

    @Override
    public void deleteCategory(DrugCategory drugCategory) {
        getSessionFactory().getCurrentSession().delete(drugCategory);
    }
}
