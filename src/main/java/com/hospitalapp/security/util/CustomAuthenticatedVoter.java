package com.hospitalapp.security.util;

import com.hospitalapp.uam.domain.Link;
import com.hospitalapp.uam.domain.Module;
import com.hospitalapp.uam.domain.Role;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
import java.util.Set;

public class CustomAuthenticatedVoter extends AuthenticatedVoter{

    private static final String HOME = "/index.jsp";
    private static final String LOGOUT = "/logout/logout";

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes){

        FilterInvocation filterInvocation = null;

        if(object instanceof FilterInvocation){
            filterInvocation = (FilterInvocation)object;
        }

        int result = super.vote(authentication, object, attributes);
        boolean loggedIn = true;

        for(ConfigAttribute attribute: attributes){
            if("IS_AUTHENTICATED_ANONYMOUSLY".equals(attribute.getAttribute())){
                loggedIn = false;
                break;
            }
        }

        if(result == ACCESS_GRANTED
                && filterInvocation != null
                && loggedIn
                && !LOGOUT.equals(filterInvocation.getRequestUrl())
                && !HOME.equals(filterInvocation.getRequestUrl())){

            result = ACCESS_DENIED;
            Collection<Role> authorities = (Collection<Role>)authentication.getAuthorities();
            String urlToBeAccessed = filterInvocation.getRequestUrl().trim();

            for(Role role: authorities){
                Set<Module> modules = role.getModules();

                for(Module module: modules){
                    Set<Link> links = module.getLinks();

                    for(Link link: links){
                        if(urlToBeAccessed.trim().contains(link.getValue().trim())){
                            result = ACCESS_GRANTED;
                        }
                    }
                }
            }
        }

        return result;
    }


}
