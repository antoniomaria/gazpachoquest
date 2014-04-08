package net.sf.gazpachoquest.security.impl;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import net.sf.gazpachoquest.domain.core.PersonalInvitation;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.Study;
import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.security.AuthenticationManager;
import net.sf.gazpachoquest.services.InvitationService;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("respondentAuthManager")
public class RespondentAuthenticationManagerImpl implements AuthenticationManager {

    @Autowired
    private UserService userService;

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private QuestionnairService questionnairService;

    @Override
    @Transactional
    public RespondentAccount authenticate(String username, String password) throws AccountNotFoundException {
        Invitation example = Invitation.with().token(password).build();
        Invitation invitation = invitationService.findOneByExample(example, new SearchParameters());
        if (invitation == null) {
            throw new AccountNotFoundException("Invitation invalid");
        }

        List<Questionnair> questionnairs = new ArrayList<>();
        Study study = invitation.getStudy();
        User participant = null;
        if (invitation instanceof PersonalInvitation) {
            PersonalInvitation personalInvitation = (PersonalInvitation) invitation;
            participant = personalInvitation.getParticipant();
            Questionnair questionnairExample = Questionnair.with()
                    .participant(User.with().id(participant.getId()).build())
                    .study(Study.with().id(study.getId()).build()).build();
            questionnairs = questionnairService.findByExample(questionnairExample, new SearchParameters());
        }

        if (questionnairs.isEmpty()) {
            participant = User.with().givenNames("anonymous").surname("anonymous").email("no-reply@gazpachoquest.net")
                    .build();
            participant = userService.save(participant);
            Questionnair questionnair = Questionnair.with().study(study).participant(participant).build();
            questionnair = questionnairService.save(questionnair);
            questionnairs.add(questionnair);
        }

        RespondentAccount.Builder builder = new RespondentAccount.Builder();
        RespondentAccount account = builder.email(participant.getEmail()).givenNames(participant.getGivenNames())
                .surname(participant.getSurname()).apiKey(participant.getApiKey()).build();

        for (Questionnair questionnair : questionnairs) {
            account.addQuestionnairId(questionnair.getId());
        }
        return account;
    }
}
