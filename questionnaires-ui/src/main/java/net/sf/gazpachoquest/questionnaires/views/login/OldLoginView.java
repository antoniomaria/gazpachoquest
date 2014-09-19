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
package net.sf.gazpachoquest.questionnaires.views.login;

import java.util.Collections;
import java.util.Locale;

import net.sf.gazpachoquest.api.QuestionnaireResource;
import net.sf.gazpachoquest.questionnaires.views.QuestionnaireView;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.server.WrappedSession;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

//@CDIView(OldLoginView.NAME)
public class OldLoginView extends CustomComponent implements View, Button.ClickListener {

    private static final long serialVersionUID = 2314128852757221652L;

    private static Logger logger = LoggerFactory.getLogger(OldLoginView.class);

    public static final String NAME = "";

    private final TextField invitationTextField;

    private final Button enterButton;

    private ComboBox createLanguageSelector() {
        ComboBox languageSelector = new ComboBox("com.vaadin.demo.dashboard.DashboardUI.Language");
        languageSelector.setImmediate(true);
        languageSelector.setNullSelectionAllowed(false);
        addLocale(Locale.ENGLISH, languageSelector);
        addLocale(Locale.FRENCH, languageSelector);
        addLocale(new Locale("es"), languageSelector);
        // languageSelector.setValue(I18NStaticService.getI18NServive().getLocale());
        /*-languageSelector.addValueChangeListener(new ValueChangeListener() {

            private static final long serialVersionUID = 1L;

            @Override
            public void valueChange(ValueChangeEvent event) {
                Locale locale = (Locale) (event.getProperty().getValue());
                I18NStaticService.getI18NServive().setLocale(locale);
                getUI().requestRepaintAll();
            }
        });*/
        return languageSelector;
    }

    private void addLocale(Locale locale, ComboBox languageSelector) {
        languageSelector.addItem(locale);
        languageSelector.setItemCaption(locale, "XX");
    }

    public OldLoginView() {
        setSizeFull();

        // Language bar in the top-right corner for selecting
        // invitation interface language
        final HorizontalLayout languageBar = new HorizontalLayout();
        languageBar.setHeight("50px");
        // addComponent(languageBar);
        // setComponentAlignment(languageBar, Alignment.TOP_RIGHT);

        // Allow selecting a language. We are in a constructor of a
        // CustomComponent, so preselecting the current
        // language of the application can not be done before
        // this (and the selection) component are attached to
        // the application.
        final ComboBox languageSelector = new ComboBox("Select a language") {
            @Override
            public void attach() {
                super.attach();
                // setValue(getLocale());
            }
        };

        // for (int i=0; i<locales.length; i++) {
        String locale = "es";
        languageSelector.addItem(locale);
        languageSelector.setItemCaption(locale, "español");

        // Automatically select the current locale
        // if (locales[i].equals(getLocale()))
        languageSelector.setValue(locale);

        // }

        // Create the invitation input field
        invitationTextField = new TextField("Invitation key:");
        invitationTextField.setWidth("300px");
        invitationTextField.setRequired(true);
        invitationTextField.setInputPrompt("Your questionnair invitation key (eg. 12345678)");
        invitationTextField.setInvalidAllowed(false);

        // Create login button
        enterButton = new Button("Enter", this);

        // Add both to a panel
        VerticalLayout fields = new VerticalLayout(languageSelector, invitationTextField, enterButton);
        fields.setCaption("Please enter your invitation key to access the questionnair");
        fields.setSpacing(true);
        fields.setMargin(new MarginInfo(true, true, true, false));
        fields.setSizeUndefined();

        // The view root layout
        VerticalLayout viewLayout = new VerticalLayout(fields);
        viewLayout.setSizeFull();
        viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
        viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
        setCompositionRoot(viewLayout);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        // focus the username field when invitation arrives to the login view
        invitationTextField.focus();
    }

    @Override
    public void buttonClick(ClickEvent event) {
        logger.info("Submitting login");
        // List<QuestionnaireDTO> questionnaires = questionnairResource.list();
        // System.out.println(questionnaires);
        //
        // Validate the fields using the navigator. By using validors for the
        // fields we reduce the amount of queries we have to use to the database
        // for wrongly entered passwords
        //
        if (!invitationTextField.isValid()) {
            return;
        }

        String invitation = invitationTextField.getValue();
        WrappedSession session = VaadinService.getCurrentRequest().getWrappedSession();

        QuestionnaireResource proxy = JAXRSClientFactory.create("", QuestionnaireResource.class,
                Collections.singletonList(new JacksonJsonProvider()), "respondent", invitation, null);

        //
        // Validate username and password with database here. For examples sake
        // I use a dummy username and password.
        //
        boolean isValid = true;
        if (isValid) {
            // Store the current invitation in the service session
            getSession().setAttribute("invitation", invitation);
            session.setAttribute("username", "respondent");
            session.setAttribute("password", invitation);

            // Navigate to main view
            getUI().getNavigator().navigateTo(QuestionnaireView.NAME);
        } else {
            // Wrong password clear the password field and refocuses it
            invitationTextField.setValue(null);
            invitationTextField.focus();
        }
    }
}
