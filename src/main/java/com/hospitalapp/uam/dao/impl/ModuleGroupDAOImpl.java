package com.hospitalapp.uam.dao.impl;

import com.hospitalapp.commons.dao.AbstractDAO;
import com.hospitalapp.uam.dao.ModuleGroupDAO;
import com.hospitalapp.uam.domain.ModuleGroup;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("moduleGroupsDAO")
public class ModuleGroupDAOImpl extends AbstractDAO implements ModuleGroupDAO {

    @Override
    public List<ModuleGroup> list() {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ModuleGroup.class);
        List<ModuleGroup> result = criteria.list();
        Collections.sort(result);
        return result;
    }
}
