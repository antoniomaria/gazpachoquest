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

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.resource.NotSupportedException;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.QuestionnairPageDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.questionnaires.components.question.QuestionComponent;
import net.sf.gazpachoquest.questionnaires.components.question.QuestionFactory;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.NavigationAction;
import net.sf.gazpachoquest.types.RenderingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.addon.cdiproperties.annotation.ButtonProperties;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinServletService;
import com.vaadin.server.WebBrowser;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@CDIView(QuestionnairView.NAME)
@RolesAllowed(RespondentAccount.DEFAULT_ROLE_NAME)
public class QuestionnairView extends CustomComponent implements View, ClickListener {

    private static final long serialVersionUID = -4474306191162456568L;

    public static final String NAME = "questionnair";

    private static Logger logger = LoggerFactory.getLogger(QuestionnairView.class);

    @Inject
    @GazpachoResource
    private QuestionnairResource questionnairResource;

    @Inject
    private QuestionFactory QuestionFactory;

    private Integer questionnairId;

    private VerticalLayout questionsLayout;

    @Inject
    @ButtonProperties(caption = "Next")
    private Button nextButton;

    @Inject
    @ButtonProperties(caption = "Previous")
    private Button previousButton;

    private RenderingMode renderingMode;

    private Language preferredLanguage;

    public void update(QuestionnairPageDTO page) {
        questionsLayout.removeAllComponents();

        List<QuestionDTO> questions = page.getQuestions();

        for (QuestionDTO questionDTO : questions) {
            QuestionComponent questionComponent;
            try {
                questionComponent = QuestionFactory.build(questionnairId, questionDTO);
                questionsLayout.addComponent(questionComponent);
            } catch (NotSupportedException e) {
                logger.warn(e.getMessage());
            }
        }

        HorizontalLayout buttonsLayout = new HorizontalLayout();

        if (page.getMetadata().isNotFirst()) {
            previousButton.addClickListener(this);
            buttonsLayout.addComponent(previousButton);
        }

        if (page.getMetadata().isNotLast()) {
            nextButton.addClickListener(this);
            buttonsLayout.addComponent(nextButton);
        }
        questionsLayout.addComponent(buttonsLayout);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        logger.debug("Entering {} view ", QuestionnairView.NAME);
        addStyleName(Reindeer.LAYOUT_BLUE);
        addStyleName("questionnaires");

        WebBrowser webBrowser = Page.getCurrent().getWebBrowser();
        Integer screenWidth = webBrowser.getScreenWidth();
        Integer heightWidth = webBrowser.getScreenWidth();

        logger.debug("Broswer screen settings  {} x {}", screenWidth, heightWidth);

        if (heightWidth <= 480) {
            renderingMode = RenderingMode.QUESTION_BY_QUESTION;
        } else {
            renderingMode = RenderingMode.GROUP_BY_GROUP;
        }

        // centralLayout.addStyleName("questionnaires");
        // new Responsive(centralLayout);

        RespondentAccount respondent = (RespondentAccount) VaadinServletService.getCurrentServletRequest()
                .getUserPrincipal();
        if (respondent.hasPreferredLanguage()) {
            preferredLanguage = respondent.getPreferredLanguage();
        } else {
            preferredLanguage = Language.fromLocale(webBrowser.getLocale());
        }
        questionnairId = respondent.getGrantedQuestionnairIds().iterator().next();
        logger.debug("Trying to fetch questionnair identified with id  = {} ", questionnairId);
        QuestionnairDTO questionnair = questionnairResource.getDefinition(questionnairId);

        QuestionnairPageDTO page = questionnairResource.getPage(questionnairId, renderingMode, preferredLanguage,
                NavigationAction.ENTERING);

        logger.debug("Displaying page {}/{} with {} questions", page.getMetadata().getNumber(), page.getMetadata()
                .getNumber(), page.getQuestions().size());
        questionsLayout = new VerticalLayout();
        update(page);

        Label questionnairTitle = new Label(questionnair.getLanguageSettings().getTitle());
        questionnairTitle.addStyleName(Reindeer.LABEL_H1);

        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setMargin(true);
        mainLayout.addComponent(questionnairTitle);
        mainLayout.addComponent(questionsLayout);
        // Add the responsive capabilities to the components

        Panel centralLayout = new Panel();
        centralLayout.setContent(mainLayout);
        centralLayout.setSizeFull();
        centralLayout.getContent().setSizeUndefined();

        Responsive.makeResponsive(questionnairTitle);
        setCompositionRoot(centralLayout);
        setSizeFull();
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

    @Override
    public void buttonClick(ClickEvent event) {
        if (nextButton.equals(event.getButton())) {
            QuestionnairPageDTO page = questionnairResource.getPage(questionnairId, renderingMode, preferredLanguage,
                    NavigationAction.NEXT);
            update(page);
        } else {
            QuestionnairPageDTO page = questionnairResource.getPage(questionnairId, renderingMode, preferredLanguage,
                    NavigationAction.PREVIOUS);
            update(page);
        }

    }
}
