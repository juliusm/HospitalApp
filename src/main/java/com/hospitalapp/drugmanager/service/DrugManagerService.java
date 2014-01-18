package com.hospitalapp.drugmanager.service;

import com.hospitalapp.drugmanager.domain.DrugCategory;

import java.util.List;

public interface DrugManagerService {

    List<DrugCategory> listCategories();

    void saveCategory(DrugCategory drugCategory);
}
