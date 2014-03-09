package com.hospitalapp.drugmanager.dto.converter;

import com.hospitalapp.drugmanager.domain.DrugCategory;
import com.hospitalapp.drugmanager.dto.DrugCategoryDTO;

public class DrugCategoryConverter {

    public static DrugCategory convertToDomain(DrugCategoryDTO drugCategoryDTO){
        DrugCategory drugCategory = new DrugCategory();
        if(drugCategoryDTO.getId() != null && !drugCategoryDTO.getId().trim().isEmpty()){
            drugCategory.setId(new Long(drugCategoryDTO.getId()));
        }
        drugCategory.setName(drugCategoryDTO.getName());
        return drugCategory;
    }

    public static DrugCategoryDTO convertToDTO(DrugCategory drugCategory){
        DrugCategoryDTO drugCategoryDTO = new DrugCategoryDTO();
        drugCategoryDTO.setId(drugCategory.getId().toString());
        drugCategoryDTO.setName(drugCategory.getName());
        return drugCategoryDTO;
    }
}
