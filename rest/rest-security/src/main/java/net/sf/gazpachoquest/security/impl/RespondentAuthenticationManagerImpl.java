package net.sf.gazpachoquest.security.impl;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import net.sf.gazpachoquest.domain.core.PersonalInvitation;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.permission.QuestionnairePermission;
import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.permission.QuestionnairePermissionRepository;
import net.sf.gazpachoquest.security.AuthenticationManager;
import net.sf.gazpachoquest.services.InvitationService;
import net.sf.gazpachoquest.services.QuestionnaireService;
import net.sf.gazpachoquest.services.UserService;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.Perm;

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
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionnairePermissionRepository questionnairePermissionRepository;

    @Override
    @Transactional
    public RespondentAccount authenticate(String username, String password) throws AccountNotFoundException {
        Invitation example = Invitation.with().token(password).build();
        Invitation invitation = invitationService.findOneByExample(example, new SearchParameters());
        if (invitation == null) {
            throw new AccountNotFoundException("Invitation invalid");
        }

        List<Questionnaire> questionnaires = new ArrayList<>();
        Research research = invitation.getResearch();
        User respondent = null;
        if (invitation instanceof PersonalInvitation) {
            PersonalInvitation personalInvitation = (PersonalInvitation) invitation;
            respondent = personalInvitation.getRespondent();
            Questionnaire questionnairExample = Questionnaire.with()
                    .respondent(User.with().id(respondent.getId()).build())
                    .research(Research.with().id(research.getId()).build()).build();
            questionnaires = questionnaireService.findByExample(questionnairExample, new SearchParameters());
        } else {
            respondent = User.with().givenNames("anonymous").surname("anonymous").email("no-reply@gazpachoquest.net")
                    .build();
            respondent = userService.save(respondent);
            Questionnaire questionnaire = Questionnaire.with().status(EntityStatus.CONFIRMED).research(research)
                    .questionnaireDefinition(research.getQuestionnaireDefinition()).respondent(respondent).build();
            questionnaire = questionnaireService.save(questionnaire);
            questionnaires.add(questionnaire);
            // Grant right to the anonymous questionnaire
            QuestionnairePermission permission = QuestionnairePermission.with().addPerm(Perm.READ).addPerm(Perm.UPDATE)
                    .user(respondent).target(questionnaire).build();
            questionnairePermissionRepository.save(permission);
        }

        RespondentAccount.Builder builder = new RespondentAccount.Builder();
        RespondentAccount account = builder.email(respondent.getEmail()).givenNames(respondent.getGivenNames())
                .surname(respondent.getSurname()).apiKey(respondent.getApiKey()).secret(respondent.getSecret())
                .preferedLanguage(respondent.getPreferredLanguage()).build();

        for (Questionnaire questionnaire : questionnaires) {
            account.grantquestionnaireId(questionnaire.getId());
        }
        account.assingRole(RespondentAccount.DEFAULT_ROLE_NAME);
        return account;
    }
}
