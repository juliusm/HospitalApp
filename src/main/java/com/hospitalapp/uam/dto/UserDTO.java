package com.hospitalapp.uam.dto;

import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.domain.User;

public class UserDTO {

    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String password;
    private String roleId;
    private String roleName;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User convertToDomain(){
        User user = new User();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setUsername(userName);
        user.setPassword(password);
        user.setAccountNonLocked(accountNonLocked);
        user.setAccountNonExpired(accountNonExpired);
        user.setCredentialsNonExpired(credentialsNonExpired);
        user.setEnabled(enabled);
        Role role = new Role();
        role.setId(new Long(roleId));
        role.setName(roleName);
        user.setRole(role);
        return user;
    }

    public static UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setMiddleName(user.getMiddleName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUserName(user.getUsername());
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
