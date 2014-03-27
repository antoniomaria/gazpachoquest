package net.sf.gazpachoquest.jaas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.QuestionnairDTO;

import org.apache.cxf.common.util.Base64Utility;
import org.apache.cxf.jaxrs.client.ClientWebApplicationException;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class GazpachoLoginModule implements LoginModule {

    private static Logger logger = LoggerFactory.getLogger(GazpachoLoginModule.class);

    public static final String BASE_URI = "http://gazpacho.antoniomaria.cloudbees.net/";

    private CallbackHandler handler;
    private Subject subject;
    private UserPrincipal userPrincipal;
    private RolePrincipal rolePrincipal;
    private String username;
    private String password;
    private List<String> userGroups;
    private QuestionnairResource questionnairResource;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
            Map<String, ?> options) {

        handler = callbackHandler;
        this.subject = subject;
        questionnairResource = JAXRSClientFactory.create(BASE_URI, QuestionnairResource.class,
                Collections.singletonList(new JacksonJsonProvider()), null);
    }

    public void setQuestionnairResource(QuestionnairResource questionnairResource) {
        this.questionnairResource = questionnairResource;
    }

    @Override
    public boolean login() throws LoginException {

        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("username");
        callbacks[1] = new PasswordCallback("password", true);

        try {
            handler.handle(callbacks);
            String username = ((NameCallback) callbacks[0]).getName();
            String password = String.valueOf(((PasswordCallback) callbacks[1]).getPassword());
            logger.info("New username attempt for user: {}", username);

            String authorizationHeader = "Basic "
                    + Base64Utility.encode(String.format("%s:%s", username, password).getBytes());
            WebClient.client(questionnairResource).header("Authorization", authorizationHeader);

            List<QuestionnairDTO> questionnaires = questionnairResource.list();
            if (questionnaires.isEmpty()) {
                throw new LoginException("Authentication failed");
            }

            logger.info("Access granted to respondent identified by invitation {}", password);
            this.username = username;
            this.password = password;
            userGroups = new ArrayList<String>();
            userGroups.add("respondent");
            return true;
        } catch (ClientWebApplicationException e) {
            logger.error(e.getMessage(), e);
            throw new LoginException(e.getMessage());
        } catch (IOException e) {
            throw new LoginException(e.getMessage());
        } catch (UnsupportedCallbackException e) {
            throw new LoginException(e.getMessage());
        }

    }

    @Override
    public boolean commit() throws LoginException {

        userPrincipal = new UserPrincipal(username);
        subject.getPrincipals().add(userPrincipal);

        if (userGroups != null && userGroups.size() > 0) {
            for (String groupName : userGroups) {
                rolePrincipal = new RolePrincipal(groupName);
                subject.getPrincipals().add(rolePrincipal);
            }
        }

        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(userPrincipal);
        subject.getPrincipals().remove(rolePrincipal);
        return true;
    }

}
