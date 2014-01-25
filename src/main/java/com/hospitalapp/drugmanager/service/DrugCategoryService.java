package com.hospitalapp.drugmanager.service;

import com.hospitalapp.drugmanager.domain.DrugCategory;

import java.util.List;

public interface DrugCategoryService {

    List<DrugCategory> list();

    void save(DrugCategory drugCategory);

    DrugCategory findById(Long id);

    void update(DrugCategory drugCategory);

    void delete(DrugCategory drugCategory);
}
