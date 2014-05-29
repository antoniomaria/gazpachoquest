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

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.auth.RespondentAccount;
import net.sf.gazpachoquest.questionnaires.renderer.question.Renderer;
import net.sf.gazpachoquest.questionnaires.renderer.question.RendererFactory;
import net.sf.gazpachoquest.questionnaires.renderer.question.Renderers;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.QuestionType;
import net.sf.gazpachoquest.types.RenderingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinServletService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
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

	@Inject
	private RendererFactory rendererFactory;
	
    @Override
    public void enter(ViewChangeEvent event) {
        logger.debug("Entering {} view ", QuestionnairView.NAME);
        setSizeFull();
        addStyleName(Reindeer.LAYOUT_BLUE);
        addStyleName("questionnaires");
        VerticalLayout centralLayout = new VerticalLayout();
        centralLayout.setMargin(true);
        // centralLayout.addStyleName("questionnaires");
        // new Responsive(centralLayout);

        RespondentAccount respondent = (RespondentAccount) VaadinServletService.getCurrentServletRequest()
                .getUserPrincipal();
        Integer questionnairId = respondent.getGrantedQuestionnairIds().iterator().next();
        logger.debug("Trying to fetch questionnair identified with id  = {} ", questionnairId);
        QuestionnairDTO questionnair = questionnairResource.getDefinition(questionnairId);
        

        PageDTO page = questionnairResource.getPage(questionnairId, RenderingMode.GROUP_BY_GROUP, BrowsingAction.ENTERING);
        
        List<QuestionDTO> questions = page.getQuestions();
        
        
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        Label label = new Label(questionnair.getLanguageSettings().getTitle());
        label.addStyleName(Reindeer.LABEL_H1);
        mainLayout.addComponent(label);

        for (QuestionDTO question : questions) {
            QuestionLanguageSettingsDTO languageSettings = question.getLanguageSettings();
            Label questionTitle = new Label(languageSettings.getTitle());
            //mainLayout.addComponent(questionTitle);
        }
        
        Renderer renderer = rendererFactory.createRenderer(questions.get(0).getType());
        
        Component panel = renderer.render(questions.get(0));
        
		mainLayout.addComponent(panel );
        
        // Add the responsive capabilities to the components
        Responsive.makeResponsive(label);
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
