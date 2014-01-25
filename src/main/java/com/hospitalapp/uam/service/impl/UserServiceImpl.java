package com.hospitalapp.uam.service.impl;

import com.hospitalapp.uam.dao.UserDAO;
import com.hospitalapp.uam.domain.Module;
import com.hospitalapp.uam.domain.User;
import com.hospitalapp.uam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDAO userDAO;
    private ShaPasswordEncoder passwordEncoder;

    @Autowired
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Autowired
    public void setPasswordEncoder(ShaPasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        User user = userDAO.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        for(Module module: user.getRole().getModules()){
            module.getLinks();
        }
        return user;
    }

    @Override
    public List<User> list() {
        return userDAO.list();
    }

    @Override
    public User findById(long id) {
        return userDAO.findById(id);
    }

    @Override
    public void save(User user) {
        String hashedPassword = passwordEncoder.encodePassword(user.getPassword(), null);
        user.setPassword(hashedPassword);
        userDAO.save(user);
    }

    @Override
    public void update(User user) {
        User persistedUser = userDAO.findById(user.getId());
        persistedUser.setId(user.getId());
        persistedUser.setUsername(user.getUsername());
        persistedUser.setFirstName(user.getFirstName());
        persistedUser.setMiddleName(user.getMiddleName());
        persistedUser.setLastName(user.getLastName());
        persistedUser.setAccountNonExpired(user.isAccountNonExpired());
        persistedUser.setAccountNonLocked(user.isAccountNonLocked());
        persistedUser.setCredentialsNonExpired(user.isCredentialsNonExpired());
        persistedUser.setEnabled(user.isEnabled());
        persistedUser.setRole(user.getRole());
        userDAO.update(persistedUser);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }
}
