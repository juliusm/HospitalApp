package com.hospitalapp.drugmanager.dao;

import com.hospitalapp.drugmanager.domain.DrugCategory;

import java.util.List;

public interface DrugCategoryDAO {

    void save(DrugCategory drugCategory);

    void update(DrugCategory drugCategory);

    DrugCategory findById(Long id);

    List<DrugCategory> list();

    void delete(DrugCategory drugCategory);
}
