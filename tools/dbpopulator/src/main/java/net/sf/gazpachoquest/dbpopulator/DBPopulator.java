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
import net.sf.gazpachoquest.dto.SectionDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionDTO;
import net.sf.gazpachoquest.dto.ResearchDTO;
import net.sf.gazpachoquest.dto.UserDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;
import net.sf.gazpachoquest.facades.GroupFacade;
import net.sf.gazpachoquest.facades.MailMessageFacade;
import net.sf.gazpachoquest.facades.QuestionnaireDefinitionEditorFacade;
import net.sf.gazpachoquest.facades.ResearchFacade;
import net.sf.gazpachoquest.facades.UserFacade;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;
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
    private QuestionnaireDefinitionEditorFacade questionnaireDefinitionEditorFacade;

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
        // populateForDemo(respondents);
        populateForFullDemo(respondents);
    }

    public void populateForJUnitTest(Set<UserDTO> respondents) {
        QuestionnaireDefinitionDTO questionnaireDefinition = demoSurveyCreator.create();
        asignDefaultMailTemplate(questionnaireDefinition);
        questionnaireDefinitionEditorFacade.confirm(questionnaireDefinition);

        ResearchDTO research = ResearchDTO
                .with()
                .type(ResearchAccessType.BY_INVITATION)
                .name("New private Questionnaire " + questionnaireDefinition.getLanguageSettings().getTitle()
                        + " started").startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        researchFacade.save(research);

        research = ResearchDTO
                .with()
                .type(ResearchAccessType.OPEN_ACCESS)
                .name("New open Questionnaire " + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        // researchFacade.save(research);
    }

    public void populateForFullDemo(Set<UserDTO> respondents) {
        // No Randomization enabled
        QuestionnaireDefinitionDTO questionnaireDefinition = sampleQuizCreator.create();
        asignDefaultMailTemplate(questionnaireDefinition);
        questionnaireDefinitionEditorFacade.confirm(questionnaireDefinition);

        ResearchDTO research = ResearchDTO.with().type(ResearchAccessType.BY_INVITATION)
                .name("New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        researchFacade.save(research);

        research = ResearchDTO.with().type(ResearchAccessType.OPEN_ACCESS)
                .name("Anonymous New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        researchFacade.save(research);

        questionnaireDefinition = sampleQuizCreator.create();
        questionnaireDefinition.setRenderingMode(RenderingMode.ALL_IN_ONE);
        questionnaireDefinition = questionnaireDefinitionEditorFacade.save(questionnaireDefinition);

        asignDefaultMailTemplate(questionnaireDefinition);
        questionnaireDefinitionEditorFacade.confirm(questionnaireDefinition);

        // Question Randomization Enabled
        questionnaireDefinition = sampleQuizCreator.create();
        questionnaireDefinition.setQuestionsPerPage(1);
        questionnaireDefinition.setRandomizationStrategy(RandomizationStrategy.QUESTIONS_RANDOMIZATION);
        questionnaireDefinition = questionnaireDefinitionEditorFacade.save(questionnaireDefinition);

        asignDefaultMailTemplate(questionnaireDefinition);
        questionnaireDefinitionEditorFacade.confirm(questionnaireDefinition);

        research = ResearchDTO.with().type(ResearchAccessType.BY_INVITATION)
                .name("New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        researchFacade.save(research);

        research = ResearchDTO.with().type(ResearchAccessType.OPEN_ACCESS)
                .name("Anonymous New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        researchFacade.save(research);

        // Groups Randomization Enabled
        questionnaireDefinition = sampleQuizCreator.create();
        questionnaireDefinition.setRandomizationStrategy(RandomizationStrategy.GROUPS_RANDOMIZATION);
        questionnaireDefinition = questionnaireDefinitionEditorFacade.save(questionnaireDefinition);

        asignDefaultMailTemplate(questionnaireDefinition);
        questionnaireDefinitionEditorFacade.confirm(questionnaireDefinition);

        research = ResearchDTO.with().type(ResearchAccessType.BY_INVITATION)
                .name("New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        researchFacade.save(research);

        research = ResearchDTO.with().type(ResearchAccessType.OPEN_ACCESS)
                .name("Anonymous New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        researchFacade.save(research);

        // First Group Randomization Enabled
        questionnaireDefinition = sampleQuizCreator.create();
        SectionDTO firstSection = questionnaireDefinition.getSections().get(0);
        firstSection.setRandomizationEnabled(true);
        questionnaireDefinitionEditorFacade.save(firstSection);

        asignDefaultMailTemplate(questionnaireDefinition);
        questionnaireDefinitionEditorFacade.confirm(questionnaireDefinition);

        research = ResearchDTO.with().type(ResearchAccessType.BY_INVITATION)
                .name("New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        researchFacade.save(research);

        research = ResearchDTO.with().type(ResearchAccessType.OPEN_ACCESS)
                .name("Anonymous New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        researchFacade.save(research);

        questionnaireDefinition = fastFoodSurveyCreator.create();
        asignDefaultMailTemplate(questionnaireDefinition);
        questionnaireDefinitionEditorFacade.confirm(questionnaireDefinition);

        research = ResearchDTO
                .with()
                .type(ResearchAccessType.OPEN_ACCESS)
                .name("New customer satisfation survey " + questionnaireDefinition.getLanguageSettings().getTitle()
                        + " started").startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        researchFacade.save(research);

    }

    public void populateForDemo(Set<UserDTO> respondents) {
        QuestionnaireDefinitionDTO questionnaireDefinition = sampleQuizCreator.create();
        asignDefaultMailTemplate(questionnaireDefinition);
        questionnaireDefinitionEditorFacade.confirm(questionnaireDefinition);
        Set<QuestionnaireDefinitionDTO> questionnairDefinitions = new HashSet<>();
        questionnairDefinitions.add(questionnaireDefinition);

        ResearchDTO research = ResearchDTO.with().type(ResearchAccessType.BY_INVITATION)
                .name("New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        researchFacade.save(research);

        research = ResearchDTO.with().type(ResearchAccessType.OPEN_ACCESS)
                .name("Anonymous New Quiz" + questionnaireDefinition.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        research.addQuestionnaireDefinition(questionnaireDefinition);
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }

        researchFacade.save(research);

        questionnaireDefinition = fastFoodSurveyCreator.create();
        asignDefaultMailTemplate(questionnaireDefinition);
        questionnaireDefinitionEditorFacade.confirm(questionnaireDefinition);
        questionnairDefinitions = new HashSet<>();
        questionnairDefinitions.add(questionnaireDefinition);

        research = ResearchDTO
                .with()
                .type(ResearchAccessType.OPEN_ACCESS)
                .name("New customer satisfation survey " + questionnaireDefinition.getLanguageSettings().getTitle()
                        + " started").startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        for (UserDTO respondent : respondents) {
            research.addRespondent(respondent);
        }
        research.addQuestionnaireDefinition(questionnaireDefinition);
        researchFacade.save(research);

    }

    public MailMessageTemplateDTO asignDefaultMailTemplate(final QuestionnaireDefinitionDTO questionnair) {
        MailMessageTemplateDTO mailMessageTemplate = MailMessageTemplateDTO
                .with()
                .language(Language.EN)
                .questionnairDefinition(questionnair)
                .type(MailMessageTemplateType.INVITATION)
                .fromAddress("support@gazpacho.net")
                .replyTo("support@gazpacho.net")
                .mailMessageTemplateLanguageSettingsStart()
                .subject("Invitation to participate in a questionnaire")
                .body("Dear Mr. $lastname, <br> You have been invited to take this questionnaire. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"$link\">Click here</a> to take the questionnaireDefinition")
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
        labelSet = questionnaireDefinitionEditorFacade.save(labelSet);

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

        questionnaireDefinitionEditorFacade.save(labelSet);
    }

    protected Set<UserDTO> addRespondents() {
        UserDTO tyrion = UserDTO.with().givenNames("Tyrion").surname("Lannister")
                .email("tyrion.lannister@kingslanding.net").gender(Gender.MALE).build();
        // tyrion.setAttribute("age", "25");
        // tyrion.setAttribute("position", "Developer");
        tyrion = userFacade.save(tyrion);

        UserDTO jon = UserDTO.with().preferredLanguage(Language.ES).givenNames("Jon").surname("Snow")
                .email("jon.snow@nightswatch.net").gender(Gender.MALE).build();
        // jon.setAttribute("age", "25");
        // jon.setAttribute("position", "Manager");
        jon = userFacade.save(jon);

        UserDTO arya = UserDTO.with().preferredLanguage(Language.EN).givenNames("Arya").surname("Stark")
                .email("arya.stark@winterfell.net").gender(Gender.FEMALE).build();
        // arya.setAttribute("age", "25");
        // arya.setAttribute("position", "Manager");
        arya = userFacade.save(arya);

        UserDTO catelyn = UserDTO.with().preferredLanguage(Language.FI).givenNames("Catelyn").surname("Stark")
                .email("catelyn.stark@winterfell.net").gender(Gender.FEMALE).build();
        // catelyn.setAttribute("age", "21");
        // catelyn.setAttribute("position", "Manager");
        catelyn = userFacade.save(catelyn);

        Set<UserDTO> respondents = new HashSet<>();
        respondents.add(tyrion);
        respondents.add(arya);
        respondents.add(catelyn);
        respondents.add(jon);
        return respondents;
    }

}
