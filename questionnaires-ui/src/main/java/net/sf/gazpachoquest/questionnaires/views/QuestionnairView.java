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
package net.sf.gazpachoquest.questionnaires.views;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.addon.responsive.Responsive;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinServletService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@CDIView(QuestionnairView.NAME)
@RolesAllowed(RespondentAccount.DEFAULT_ROLE_NAME)
public class QuestionnairView extends CustomComponent implements View {

    private static final long serialVersionUID = -4474306191162456568L;

    public static final String NAME = "questionnair";

    private static Logger logger = LoggerFactory.getLogger(QuestionnairView.class);

    @Inject
    @GazpachoResource
    private QuestionnairResource questionnairResource;

    @Override
    public void enter(ViewChangeEvent event) {
        logger.debug("Entering {} view ", QuestionnairView.NAME);
        setSizeFull();
        addStyleName(Reindeer.LAYOUT_BLUE);
        VerticalLayout centralLayout = new VerticalLayout();
        centralLayout.setMargin(true);
        new Responsive(centralLayout);
        
        RespondentAccount respondent = (RespondentAccount) VaadinServletService.getCurrentServletRequest()
                .getUserPrincipal();
        Integer questionnairId = respondent.getGrantedQuestionnairIds().iterator().next();
        logger.debug("Trying to fetch questionnair identified with id  = {} ", questionnairId);
        QuestionnairDTO questionnair = questionnairResource.getDefinition(respondent.getGrantedQuestionnairIds()
                .iterator().next());

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        Label label = new Label(questionnair.getLanguageSettings().getTitle());
        label.addStyleName(Reindeer.LABEL_H1);
        mainLayout.addComponent(label);
        // mainLayout.setExpandRatio(content, 1);
        centralLayout.addComponent(mainLayout);
        setCompositionRoot(centralLayout);
    }

    private HorizontalLayout createHeader() {
        final HorizontalLayout layout = new HorizontalLayout();
        layout.setWidth("100%");
        layout.setMargin(true);
        layout.setSpacing(true);
        final Label title = new Label("Activiti + Vaadin - A Match Made in Heaven");
        title.addStyleName(Reindeer.LABEL_H1);
        layout.addComponent(title);
        layout.setExpandRatio(title, 1.0f);

        Label currentUser = new Label();
        currentUser.setSizeUndefined();
        layout.addComponent(currentUser);
        layout.setComponentAlignment(currentUser, Alignment.MIDDLE_RIGHT);

        Button logout = new Button("Logout");
        logout.addStyleName(Reindeer.BUTTON_SMALL);
        // logout.addListener(createLogoutButtonListener());
        layout.addComponent(logout);
        layout.setComponentAlignment(logout, Alignment.MIDDLE_RIGHT);

        return layout;
    }
}
