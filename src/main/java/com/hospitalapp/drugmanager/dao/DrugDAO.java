package com.hospitalapp.drugmanager.dao;

import com.hospitalapp.drugmanager.domain.DrugCategory;

import java.util.List;

public interface DrugDAO {

    void saveCategory(DrugCategory drugCategory);

    void updateCategory(DrugCategory drugCategory);

    void findCategoryById(Long id);

    List<DrugCategory> listCategories();

    void deleteCategory(DrugCategory drugCategory);
}
