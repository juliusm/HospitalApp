package com.hospitalapp.drugmanager.service.impl;

import com.hospitalapp.drugmanager.dao.DrugCategoryDAO;
import com.hospitalapp.drugmanager.domain.DrugCategory;
import com.hospitalapp.drugmanager.dto.DrugCategoryDTO;
import com.hospitalapp.drugmanager.service.DrugCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service("drugManagerService")
@Transactional
public class DrugCategoryServiceImpl implements DrugCategoryService {

    @Autowired
    private DrugCategoryDAO drugCategoryDAO;

    @Override
    public List<DrugCategoryDTO> list() {
        List<DrugCategory> drugCategories = drugCategoryDAO.list();
        List<DrugCategoryDTO> drugCategoryDTOs = new LinkedList<DrugCategoryDTO>();
        for(DrugCategory drugCategory: drugCategories){
            DrugCategoryDTO dto = DrugCategoryDTO.convertToDTO(drugCategory);
            drugCategoryDTOs.add(dto);
        }
        return drugCategoryDTOs;
    }

    @Override
    public void save(DrugCategoryDTO drugCategoryDTO) {
        DrugCategory drugCategory = drugCategoryDTO.convertToDomain();
        drugCategoryDAO.save(drugCategory);
    }

    @Override
    public DrugCategoryDTO findById(Long id) {
        DrugCategory drugCategory = drugCategoryDAO.findById(id);
        return drugCategory != null? DrugCategoryDTO.convertToDTO(drugCategory): null;
    }

    @Override
    public void update(DrugCategoryDTO drugCategoryDTO) {
        DrugCategory drugCategory = drugCategoryDTO.convertToDomain();
        drugCategoryDAO.update(drugCategory);
    }

    @Override
    public void delete(DrugCategoryDTO drugCategoryDTO) {
        DrugCategory drugCategory = drugCategoryDTO.convertToDomain();
        drugCategoryDAO.delete(drugCategory);
    }
}
