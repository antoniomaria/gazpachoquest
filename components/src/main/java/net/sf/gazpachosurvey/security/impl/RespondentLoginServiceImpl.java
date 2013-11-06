package net.sf.gazpachosurvey.security.impl;

import net.sf.gazpachosurvey.domain.core.Invitation;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.security.ServiceLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespondentLoginServiceImpl implements ServiceLogin {
    
    @Autowired
    private InvitationRepository invitationRepository;
    
    public void login(String userName, String password){
        Invitation sample = new Invitation();
        sample.setToken(password);
        Invitation invitation = invitationRepository.findOneByExample(sample , new SearchParameters().equals());
        System.out.println(invitation);
    }
}
