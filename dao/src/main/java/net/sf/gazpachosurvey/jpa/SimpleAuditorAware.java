package net.sf.gazpachosurvey.jpa;

import net.sf.gazpachosurvey.domain.user.UserAccount;

import org.springframework.data.domain.AuditorAware;

public class SimpleAuditorAware implements AuditorAware<UserAccount> {

    public UserAccount getCurrentAuditor() {
        UserAccount auditor = new UserAccount();
        auditor.setId(1);
        return auditor;
    }
}
