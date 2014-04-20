package net.sf.gazpachoquest.jaas;

import static org.fest.assertions.api.Assertions.assertThat;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

import net.sf.gazpachoquest.jaas.mock.AuthenticationResourceMock;
import net.sf.gazpachoquest.jaas.mock.CallbackHandlerMock;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class GazpachoLoginModuleTest {

    private GazpachoLoginModule loginModule;

    @Before
    public void setUp() {
        loginModule = new GazpachoLoginModule();

        // Initialization of Group
        // before GroupPrincipal
        Principal principal = UserPrincipal.with().name("respondent").build();
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
    	AuthenticationResourceMock authenticationResourceMock = new AuthenticationResourceMock();
        loginModule.setAuthenticationResource(authenticationResourceMock);
        loginModule.login();
    }

    @Test
    public void loginSuccefullyTest() throws LoginException {
    	AuthenticationResourceMock authenticationResourceMock = new AuthenticationResourceMock();
        loginModule.setAuthenticationResource(authenticationResourceMock);
             assertThat(loginModule.login()).isTrue();
    }

}
