package com.hospitalapp.uam.service;


import com.hospitalapp.uam.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService extends UserDetailsService{

    User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException;
}
