package net.sf.gazpachoquest.jaas;

import static org.fest.assertions.api.Assertions.assertThat;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.jaas.mock.CallbackHandlerMock;
import net.sf.gazpachoquest.jaas.mock.QuestionnairResourceMock;

import org.junit.Before;
import org.junit.Test;

public class GazpachoLoginModuleTest {

    private GazpachoLoginModule loginModule;

    @Before
    public void setUp() {
        loginModule = new GazpachoLoginModule();

        // Initialization of Group
        // before GroupPrincipal
        Principal principal = new UserPrincipal("respondent");
        Set<Principal> principals = new HashSet<Principal>();
        principals.add(principal);
        Subject subject = new Subject(true, principals, new HashSet<Principal>(), new HashSet<Principal>());
        CallbackHandler callbackHandler = CallbackHandlerMock.with().username("respondent").password("12345678")
                .build();
        Map<String, String> sharedState = new HashMap<String, String>();
        Map<String, String> options = new HashMap<String, String>();
        loginModule.initialize(subject, callbackHandler, sharedState, options);
    }

    @Test(expected = LoginException.class)
    public void loginFailureTest() throws LoginException {
        QuestionnairResource questionnairResource = new QuestionnairResourceMock();
        loginModule.setQuestionnairResource(questionnairResource);
        loginModule.login();
    }

    @Test
    public void loginSuccefullyTest() throws LoginException {
        QuestionnairResourceMock questionnairResource = new QuestionnairResourceMock();
        List<QuestionnairDTO> questionnairDTOs = new ArrayList<>();
        questionnairDTOs.add(QuestionnairDTO.with().id(123).build());
        questionnairResource.setQuestionnairDTOs(questionnairDTOs);
        // loginModule.setQuestionnairResource(questionnairResource);
        assertThat(loginModule.login()).isTrue();
    }

}
