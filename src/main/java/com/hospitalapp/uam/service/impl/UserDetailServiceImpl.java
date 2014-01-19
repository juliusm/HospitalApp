package com.hospitalapp.uam.service.impl;


import com.hospitalapp.uam.dao.UserDAO;
import com.hospitalapp.uam.domain.User;
import com.hospitalapp.uam.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailService")
@Transactional
public class UserDetailServiceImpl implements UserDetailService{

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        User user = userDAO.findByUsername(username);
        return user;
    }
}
