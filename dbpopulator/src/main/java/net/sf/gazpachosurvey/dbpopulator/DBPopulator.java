package net.sf.gazpachosurvey.dbpopulator;

import java.util.HashSet;
import java.util.Set;

import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.QuestionGroupDTO;
import net.sf.gazpachosurvey.dto.QuestionOptionDTO;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.dto.SurveyInstanceDTO;
import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.UserDTO;
import net.sf.gazpachosurvey.dto.support.TranslationDTO;
import net.sf.gazpachosurvey.facades.MailMessageFacade;
import net.sf.gazpachosurvey.facades.ParticipantFacade;
import net.sf.gazpachosurvey.facades.SurveyEditorFacade;
import net.sf.gazpachosurvey.facades.SurveyInstanceFacade;
import net.sf.gazpachosurvey.facades.UserFacade;
import net.sf.gazpachosurvey.types.Gender;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.MailMessageTemplateType;
import net.sf.gazpachosurvey.types.QuestionType;
import net.sf.gazpachosurvey.types.SurveyInstanceType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBPopulator {
    @Autowired
    private SurveyEditorFacade surveyEditorFacade;

    @Autowired
    private ParticipantFacade participantFacade;

    @Autowired
    private SurveyInstanceFacade surveyInstanceFacade;

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private MailMessageFacade mailMessageFacade;

    public MailMessageTemplateDTO asignDefaultMailTemplate(final SurveyDTO survey) {
        MailMessageTemplateDTO mailMessageTemplate = MailMessageTemplateDTO
                .with()
                .language(Language.EN)
                .survey(survey)
                .type(MailMessageTemplateType.INVITATION)
                .fromAddress("support@gazpacho.net")
                .replyTo("support@gazpacho.net")
                .mailMessageTemplateLanguageSettingsStart()
                .subject("PersonalInvitation to participate in survey")
                .body("Dear Mr. $lastname, <br> You have been invited to take this survey. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"$link\">Click here</a> to take the survey")
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

    public SurveyDTO createDemoSurvey() {
        SurveyDTO survey = SurveyDTO
                .with()
                .language(Language.EN)
                .surveyLanguageSettingsStart()
                .title("Sample Survey")
                .description(
                        "<p>This is a <strong><em>sample survey</em></strong> designed for testing GazpachoSurvey.</p>")
                .welcomeText("Thank you for taking the time to participate in this survey.")
                .surveyLanguageSettingsEnd().build();
        survey = surveyEditorFacade.save(survey);

        TranslationDTO<SurveyDTO, SurveyLanguageSettingsDTO> surveyTranslation = new TranslationDTO<>();
        surveyTranslation.setLanguage(Language.ES);
        surveyTranslation.setLanguageSettings(SurveyLanguageSettingsDTO.with().title("Ejemplo de encuesta")
                .description("<p>Esto es una encuesta de ejemplo diseñada para GazpachoSurvey</p>")
                .welcomeText("Gracias por participar en esta encuesta").build());
        surveyTranslation.setTranslatedEntity(survey);

        surveyEditorFacade.saveSurveyTranslation(surveyTranslation);

        QuestionGroupDTO questionGroup1 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("QuestionGroup 1").pageLanguageSettingsEnd().build();

        survey.addQuestionGroup(questionGroup1);
        survey = surveyEditorFacade.save(survey);

        questionGroup1 = survey.getLastQuestionGroupDTO();

        QuestionGroupDTO questionGroup2 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("QuestionGroup 2").pageLanguageSettingsEnd().build();

        survey.addQuestionGroup(questionGroup2);
        survey = surveyEditorFacade.save(survey);
        questionGroup2 = survey.getLastQuestionGroupDTO();

        QuestionGroupDTO questionGroup3 = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("QuestionGroup 3").pageLanguageSettingsEnd().build();

        survey.addQuestionGroup(questionGroup3);
        survey = surveyEditorFacade.save(survey);
        questionGroup3 = survey.getLastQuestionGroupDTO();

        LabelSetDTO labelSet = LabelSetDTO.with().language(Language.EN).name("Feelings").build();
        labelSet = surveyEditorFacade.save(labelSet);

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

        surveyEditorFacade.save(labelSet);

        // 1 Single Textbox
        QuestionDTO question = QuestionDTO.with().type(QuestionType.S).language(Language.EN).languageSettingsStart()
                .title("What is your name?").languageSettingsEnd().isRequired(true).build();
        questionGroup1.addQuestion(question);
        questionGroup1 = surveyEditorFacade.save(questionGroup1);

        // 2 Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).languageSettingsStart()
                .title("What is your age group?").languageSettingsEnd().isRequired(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("0-14 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("15-19 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("20-24 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("25-29 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("30-34 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("35-39 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("40-44 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("45-49 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("50-54 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("55-59 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("60-64 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("65-69 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("70-74 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("75-79 years").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("80 and over").build());

        questionGroup1.addQuestion(question);
        questionGroup1 = surveyEditorFacade.save(questionGroup1);

        // 3 Numeric
        question = QuestionDTO.with().type(QuestionType.N).language(Language.EN).languageSettingsStart()
                .title("And for our records, specifically how old are you?").languageSettingsEnd().isRequired(true)
                .build();

        questionGroup1.addQuestion(question);
        questionGroup1 = surveyEditorFacade.save(questionGroup1);

        // 4 Comment/Essay Box
        question = QuestionDTO.with().type(QuestionType.T).language(Language.EN).languageSettingsStart()
                .title("Please tell us a little about yourself. What was your first job, and did you enjoy it?")
                .languageSettingsEnd().isRequired(true).build();

        questionGroup2.addQuestion(question);
        questionGroup2 = surveyEditorFacade.save(questionGroup2);

        // 5 Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).languageSettingsStart()
                .title("Given your extraordinary age, how do you find using this survey tool?").languageSettingsEnd()
                .isRequired(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN)
                .title("Very difficult to read, my eyesight is dim").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN)
                .title("Easy, my carer is doing it all for me").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN)
                .title("How <b><i>dare</i></b> you insult me like that! I'm YOUNG").build());

        questionGroup2.addQuestion(question);
        questionGroup2 = surveyEditorFacade.save(questionGroup2);

        // 6 Multiple Choice (Only One QuestionOption)
        question = QuestionDTO
                .with()
                .type(QuestionType.L)
                .language(Language.EN)
                .languageSettingsStart()
                .title("<font size='+2'><br />&nbsp;<br />Which of these ads makes you want to find out more?<br />&nbsp;<br /></font>")
                .languageSettingsEnd().isRequired(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Ad one").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Ad two").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Ad three").build());

        questionGroup2.addQuestion(question);
        questionGroup2 = surveyEditorFacade.save(questionGroup2);

        // 7 Rating Scale (Agree-Disagree)
        question = QuestionDTO
                .with()
                .type(QuestionType.F)
                .language(Language.EN)
                .languageSettingsStart()
                .title("Please have a good look at this ad, and then complete the questions below.<br /><img src='http://www.aptigence.com.au/images/lawyer1.jpg' border='1'>")
                .languageSettingsEnd().isRequired(true).build();

        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("This ad suggests the lawyer is on my side, not his own").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("This ad suggests that the lawyer is interested in a life of frugal community service")
                .languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("This ad would be enough to get me to hire this lawyer").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("This ad gives me confidence in the lawyers experience").languageSettingsEnd().build());

        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Agree strongly").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Agree somewhat").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Neither agree nor disagree")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Disagree somewhat").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Agree strongly").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Disagree strongly").build());

        questionGroup3.addQuestion(question);
        questionGroup3 = surveyEditorFacade.save(questionGroup3);

        // 8. Multiple_Choice_Multiple_Answers
        question = QuestionDTO.with().type(QuestionType.M).language(Language.EN).languageSettingsStart()
                .title("What flavors of ice cream do you like?. Choose all that apply.").languageSettingsEnd()
                .isRequired(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Vanilla").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Chocolate").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Strawberry").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Pistachio").build());

        questionGroup3.addQuestion(question);
        questionGroup3 = surveyEditorFacade.save(questionGroup3);

        return survey;
    }

    public SurveyDTO createFastFoodSurvey() {
        SurveyDTO survey = SurveyDTO
                .with()
                .language(Language.EN)
                .surveyLanguageSettingsStart()
                .title("Food Quality Survey")
                .description(
                        "We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.")
                .welcomeText(
                        "Your opinion is extremely important in evaluating our business. Thank you for taking a moment to questionOption the following questions:")
                .surveyLanguageSettingsEnd().build();
        survey = surveyEditorFacade.save(survey);

        QuestionGroupDTO questionGroup = QuestionGroupDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("Fast Food Survey - QuestionGroup").pageLanguageSettingsEnd().build();

        survey.addQuestionGroup(questionGroup);
        survey = surveyEditorFacade.save(survey);
        questionGroup = survey.getLastQuestionGroupDTO();

        // Rating Scale (1-5)
        QuestionDTO question = QuestionDTO.with().type(QuestionType.F).language(Language.EN).languageSettingsStart()
                .title("<b>Food Quality</b>").languageSettingsEnd().isRequired(true).build();

        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("The food is served hot and fresh").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("The menu has a good variety of items").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("The quality of food is excellent").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("The food is tasty and flavorful").languageSettingsEnd().build());

        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Agree strongly").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Agree somewhat").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Neither agree nor disagree")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Disagree somewhat").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Agree strongly").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Disagree strongly").build());

        questionGroup.addQuestion(question);
        questionGroup = surveyEditorFacade.save(questionGroup);

        // Rating Scale (Agree-Disagree)
        question = QuestionDTO.with().type(QuestionType.F).language(Language.EN).languageSettingsStart()
                .title("<b>Resturant</b>").languageSettingsEnd().isRequired(true).build();

        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("My food order was correct and complete").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("Employees are patient when taking my order").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("I was served promptly").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("Availability of sauces, utensils, napkins, etc. was good").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("The menu board was easy to read").languageSettingsEnd().build());
        question.addSubQuestion(QuestionDTO.with().language(Language.EN).type(QuestionType.L).languageSettingsStart()
                .title("The drive-thru sound system was cleara").languageSettingsEnd().build());

        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Agree strongly").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Agree somewhat").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Neither agree nor disagree")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Disagree somewhat").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Agree strongly").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Disagree strongly").build());

        questionGroup.addQuestion(question);
        questionGroup = surveyEditorFacade.save(questionGroup);

        // Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).languageSettingsStart()
                .title("Indicate total household income").languageSettingsEnd().isRequired(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("under 25,000€").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("25,000 - 29,999€").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("30,000 - 34,999€").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("35,000 - 39,999€").build());
        question.addQuestionOption(QuestionOptionDTO.with().language(Language.EN).title("Over 85,000€").build());

        questionGroup.addQuestion(question);
        questionGroup = surveyEditorFacade.save(questionGroup);

        return survey;
    }

    public void populate() {
        // System account
        userFacade.save(UserDTO.with().firstName("temporal.support").lastName("support")
                .email("support.temporal@gazpacho.net").build());

        Set<ParticipantDTO> participants = addParticipants();

        SurveyDTO survey = null;
        survey = createDemoSurvey();
        asignDefaultMailTemplate(survey);
        surveyEditorFacade.confirm(survey);

        SurveyInstanceDTO surveyInstance = SurveyInstanceDTO.with().survey(survey)
                .type(SurveyInstanceType.BY_INVITATION)
                .name("Survey " + survey.getLanguageSettings().getTitle() + " started").participants(participants)
                .build();
        surveyInstanceFacade.save(surveyInstance);

        survey = createFastFoodSurvey();
        asignDefaultMailTemplate(survey);
        surveyEditorFacade.confirm(survey);

        surveyInstance = SurveyInstanceDTO.with().survey(survey).type(SurveyInstanceType.BY_INVITATION)
                .name("Survey " + survey.getLanguageSettings().getTitle() + " started").participants(participants)
                .build();
        surveyInstanceFacade.save(surveyInstance);
    }

    protected Set<ParticipantDTO> addParticipants() {
        ParticipantDTO tyrion = ParticipantDTO.with().preferedLanguage(Language.EN).firstname("Tyrion")
                .lastname("Lannister").email("tyrion.lannister@kingslanding.net").gender(Gender.MALE).build();
        tyrion = participantFacade.save(tyrion);

        ParticipantDTO jon = ParticipantDTO.with().preferedLanguage(Language.ES).firstname("Jon").lastname("Snow")
                .email("jon.snow@nightswatch.net").gender(Gender.MALE).build();
        jon = participantFacade.save(jon);

        ParticipantDTO arya = ParticipantDTO.with().firstname("Arya").lastname("Stark")
                .email("arya.stark@winterfell.net").gender(Gender.FEMALE).build();
        arya = participantFacade.save(arya);

        ParticipantDTO catelyn = ParticipantDTO.with().preferedLanguage(Language.FI).firstname("Catelyn")
                .lastname("Stark").email("catelyn.stark@winterfell.net").gender(Gender.FEMALE).build();
        catelyn = participantFacade.save(catelyn);

        Set<ParticipantDTO> participants = new HashSet<>();
        participants.add(tyrion);
        participants.add(arya);
        participants.add(catelyn);
        participants.add(jon);
        return participants;
    }

}
