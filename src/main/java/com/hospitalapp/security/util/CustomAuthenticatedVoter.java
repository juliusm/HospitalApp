package com.hospitalapp.security.util;

import com.hospitalapp.uam.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

public class CustomAuthenticatedVoter extends AuthenticatedVoter{

    private static final String HOME = "/index.jsp";
    private static final String LOGOUT = "/logout/logout";
    private static final Logger LOGGER = Logger.getLogger(CustomAuthenticatedVoter.class.getName());

    @Autowired
    private AuthorizationService authorizationService;

    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes){

        FilterInvocation filterInvocation;
        Collection authorities = authentication.getAuthorities();
        int result = super.vote(authentication, object, attributes);
        String urlToBeAccessed;

        if(object instanceof FilterInvocation){
            filterInvocation = (FilterInvocation)object;
            urlToBeAccessed = filterInvocation.getRequestUrl();
        }else {
            LOGGER.info("Request URL object's type is now " + object.getClass().getName());
            return ACCESS_DENIED;
        }

        for(Object authority: authorities){
            if(authority instanceof GrantedAuthority){

                GrantedAuthority grantedAuthority = (GrantedAuthority)authority;

                if("ROLE_ANONYMOUS".equals(grantedAuthority.getAuthority())){
                    break;
                }

                result = ACCESS_DENIED;

                List<String> allowedUrls = authorizationService.getAllowedUrlsByRoleName(grantedAuthority.getAuthority());
                for(String urlPattern: allowedUrls){
                    if (urlToBeAccessed.matches(urlPattern)){
                        return ACCESS_GRANTED;
                    } else if (HOME.equals(urlToBeAccessed) || LOGOUT.equals(urlToBeAccessed)){
                        return ACCESS_GRANTED;
                    }
                }
            }
        }

        return result;
    }


}
