package net.sf.gazpachoquest.security.impl;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.support.User;
import net.sf.gazpachoquest.domain.user.Participant;
import net.sf.gazpachoquest.dto.auth.Account;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.security.LoginManager;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginManagerImpl implements LoginManager {

    private static final Logger logger = LoggerFactory.getLogger(LoginManagerImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionnairService questionnairService;

    @Override
    public Account login(String apiKey) throws AccountNotFoundException {

        User exampleUser = new User.Builder().apiKey(apiKey).build();

        User user = userService.findOneByExample(exampleUser, new SearchParameters());

        if (user == null) {
            throw new AccountNotFoundException("Invalid apikey. User not found");
        }

        Account account = Account.with().email(user.getEmail()).givenNames(user.getGivenNames())
                .surname(user.getSurname()).apiKey(apiKey).build();

        if (user instanceof Participant) {
            Participant participant = (Participant) user;
            account = new RespondentAccount(account);

            Questionnair questionnairExample = Questionnair.with()
                    .participant(Participant.with().id(participant.getId()).build()).build();

            List<Questionnair> questionnairs = questionnairService.findByExample(questionnairExample,
                    new SearchParameters());

            for (Questionnair questionnair : questionnairs) {
                ((RespondentAccount) account).addQuestionnairId(questionnair.getId());
            }
            account.getRoles().add("respondent");
        } else {
            account.getRoles().add("manager");
        }
        logger.info("Access granted to User with given names {} and surname {}", user.getGivenNames(),
                user.getSurname());
        return account;
    }
}
