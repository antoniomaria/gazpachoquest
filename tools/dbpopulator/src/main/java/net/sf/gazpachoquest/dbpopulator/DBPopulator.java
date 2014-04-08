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

import net.sf.gazpachoquest.dto.LabelDTO;
import net.sf.gazpachoquest.dto.LabelSetDTO;
import net.sf.gazpachoquest.dto.MailMessageTemplateDTO;
import net.sf.gazpachoquest.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.ManagerDTO;
import net.sf.gazpachoquest.dto.ParticipantDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionGroupDTO;
import net.sf.gazpachoquest.dto.QuestionOptionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.StudyDTO;
import net.sf.gazpachoquest.dto.SubquestionDTO;
import net.sf.gazpachoquest.dto.support.TranslationDTO;
import net.sf.gazpachoquest.facades.MailMessageFacade;
import net.sf.gazpachoquest.facades.ManagerFacade;
import net.sf.gazpachoquest.facades.ParticipantFacade;
import net.sf.gazpachoquest.facades.QuestionnairDefinitionEditorFacade;
import net.sf.gazpachoquest.facades.StudyFacade;
import net.sf.gazpachoquest.types.Gender;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;
import net.sf.gazpachoquest.types.QuestionType;
import net.sf.gazpachoquest.types.StudyAccessType;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBPopulator {
    @Autowired
    private MailMessageFacade mailMessageFacade;

    @Autowired
    private ManagerFacade managerFacade;

    @Autowired
    private ParticipantFacade participantFacade;

    @Autowired
    private QuestionnairDefinitionEditorFacade questionnairDefinitionEditorFacade;

    @Autowired
    private StudyFacade studyFacade;

    // http://www.objectpartners.com/2012/05/17/creating-a-hierarchical-test-data-builder-using-generics/
    public void populate() {
        // System account
        managerFacade.save(ManagerDTO.with().givenNames("support").surname("support").email("support@gazpacho.net")
                .username("support").build());

        Set<ParticipantDTO> participants = addParticipants();

        populateForJUnitTest(participants);
        populateForDemo(participants);
    }

    public void populateForJUnitTest(Set<ParticipantDTO> participants) {
        QuestionnairDefinitionDTO questionnairDef = null;
        questionnairDef = createDemoSurvey();
        asignDefaultMailTemplate(questionnairDef);
        questionnairDefinitionEditorFacade.confirm(questionnairDef);

        Set<QuestionnairDefinitionDTO> questionnairDefinitions = new HashSet<>();
        questionnairDefinitions.add(questionnairDef);

        StudyDTO study = StudyDTO.with().questionnairDefinitions(questionnairDefinitions)
                .type(StudyAccessType.BY_INVITATION)
                .name("New private Questionnair " + questionnairDef.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).participants(participants)
                .build();
        studyFacade.save(study);

        study = StudyDTO.with().questionnairDefinitions(questionnairDefinitions).type(StudyAccessType.OPEN_ACCESS)
                .name("New open Questionnair " + questionnairDef.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31")).build();
        studyFacade.save(study);
    }

    public void populateForDemo(Set<ParticipantDTO> participants) {

        QuestionnairDefinitionDTO questionnairDef = createFastFoodSurvey();
        asignDefaultMailTemplate(questionnairDef);
        questionnairDefinitionEditorFacade.confirm(questionnairDef);
        Set<QuestionnairDefinitionDTO> questionnairDefinitions = new HashSet<>();
        questionnairDefinitions.add(questionnairDef);

        StudyDTO study = StudyDTO.with().questionnairDefinitions(questionnairDefinitions)
                .type(StudyAccessType.BY_INVITATION)
                .name("New survey " + questionnairDef.getLanguageSettings().getTitle() + " started")
                .startDate(DateTime.now()).expirationDate(DateTime.parse("2014-12-31"))

                .participants(participants).build();
        studyFacade.save(study);

    }

    public MailMessageTemplateDTO asignDefaultMailTemplate(final QuestionnairDefinitionDTO survey) {
        MailMessageTemplateDTO mailMessageTemplate = MailMessageTemplateDTO
                .with()
                .language(Language.EN)
                .questionnairDefinition(survey)
                .type(MailMessageTemplateType.INVITATION)
                .fromAddress("support@gazpacho.net")
                .replyTo("support@gazpacho.net")
                .mailMessageTemplateLanguageSettingsStart()
                .subject("PersonalInvitation to participate in questionnairDefinition")
                .body("Dear Mr. $lastname, <br> You have been invited to take this questionnairDefinition. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"$link\">Click here</a> to take the questionnairDefinition")
                .mailMessageTemplateLanguageSettingsEnd().build();
        mailMessageTemplate = mailMessageFacade.save(mailMessageTemplate);

        MailMessageTemplateLanguageSettingsDTO languageSettings = MailMessageTemplateLanguageSettingsDTO
                .with()
                .subject("Invitación para participar en una encuesta")
                .body("Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>"
                        + "Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario"
                        + "<a href=\"$link\">Click aqui</a> para empezar").build();

        TranslationDTO<MailMessageTemplateDTO, MailMessageTemplateLanguageSettingsDTO> mailMessageTemplateTranslation = new TranslationDTO<>();
        mailMessageTemplateTranslation.setLanguage(Language.ES);
        mailMessageTemplateTranslation.setLanguageSettings(languageSettings);
        mailMessageTemplateTranslation.setTranslatedEntity(mailMessageTemplate);

        mailMessageFacade.saveTranslation(mailMessageTemplateTranslation);

        return mailMessageTemplate;
    }

    public QuestionnairDefinitionDTO createDemoSurvey() {
        QuestionnairDefinitionDTO survey = QuestionnairDefinitionDTO
                .with()
                .language(Language.EN)
                .surveyLanguageSettingsStart()
                .title("Sample QuestionnairDefinition")
                .description(
                        "<p>This is a <strong><em>sample questionnairDefinition</em></strong> designed for testing GazpachoSurvey.</p>")
                .welcomeText("Thank you for taking the time to participate in this questionnairDefinition.")
                .surveyLanguageSettingsEnd().build();
        survey = questionnairDefinitionEditorFacade.save(survey);

        TranslationDTO<QuestionnairDefinitionDTO, QuestionnairDefinitionLanguageSettingsDTO> surveyTranslation = new TranslationDTO<>();
        surveyTranslation.setLanguage(Language.ES);
        surveyTranslation.setLanguageSettings(QuestionnairDefinitionLanguageSettingsDTO.with()
                .title("Ejemplo de encuesta")
                .description("<p>Esto es una encuesta de ejemplo diseñada para GazpachoSurvey</p>")
                .welcomeText("Gracias por participar en esta encuesta").build());
        surveyTranslation.setTranslatedEntity(survey);

        questionnairDefinitionEditorFacade.saveSurveyTranslation(surveyTranslation);

        QuestionGroupDTO questionGroup1 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("QuestionGroup 1").pageLanguageSettingsEnd().build();

        survey.addQuestionGroup(questionGroup1);
        survey = questionnairDefinitionEditorFacade.save(survey);

        questionGroup1 = survey.getLastQuestionGroupDTO();

        QuestionGroupDTO questionGroup2 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("QuestionGroup 2").pageLanguageSettingsEnd().build();

        survey.addQuestionGroup(questionGroup2);
        survey = questionnairDefinitionEditorFacade.save(survey);
        questionGroup2 = survey.getLastQuestionGroupDTO();

        QuestionGroupDTO questionGroup3 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("QuestionGroup 3").pageLanguageSettingsEnd().build();

        survey.addQuestionGroup(questionGroup3);
        survey = questionnairDefinitionEditorFacade.save(survey);
        questionGroup3 = survey.getLastQuestionGroupDTO();

        // 1 Single Textbox
        QuestionDTO question = QuestionDTO.with().type(QuestionType.S).language(Language.EN).code("Q1")
                .languageSettingsStart().title("What is your name?").languageSettingsEnd().required(true).build();
        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);

        // 2 Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q2").languageSettingsStart()
                .title("What is your age group?").languageSettingsEnd().required(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("0-14 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("15-19 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("20-24 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("25-29 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN).title("30-34 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN).title("35-39 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O7").language(Language.EN).title("40-44 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O8").language(Language.EN).title("45-49 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O9").language(Language.EN).title("50-54 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O10").language(Language.EN).title("55-59 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O11").language(Language.EN).title("60-64 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O12").language(Language.EN).title("65-69 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O13").language(Language.EN).title("70-74 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O14").language(Language.EN).title("75-79 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O15").language(Language.EN).title("80 and over")
                .build());

        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);

        // 3 Numeric
        question = QuestionDTO.with().type(QuestionType.N).language(Language.EN).code("Q3").languageSettingsStart()
                .title("And for our records, specifically how old are you?").languageSettingsEnd().required(true)
                .build();

        questionGroup1.addQuestion(question);
        questionGroup1 = questionnairDefinitionEditorFacade.save(questionGroup1);

        // 4 Comment/Essay Box
        question = QuestionDTO.with().type(QuestionType.T).language(Language.EN).code("Q4").languageSettingsStart()
                .title("Please tell us a little about yourself. What was your first job, and did you enjoy it?")
                .languageSettingsEnd().required(true).build();

        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);

        // 5 List (Radio) Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q5").languageSettingsStart()
                .title("Given your extraordinary age, how do you find using this questionnairDefinition tool?")
                .languageSettingsEnd().required(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN)
                .title("Very difficult to read, my eyesight is dim").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN)
                .title("Easy, my carer is doing it all for me").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("How <b><i>dare</i></b> you insult me like that! I'm YOUNG").build());

        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);

        // 6 Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).code("Q6").language(Language.EN).languageSettingsStart()
                .title("Which of these ads makes you want to find out more?").languageSettingsEnd().required(true)
                .build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Ad one").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Ad two").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Ad three").build());

        questionGroup2.addQuestion(question);
        questionGroup2 = questionnairDefinitionEditorFacade.save(questionGroup2);

        // 7 Rating Scale (Agree-Disagree) Array Flexible
        question = QuestionDTO
                .with()
                .type(QuestionType.F)
                .code("Q7")
                .language(Language.EN)
                .languageSettingsStart()
                .title("Please have a good look at this ad, and then complete the questions below.<br /><img src='http://www.aptigence.com.au/images/lawyer1.jpg' border='1'>")
                .languageSettingsEnd().required(true).build();

        question.addSubquestion(SubquestionDTO.with().code("Q7.1").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("This ad suggests the lawyer is on my side, not his own")
                .languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q7.2").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart()
                .title("This ad suggests that the lawyer is interested in a life of frugal community service")
                .languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q7.3").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("This ad would be enough to get me to hire this lawyer")
                .languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q7.4").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("This ad gives me confidence in the lawyers experience")
                .languageSettingsEnd().build());

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Agree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("Neither agree nor disagree").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Disagree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN).title("Disagree strongly")
                .build());

        questionGroup3.addQuestion(question);
        questionGroup3 = questionnairDefinitionEditorFacade.save(questionGroup3);

        // 8. List checkbox - Multiple_Answers
        question = QuestionDTO.with().type(QuestionType.M).code("Q8").language(Language.EN).languageSettingsStart()
                .title("What flavors of ice cream do you like?. Choose all that apply.").languageSettingsEnd()
                .required(false).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Vanilla").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Chocolate").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Strawberry")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Pistachio").build());

        questionGroup3.addQuestion(question);
        questionGroup3 = questionnairDefinitionEditorFacade.save(questionGroup3);

        return survey;
    }

    public void puopulateLabelSet() {
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

        // Comment for testing
        questionnairDefinitionEditorFacade.save(labelSet);
    }

    public QuestionnairDefinitionDTO createFastFoodSurvey() {
        QuestionnairDefinitionDTO survey = QuestionnairDefinitionDTO
                .with()
                .language(Language.EN)
                .surveyLanguageSettingsStart()
                .title("Food Quality QuestionnairDefinition")
                .description(
                        "We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.")
                .welcomeText(
                        "Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:")
                .surveyLanguageSettingsEnd().build();
        survey = questionnairDefinitionEditorFacade.save(survey);

        QuestionGroupDTO questionGroup = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("Fast Food QuestionnairDefinition - QuestionGroup").pageLanguageSettingsEnd().build();

        survey.addQuestionGroup(questionGroup);
        survey = questionnairDefinitionEditorFacade.save(survey);
        questionGroup = survey.getLastQuestionGroupDTO();

        // Question 1: Rating Scale (1-5)
        QuestionDTO question = QuestionDTO.with().type(QuestionType.F).code("Q1").language(Language.EN)
                .languageSettingsStart().title("<b>Food Quality</b>").languageSettingsEnd().required(true).build();

        question.addSubquestion(SubquestionDTO.with().code("Q1.1").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The food is served hot and fresh").languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q1.2").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The menu has a good variety of items").languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q1.3").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The quality of food is excellent").languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q1.4").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The food is tasty and flavorful").languageSettingsEnd().build());

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Agree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("Neither agree nor disagree").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Disagree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN).title("Disagree strongly")
                .build());

        questionGroup.addQuestion(question);
        questionGroup = questionnairDefinitionEditorFacade.save(questionGroup);

        // Question 2: Rating Scale (Agree-Disagree)
        question = QuestionDTO.with().type(QuestionType.F).code("Q2").language(Language.EN).languageSettingsStart()
                .title("<b>Resturant</b>").languageSettingsEnd().required(true).build();

        question.addSubquestion(SubquestionDTO.with().code("Q2.1").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("My food order was correct and complete").languageSettingsEnd().build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.2").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("Employees are patient when taking my order").languageSettingsEnd()
                .build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.3").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("I was served promptly").languageSettingsEnd().build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.4").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("Availability of sauces, utensils, napkins, etc. was good")
                .languageSettingsEnd().build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.5").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The menu board was easy to read").languageSettingsEnd().build());

        question.addSubquestion(SubquestionDTO.with().code("Q2.6").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("The drive-thru sound system was cleara").languageSettingsEnd().build());

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Agree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("Neither agree nor disagree").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Disagree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN).title("Disagree strongly")
                .build());

        questionGroup.addQuestion(question);
        questionGroup = questionnairDefinitionEditorFacade.save(questionGroup);

        // Question 3: Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).code("Q3").language(Language.EN).languageSettingsStart()
                .title("Indicate total household income").languageSettingsEnd().required(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O1").title("under 25,000€")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O2").title("25,000 - 29,999€")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O3").title("30,000 - 34,999€")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O4").title("35,000 - 39,999€")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).code("O5").title("Over 85,000€")
                .build());

        questionGroup.addQuestion(question);
        questionGroup = questionnairDefinitionEditorFacade.save(questionGroup);

        return survey;
    }

    protected Set<ParticipantDTO> addParticipants() {
        ParticipantDTO tyrion = ParticipantDTO.with().preferedLanguage(Language.EN).givenNames("Tyrion")
                .surname("Lannister").email("tyrion.lannister@kingslanding.net").gender(Gender.MALE).build();
        tyrion = participantFacade.save(tyrion);

        ParticipantDTO jon = ParticipantDTO.with().preferedLanguage(Language.ES).givenNames("Jon").surname("Snow")
                .email("jon.snow@nightswatch.net").gender(Gender.MALE).build();
        jon = participantFacade.save(jon);

        ParticipantDTO arya = ParticipantDTO.with().givenNames("Arya").surname("Stark")
                .email("arya.stark@winterfell.net").gender(Gender.FEMALE).build();
        arya = participantFacade.save(arya);

        ParticipantDTO catelyn = ParticipantDTO.with().preferedLanguage(Language.FI).givenNames("Catelyn")
                .surname("Stark").email("catelyn.stark@winterfell.net").gender(Gender.FEMALE).build();
        catelyn = participantFacade.save(catelyn);

        Set<ParticipantDTO> participants = new HashSet<>();
        participants.add(tyrion);
        participants.add(arya);
        participants.add(catelyn);
        participants.add(jon);
        return participants;
    }

}
