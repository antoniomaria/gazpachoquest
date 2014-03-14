package net.sf.gazpachoquest.domain.audit;

import net.sf.gazpachoquest.domain.user.User;

import org.springframework.data.domain.AuditorAware;

public class SimpleAuditorAware implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {
        Integer userId = 1;
        User auditor = new User();
        auditor.setId(userId);
        return auditor;
    }
}
