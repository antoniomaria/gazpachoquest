/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.questionnaires;

import java.security.Principal;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import net.sf.gazpachoquest.questionnaires.views.QuestionnairView;
import net.sf.gazpachoquest.questionnaires.views.login.LoginEvent;
import net.sf.gazpachoquest.questionnaires.views.login.LoginView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;

@Theme("gazpacho")
@Title("Gazpacho Questionnaires")
@Widgetset("net.sf.gazpachoquest.questionnaires.AppWidgetSet")
@CDIUI
public class QuestionnairesUI extends UI {

    private static final long serialVersionUID = 1265851857862002747L;

    private static final Logger logger = LoggerFactory.getLogger(QuestionnairesUI.class);

    @Inject
    private CDIViewProvider viewProvider;

    private Navigator navigator;

    @Override
    public void init(VaadinRequest request) {
        logger.info("New Vaadin UI created");
        String invitation = request.getParameter("invitation");
        logger.info("Invitation: {} of sessions : {}", invitation);
        setSizeFull();
        GazpachoViewDisplay viewDisplay = new GazpachoViewDisplay();
        setContent(viewDisplay);

        navigator = new Navigator(this, (ViewDisplay) viewDisplay);
        navigator.addProvider(viewProvider);
        navigator.setErrorProvider(new GazpachoErrorViewProvider());

        if (isUserSignedIn()) {
            navigator.navigateTo(QuestionnairView.NAME);
        } else {
            navigator.navigateTo(LoginView.NAME);
        }
    }

    protected void onLogin(@Observes
    LoginEvent loginEvent) {
        try {
            JaasAccessControl.login(loginEvent.getUsername(), loginEvent.getPassword());
            navigator.navigateTo(QuestionnairView.NAME);
        } catch (Exception e) {
            Notification.show("Error logging in", Type.ERROR_MESSAGE);
            logger.error(e.getMessage(), e);
        }
    }

    public boolean isUserInRole(String role) {
        return JaasAccessControl.getCurrentRequest().isUserInRole(role);
    }

    public String getPrincipalName() {
        Principal principal = JaasAccessControl.getCurrentRequest().getUserPrincipal();
        if (principal != null) {
            return principal.getName();
        }

        return null;
    }

    public boolean isUserSignedIn() {
        Principal principal = JaasAccessControl.getCurrentRequest().getUserPrincipal();
        return principal != null;
    }
}
