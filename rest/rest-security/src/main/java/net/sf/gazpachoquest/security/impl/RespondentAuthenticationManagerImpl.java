package net.sf.gazpachoquest.security.impl;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import net.sf.gazpachoquest.domain.core.AnonymousInvitation;
import net.sf.gazpachoquest.domain.core.PersonalInvitation;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.Research;
import net.sf.gazpachoquest.domain.support.Invitation;
import net.sf.gazpachoquest.domain.user.Permission;
import net.sf.gazpachoquest.domain.user.Role;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.security.AuthenticationManager;
import net.sf.gazpachoquest.services.InvitationService;
import net.sf.gazpachoquest.services.PermissionService;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.services.RoleService;
import net.sf.gazpachoquest.services.UserService;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.EntityType;
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
    private QuestionnairService questionnairService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public RespondentAccount authenticate(String username, String password) throws AccountNotFoundException {
        Invitation example = Invitation.with().token(password).build();
        Invitation invitation = invitationService.findOneByExample(example, new SearchParameters());
        if (invitation == null) {
            throw new AccountNotFoundException("Invitation invalid");
        }

        List<Questionnair> questionnairs = new ArrayList<>();
        Research research = invitation.getResearch();
        User respondent = null;
        if (invitation instanceof PersonalInvitation) {
            PersonalInvitation personalInvitation = (PersonalInvitation) invitation;
            respondent = personalInvitation.getRespondent();
            Questionnair questionnairExample = Questionnair.with()
                    .respondent(User.with().id(respondent.getId()).build())
                    .research(Research.with().id(research.getId()).build()).build();
            questionnairs = questionnairService.findByExample(questionnairExample, new SearchParameters());
        } else {
            AnonymousInvitation anonymousInvitation = (AnonymousInvitation) invitation;

            respondent = User.with().givenNames("anonymous").surname("anonymous").email("no-reply@gazpachoquest.net")
                    .build();
            respondent = userService.save(respondent);
            Questionnair questionnair = Questionnair.with().status(EntityStatus.CONFIRMED).research(research)
                    .questionnairDefinition(anonymousInvitation.getQuestionnairDefinition()).respondent(respondent)
                    .build();
            questionnair = questionnairService.save(questionnair);
            questionnairs.add(questionnair);
            // Grant right to the anonymous questionnair
            Role personalRole = respondent.getDefaultRole();
            Permission permission = Permission.with().addPerm(Perm.READ).addPerm(Perm.UPDATE)
                    .scope(EntityType.QUESTIONNAIR).entityId(questionnair.getId()).build();
            permissionService.save(permission);

            personalRole.assignPermission(permission);
            roleService.save(personalRole);
        }

        RespondentAccount.Builder builder = new RespondentAccount.Builder();
        RespondentAccount account = builder.email(respondent.getEmail()).givenNames(respondent.getGivenNames())
                .surname(respondent.getSurname()).apiKey(respondent.getApiKey()).secret(respondent.getSecret()).build();

        for (Questionnair questionnair : questionnairs) {
            account.grantQuestionnairId(questionnair.getId());
        }
        account.assingRole(RespondentAccount.DEFAULT_ROLE_NAME);
        return account;
    }
}
