package com.hospitalapp.uam.dto.validator;

import com.hospitalapp.uam.dto.UserDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserDTOValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "default.input.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "default.input.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "default.input.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "default.input.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleId", "default.select.required");
    }
}
