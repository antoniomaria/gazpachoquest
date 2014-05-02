package net.sf.gazpachoquest.security.shiro;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityManagerExposer {

    @Autowired
    private SecurityManager securityManager;

    @PostConstruct
    public void expose() {

        // Make the SecurityManager instance available to the entire application
        // via static memory:
        SecurityUtils.setSecurityManager(securityManager);
    }
}
