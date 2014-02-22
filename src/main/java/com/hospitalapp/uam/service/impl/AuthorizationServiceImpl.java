package com.hospitalapp.uam.service.impl;

import com.hospitalapp.uam.dao.RoleDAO;
import com.hospitalapp.uam.domain.Link;
import com.hospitalapp.uam.domain.Module;
import com.hospitalapp.uam.domain.Role;
import com.hospitalapp.uam.service.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service("authorizationService")
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

    private static final Logger LOGGER = Logger.getLogger(AuthorizationServiceImpl.class);

    @Autowired
    private RoleDAO roleDAO;

    /**
     *
     * @param roleName
     * @return
     */
    @Override
    @Cacheable("allowedUrls")
    public List<String> getAllowedUrlsByRoleName(String roleName) {

        LOGGER.debug("role: " + roleName);
        Role role = roleDAO.findByName(roleName);
        Set<Module> modules = role.getModules();
        List<String> allowedUrls = new LinkedList<String>();
        for(Module module: modules){
            Set<Link> links = module.getLinks();
            for(Link link: links){
                allowedUrls.add(transformToRegex(link.getValue()));
            }
        }
        return allowedUrls;
    }

    /**
     * Changes asterisk (*) to Regex [0-9a-zA-Z\\-]*
     *
     * @param urlPattern
     * @return
     */
    private String transformToRegex(String urlPattern){
        return urlPattern.replace("*", "[0-9a-zA-Z\\\\-]*");
    }
}
