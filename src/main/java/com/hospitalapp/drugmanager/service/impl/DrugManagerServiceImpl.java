package com.hospitalapp.drugmanager.service.impl;

import com.hospitalapp.drugmanager.dao.DrugManagerDAO;
import com.hospitalapp.drugmanager.domain.DrugCategory;
import com.hospitalapp.drugmanager.service.DrugManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("drugManagerService")
@Transactional
public class DrugManagerServiceImpl implements DrugManagerService{

    private DrugManagerDAO drugManagerDAO;

    @Autowired
    public void setDrugManagerDAO(DrugManagerDAO drugManagerDAO){
        this.drugManagerDAO = drugManagerDAO;
    }

    @Override
    public List<DrugCategory> listCategories() {
        return drugManagerDAO.listCategories();
    }

    @Override
    public void saveCategory(DrugCategory drugCategory) {
        drugManagerDAO.saveCategory(drugCategory);
    }

    @Override
    public DrugCategory findDrugCategoryById(Long id) {
        return drugManagerDAO.findCategoryById(id);
    }

    @Override
    public void updateDrugCategory(DrugCategory drugCategory) {
        drugManagerDAO.updateCategory(drugCategory);
    }

    @Override
    public void deleteDrugCategory(DrugCategory drugCategory) {
        drugManagerDAO.deleteCategory(drugCategory);
    }
}
