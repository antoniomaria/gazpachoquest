package net.sf.gazpachosurvey.security.impl;

import net.sf.gazpachosurvey.domain.core.PersonalInvitation;
import net.sf.gazpachosurvey.repository.InvitationRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.security.ServiceLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespondentLoginServiceImpl implements ServiceLogin {

    @Autowired
    private InvitationRepository invitationRepository;

    public void login(String userName, String password) {/*
        PersonalInvitation abstractInvitation = invitationRepository.findOneByExample(
                PersonalInvitation.with().token(password).build(),
                new SearchParameters().equals());
        */
        //System.out.println(abstractInvitation);
    }
}
