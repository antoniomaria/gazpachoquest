/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dbpopulator;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachoquest.dbpopulator.samples.DemoSurveyCreator;
import net.sf.gazpachoquest.dbpopulator.samples.FastFoodSurveyCreator;
import net.sf.gazpachoquest.dbpopulator.samples.SampleQuizCreator;
import net.sf.gazpachoquest.dto.GroupDTO;
import net.sf.gazpachoquest.dto.LabelDTO;
import net.sf.gazpachoquest.dto.LabelSetDTO;
import net.sf.gazpachoquest.dto.MailMessageTemplateDTO;
import net.sf.gazpachoquest.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.dto.ResearchDTO;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;
import net.sf.gazpachoquest.facades.GroupFacade;
import net.sf.gazpachoquest.facades.MailMessageFacade;
import net.sf.gazpachoquest.facades.QuestionnairDefinitionEditorFacade;
import net.sf.gazpachoquest.facades.ResearchFacade;
import net.sf.gazpachoquest.facades.UserFacade;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;
import net.sf.gazpachoquest.types.ResearchAccessType;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBPopulator {
    @Autowired
    private MailMessageFacade mailMessageFacade;

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private GroupFacade groupFacade;

    @Autowired
    private QuestionnairDefinitionEditorFacade questionnairDefinitionEditorFacade;

    @Autowired
    private ResearchFacade researchFacade;

    @Autowired
    private FastFoodSurveyCreator fastFoodSurveyCreator;

    @Autowired
    private SampleQuizCreator sampleQuizCreator;

    @Autowired
    private DemoSurveyCreator demoSurveyCreator;

    // http://www.objectpartners.com/2012/05/17/creating-a-hierarchical-test-data-builder-using-generics/
    public void populate() {
        // System account
        userFacade.save(UserDTO.with().givenNames("support").surname("support").email("support@gazpacho.net")
                .username("support").build());

        GroupDTO groupDTO = GroupDTO.with().name("Respondents").description("Respondent group").build();
        groupDTO = groupFacade.save(groupDTO);

        Set<UserDTO> respondents = addRespondents();

        // populateForJUnitTest(respondents);
        populateForDemo(respondents);
    }

    public void populateForJUnitTest(Set<UserDTO> respondents) {
        QuestionnairDefinitionDTO questionnairDef = demoSurveyCreator.create();
        asignDefaultMailTemplate(questionnairDef);
        questionnairDefinitionEditorFacade.confirm(questionnairDef);

        ResearchDTO research = ResearchDTO.with().type(ResearchAccessType.BY_INVITATION)
                .name("New private Questionnair " + questionnairDef.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnairDefinition(questionnairDef);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        researchFacade.save(research);

        research = ResearchDTO.with().type(ResearchAccessType.OPEN_ACCESS)
                .name("New open Questionnair " + questionnairDef.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnairDefinition(questionnairDef);
        researchFacade.save(research);
    }

    public void populateForDemo(Set<UserDTO> respondents) {
        QuestionnairDefinitionDTO questionnairDef = sampleQuizCreator.create();
        asignDefaultMailTemplate(questionnairDef);
        questionnairDefinitionEditorFacade.confirm(questionnairDef);
        Set<QuestionnairDefinitionDTO> questionnairDefinitions = new HashSet<>();
        questionnairDefinitions.add(questionnairDef);

        ResearchDTO research = ResearchDTO.with().type(ResearchAccessType.BY_INVITATION)
                .name("New Quiz" + questionnairDef.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnairDefinition(questionnairDef);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        researchFacade.save(research);

        research = ResearchDTO.with().type(ResearchAccessType.OPEN_ACCESS)
                .name("Anonymous New Quiz" + questionnairDef.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnairDefinition(questionnairDef);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }

        researchFacade.save(research);

        questionnairDef = fastFoodSurveyCreator.create();
        asignDefaultMailTemplate(questionnairDef);
        questionnairDefinitionEditorFacade.confirm(questionnairDef);
        questionnairDefinitions = new HashSet<>();
        questionnairDefinitions.add(questionnairDef);

        research = ResearchDTO
                .with()
                .type(ResearchAccessType.OPEN_ACCESS)
                .name("New customer satisfation survey " + questionnairDef.getLanguageSettings().getTitle()
                        + " started").startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        research.addQuestionnairDefinition(questionnairDef);
        researchFacade.save(research);

    }

    public MailMessageTemplateDTO asignDefaultMailTemplate(final QuestionnairDefinitionDTO questionnair) {
        MailMessageTemplateDTO mailMessageTemplate = MailMessageTemplateDTO
                .with()
                .language(Language.EN)
                .questionnairDefinition(questionnair)
                .type(MailMessageTemplateType.INVITATION)
                .fromAddress("support@gazpacho.net")
                .replyTo("support@gazpacho.net")
                .mailMessageTemplateLanguageSettingsStart()
                .subject("Invitation to participate in a questionnair")
                .body("Dear Mr. $lastname, <br> You have been invited to take this questionnair. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"$link\">Click here</a> to take the questionnairDefinition")
                .mailMessageTemplateLanguageSettingsEnd().build();
        mailMessageTemplate = mailMessageFacade.save(mailMessageTemplate);

        MailMessageTemplateLanguageSettingsDTO languageSettings = MailMessageTemplateLanguageSettingsDTO
                .with()
                .subject("Invitación para participar en un cuestionario")
                .body("Estimado Sr. $lastname, <br> Has sido invitado para participar en esta cuestionario <br>"
                        + "Nos dedicas 15 minutos para completarlo?, puedes interrumpirlo y completarlo más tarde si es necesario"
                        + "<a href=\"$link\">Click aqui</a> para empezar").build();

        TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> mailMessageTemplateTranslation = new TranslationDTO<>();
        mailMessageTemplateTranslation.setLanguage(Language.ES);
        mailMessageTemplateTranslation.setLanguageSettings(languageSettings);
        mailMessageTemplateTranslation.setTranslatedEntity(mailMessageTemplate);

        mailMessageFacade.saveTranslation(mailMessageTemplateTranslation);

        return mailMessageTemplate;
    }

    public void populateLabelSet() {
        LabelSetDTO labelSet = LabelSetDTO.with().language(Language.EN).name("Feelings").build();
        labelSet = questionnairDefinitionEditorFacade.save(labelSet);

        LabelDTO label = LabelDTO.with().language(Language.EN).title("Agree strongly").build();
        labelSet.addLabel(label);
        label = LabelDTO.with().language(Language.EN).title("Agree somewhat").build();
        labelSet.addLabel(label);

        label = LabelDTO.with().language(Language.EN).title("Neither agree nor disagree").build();
        labelSet.addLabel(label);

        label = LabelDTO.with().language(Language.EN).title("Disagree somewhat").build();
        labelSet.addLabel(label);

        label = LabelDTO.with().language(Language.EN).title("Disagree strongly").build();
        labelSet.addLabel(label);

        questionnairDefinitionEditorFacade.save(labelSet);
    }

    protected Set<UserDTO> addRespondents() {
        UserDTO tyrion = UserDTO.with().preferedLanguage(Language.EN).givenNames("Tyrion").surname("Lannister")
                .email("tyrion.lannister@kingslanding.net").gender(Gender.MALE).build();
        tyrion.setAttribute("age", "25");
        tyrion.setAttribute("position", "Developer");
        tyrion = userFacade.save(tyrion);

        UserDTO jon = UserDTO.with().preferedLanguage(Language.ES).givenNames("Jon").surname("Snow")
                .email("jon.snow@nightswatch.net").gender(Gender.MALE).build();
        jon.setAttribute("age", "25");
        jon.setAttribute("position", "Manager");
        jon = userFacade.save(jon);

        UserDTO arya = UserDTO.with().givenNames("Arya").surname("Stark").email("arya.stark@winterfell.net")
                .gender(Gender.FEMALE).build();
        arya.setAttribute("age", "25");
        arya.setAttribute("position", "Manager");
        arya = userFacade.save(arya);

        UserDTO catelyn = UserDTO.with().preferedLanguage(Language.FI).givenNames("Catelyn").surname("Stark")
                .email("catelyn.stark@winterfell.net").gender(Gender.FEMALE).build();
        catelyn.setAttribute("age", "21");
        catelyn.setAttribute("position", "Manager");
        catelyn = userFacade.save(catelyn);

        
        Set<UserDTO> respondents = new HashSet<>();
        respondents.add(tyrion);
        respondents.add(arya);
        respondents.add(catelyn);
        respondents.add(jon);
        return respondents;
    }

}
