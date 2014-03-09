package com.hospitalapp.uam.dto.converter;

import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.domain.User;
import com.hospitalapp.uam.dto.UserDTO;

public class UserConverter {

    public static User convertToDomain(UserDTO userDTO){
        User user = new User();
        if(userDTO.getId() != null && !userDTO.getId().trim().isEmpty()){
            user.setId(new Long(userDTO.getId()));
        }
        user.setFirstName(userDTO.getFirstName());
        user.setMiddleName(userDTO.getMiddleName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setAccountNonLocked(userDTO.isAccountNonLocked());
        user.setAccountNonExpired(userDTO.isAccountNonExpired());
        user.setCredentialsNonExpired(userDTO.isCredentialsNonExpired());
        user.setEnabled(userDTO.isEnabled());
        if(userDTO.getRoleId() != null && !userDTO.getRoleId().trim().isEmpty()){
            Role role = new Role();
            role.setId(new Long(userDTO.getRoleId()));
            role.setName(userDTO.getRoleName());
            user.setRole(role);
        }

        return user;
    }

    public static UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId().toString());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setMiddleName(user.getMiddleName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUsername(user.getUsername());
        userDTO.setAccountNonLocked(user.isAccountNonLocked());
        userDTO.setAccountNonExpired(user.isAccountNonExpired());
        userDTO.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userDTO.setEnabled(user.isEnabled());
        if(user.getRole() != null){
            userDTO.setRoleId(user.getRole().getId().toString());
            userDTO.setRoleName(user.getRole().getName());
        }
        return userDTO;
    }
}
