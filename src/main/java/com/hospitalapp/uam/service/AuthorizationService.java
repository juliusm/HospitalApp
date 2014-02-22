package com.hospitalapp.uam.service;

import java.util.List;

public interface AuthorizationService{

    List<String> getAllowedUrlsByRoleName(String roleName);
}
