package net.sf.gazpachosurvey.jpa;

import net.sf.gazpachosurvey.domain.user.User;

import org.springframework.data.domain.AuditorAware;

public class SimpleAuditorAware implements AuditorAware<User> {

    public User getCurrentAuditor() {
        User auditor = new User();
        auditor.setId(1);
        return auditor;
    }
}
