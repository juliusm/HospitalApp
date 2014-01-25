package com.hospitalapp.drugmanager.service.impl;

import com.hospitalapp.drugmanager.dao.DrugCategoryDAO;
import com.hospitalapp.drugmanager.domain.DrugCategory;
import com.hospitalapp.drugmanager.service.DrugCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("drugManagerService")
@Transactional
public class DrugCategoryServiceImpl implements DrugCategoryService {

    private DrugCategoryDAO drugCategoryDAO;

    @Autowired
    public void setDrugCategoryDAO(DrugCategoryDAO drugCategoryDAO){
        this.drugCategoryDAO = drugCategoryDAO;
    }

    @Override
    public List<DrugCategory> list() {
        return drugCategoryDAO.list();
    }

    @Override
    public void save(DrugCategory drugCategory) {
        drugCategoryDAO.save(drugCategory);
    }

    @Override
    public DrugCategory findById(Long id) {
        return drugCategoryDAO.findById(id);
    }

    @Override
    public void update(DrugCategory drugCategory) {
        drugCategoryDAO.update(drugCategory);
    }

    @Override
    public void delete(DrugCategory drugCategory) {
        drugCategoryDAO.delete(drugCategory);
    }
}
