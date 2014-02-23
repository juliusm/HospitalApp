package com.hospitalapp.drugmanager.service;

import com.hospitalapp.drugmanager.dto.DrugCategoryDTO;

import java.util.List;

public interface DrugCategoryService {

    List<DrugCategoryDTO> list();

    void save(DrugCategoryDTO drugCategory);

    DrugCategoryDTO findById(Long id);

    void update(DrugCategoryDTO drugCategory);

    void delete(DrugCategoryDTO drugCategory);
}
