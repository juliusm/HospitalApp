package com.hospitalapp.drugmanager.dto;

import com.hospitalapp.drugmanager.domain.DrugCategory;

public class DrugCategoryDTO {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DrugCategory convertToDomain(){
        DrugCategory drugCategory = new DrugCategory();
        if(id != null && !id.trim().isEmpty()){
            drugCategory.setId(new Long(id));
        }
        drugCategory.setName(name);
        return drugCategory;
    }

    public static DrugCategoryDTO convertToDTO(DrugCategory drugCategory){
        DrugCategoryDTO drugCategoryDTO = new DrugCategoryDTO();
        drugCategoryDTO.setId(drugCategory.getId().toString());
        drugCategoryDTO.setName(drugCategory.getName());
        return drugCategoryDTO;
    }
}
