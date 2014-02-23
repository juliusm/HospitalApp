package com.hospitalapp.uam.service;

import com.hospitalapp.uam.dto.UserDTO;

import java.util.List;

public interface UserService{

    List<UserDTO> list();

    UserDTO findById(long id);

    void save(UserDTO userDTO);

    void update(UserDTO userDTO);

    void delete(UserDTO userDTO);

}
