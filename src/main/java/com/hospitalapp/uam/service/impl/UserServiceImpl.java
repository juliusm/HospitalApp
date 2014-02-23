package com.hospitalapp.uam.service.impl;

import com.hospitalapp.uam.dao.RoleDAO;
import com.hospitalapp.uam.dao.UserDAO;
import com.hospitalapp.uam.domain.Module;
import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.domain.User;
import com.hospitalapp.uam.dto.UserDTO;
import com.hospitalapp.uam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        User user = userDAO.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public List<UserDTO> list() {
        List<User> users = userDAO.list();
        List<UserDTO> userDTOs = new LinkedList<UserDTO>();
        for(User user: users){
            UserDTO dto = UserDTO.convertToDTO(user);
            userDTOs.add(dto);
        }
        return userDTOs;
    }

    @Override
    public UserDTO findById(long id) {
        User user = userDAO.findById(id);
        return UserDTO.convertToDTO(user);
    }

    @Override
    public void save(UserDTO userDTO) {
        String hashedPassword = passwordEncoder.encodePassword(userDTO.getPassword(), null);
        userDTO.setPassword(hashedPassword);
        User user = userDTO.convertToDomain();
        Role role = roleDAO.findById(user.getRole().getId());
        user.setRole(role);
        userDAO.save(user);
    }

    @Override
    public void update(UserDTO userDTO) {
        User user = userDTO.convertToDomain();
        User persistedUser = userDAO.findById(user.getId());
        user.setPassword(persistedUser.getPassword());
        if(!user.getRole().getId().equals(persistedUser.getRole().getId())){
            Role role = roleDAO.findById(user.getRole().getId());
            user.setRole(role);
        }
        userDAO.update(user);
    }

    @Override
    public void delete(UserDTO userDTO) {
        User user = userDTO.convertToDomain();
        userDAO.delete(user);
    }
}
