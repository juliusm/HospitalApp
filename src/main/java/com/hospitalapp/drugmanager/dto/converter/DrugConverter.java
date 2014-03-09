package com.hospitalapp.drugmanager.dto.converter;

import com.hospitalapp.drugmanager.domain.Drug;
import com.hospitalapp.drugmanager.domain.DrugCategory;
import com.hospitalapp.drugmanager.dto.DrugDTO;

public class DrugConverter {

    public static Drug convertToDomain(DrugDTO drugDTO){
        Drug drug = new Drug();
        if(drugDTO.getId() != null && !drugDTO.getId().trim().isEmpty()){
            drug.setId(new Long(drugDTO.getId()));
        }
        drug.setName(drugDTO.getName());
        drug.setStatus(drugDTO.getStatus());
        if(drugDTO.getDrugCategoryId() != null && !drugDTO.getDrugCategoryId().trim().isEmpty()){
            DrugCategory category = new DrugCategory();
            category.setId(new Long(drugDTO.getDrugCategoryId()));
            category.setName(drugDTO.getDrugCategory());
            drug.setCategory(category);
        }
        return drug;
    }

    public static DrugDTO convertToDTO(Drug drug){
        DrugDTO drugDTO = new DrugDTO();
        drugDTO.setId(drug.getId().toString());
        drugDTO.setName(drug.getName());
        drugDTO.setStatus(drug.getStatus());
        if(drug.getCategory() != null){
            drugDTO.setDrugCategoryId(drug.getCategory().getId().toString());
            drugDTO.setDrugCategory(drug.getCategory().getName());
        }
        return drugDTO;
    }

}
