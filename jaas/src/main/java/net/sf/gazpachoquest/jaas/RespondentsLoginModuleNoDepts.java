/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.jaas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import net.sf.gazpachoquest.jaas.auth.Account;
import net.sf.gazpachoquest.jaas.auth.RespondentAccount;
import net.sf.gazpachoquest.jaas.auth.RoleAccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RespondentsLoginModuleNoDepts implements LoginModule {

    private static Logger logger = LoggerFactory.getLogger(RespondentsLoginModuleNoDepts.class);

    private CallbackHandler handler;
    private Subject subject;
    private Account userPrincipal;
    private String endpoint;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
            Map<String, ?> options) {
        endpoint = (String) options.get("gazpachoquest.rest.endpoint");
        handler = callbackHandler;
        this.subject = subject;
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
            userPrincipal = doLogin(password);
            logger.info("Access granted to user {}", userPrincipal.getFullName());
            return true;
        } catch (LoginException e) {
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new LoginException("An unknown error has occurred in authentication process");
        }
    }

    public Account doLogin(String invitation) throws IOException, LoginException {
        RespondentAccount account = new RespondentAccount();
        String query = String.format("invitation=%s", URLEncoder.encode(invitation, "UTF-8"));
        URL url = new URL(endpoint + "/auth?" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try (InputStream is = connection.getInputStream(); JsonReader rdr = Json.createReader(is)) {
            JsonObject obj = rdr.readObject();

            String givenNames = obj.getString("givenNames");
            String surname = obj.getString("surname");
            String email = obj.getString("email");
            String apiKey = obj.getString("apiKey");
            String secret = obj.getString("secret");
            String preferredLanguage = obj.getString("preferredLanguage");
            account.setGivenNames(givenNames);
            account.setSurname(surname);
            account.setEmail(email);
            account.setApiKey(apiKey);
            account.setSecret(secret);
            account.setPreferredLanguage(preferredLanguage);
            JsonArray roles = obj.getJsonArray("roles");
            for (JsonObject role : roles.getValuesAs(JsonObject.class)) {
                String roleName = role.getString("name");
                account.assingRole(roleName);
            }
            JsonArray grantedquestionnaireIds = obj.getJsonArray("grantedquestionnaireIds");
            for (JsonNumber grantedquestionnaireId : grantedquestionnaireIds.getValuesAs(JsonNumber.class)) {
                Integer questionnaireId = grantedquestionnaireId.intValue();
                account.grantquestionnaireId(questionnaireId);
            }
        } catch (ConnectException e) {
            logger.error(e.getMessage(), e);
            throw new LoginException(String.format("Server {} is temporarily unavailable", endpoint));
        } catch (FileNotFoundException e) { // 404 error
            logger.error(e.getMessage(), e);
            throw new LoginException(String.format("Configuration error. Resource {} not found", url));
        } catch (IOException e) {
            String message = getErrorMessage(e, connection);
            logger.error(e.getMessage(), e);
            throw new LoginException(message);
        }
        return account;
    }

    private String getErrorMessage(IOException exception, HttpURLConnection connection) {
        String message = exception.getMessage();
        try (InputStream error = connection.getErrorStream(); JsonReader rdr = Json.createReader(error)) {
            JsonObject obj = rdr.readObject();
            message = obj.getString("message");
        } catch (Exception e) {
            // ignore. likely there is no response
        }
        return message;
    }

    @Override
    public boolean commit() throws LoginException {
        subject.getPrincipals().add(userPrincipal);
        for (RoleAccount role : userPrincipal.getRoles()) {
            subject.getPrincipals().add(role);
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
        for (RoleAccount role : userPrincipal.getRoles()) {
            subject.getPrincipals().remove(role);
        }
        return true;
    }

}
