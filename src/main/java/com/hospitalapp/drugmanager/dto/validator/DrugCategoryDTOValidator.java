package com.hospitalapp.drugmanager.dto.validator;

import com.hospitalapp.drugmanager.dto.DrugCategoryDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DrugCategoryDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return DrugCategoryDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "default.field.required", new String[]{"Name"});
    }
}
