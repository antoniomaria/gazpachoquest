package net.sf.gazpachosurvey.dbpopulator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.gazpachosurvey.dto.AnswerDTO;
import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateDTO;
import net.sf.gazpachosurvey.dto.MailMessageTemplateLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.dto.SurveyRunningDTO;
import net.sf.gazpachosurvey.dto.UserAccountDTO;
import net.sf.gazpachosurvey.services.LabelSetService;
import net.sf.gazpachosurvey.services.MailMessageTemplateService;
import net.sf.gazpachosurvey.services.PageService;
import net.sf.gazpachosurvey.services.ParticipantService;
import net.sf.gazpachosurvey.services.QuestionService;
import net.sf.gazpachosurvey.services.SurveyRunningService;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.services.UserService;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.MailMessageTemplateType;
import net.sf.gazpachosurvey.types.QuestionType;
import net.sf.gazpachosurvey.types.SurveyRunningType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBPopulator {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private PageService pageService;

    @Autowired
    private LabelSetService labelSetService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private SurveyRunningService surveyRunningService;

    @Autowired
    private UserService userService;

    @Autowired
    private MailMessageTemplateService mailMessageTemplateService;

    public void populate() {
        userService.save(UserAccountDTO.with().firstName("temporal.support")
                .lastName("support").email("support.temporal@gazpacho.net")
                .build());
        SurveyDTO survey = createDemoSurvey();
        asignDefaultMailTemplate(survey);

        survey = createFastFoodSurvey();
        asignDefaultMailTemplate(survey);

        Set<ParticipantDTO> participants = addParticipants();

        SurveyRunningDTO surveyRunning = SurveyRunningDTO
                .with()
                .survey(survey)
                .type(SurveyRunningType.BY_INVITATION)
                .name("Survey " + survey.getLanguageSettings().getTitle()
                        + " started").participants(participants).build();

        surveyRunningService.save(surveyRunning);
    }

    public SurveyDTO createFastFoodSurvey() {
        SurveyDTO survey = SurveyDTO
                .with()
                .language(Language.EN)
                .surveyLanguageSettingsStart()
                .title("Food Quality Modified")
                .description(
                        "We at BIG DEES take pride in providing you with the highest standards of QUALITY, SERVICE, CLEANLINESS and VALUE in the restaurant industry.")
                .welcomeText(
                        "Your opinion is extremely important in evaluating our business. Thank you for taking a moment to answer the following questions:")
                .surveyLanguageSettingsEnd().build();
        survey = surveyService.save(survey);

        PageDTO page = PageDTO.with().language(Language.EN)
                .pageLanguageSettingsStart().title("Fast Food Survey ")
                .pageLanguageSettingsEnd().build();
        page = pageService.save(page);

        // Rating Scale (1-5)
        QuestionDTO question = QuestionDTO.with().type(QuestionType.F)
                .language(Language.EN).languageSettingsStart()
                .title("<b>Food Quality Modified</b>").languageSettingsEnd()
                .isRequired(true).build();

        List<QuestionDTO> subquestions = new ArrayList<>();
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("The food is served hot and fresh")
                .languageSettingsEnd().build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("The menu has a good variety of items")
                .languageSettingsEnd().build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("The quality of food is excellent")
                .languageSettingsEnd().build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("The food is tasty and flavorful").languageSettingsEnd()
                .build());
        question.setSubquestions(subquestions);

        question.setPage(page);
        question.setSurvey(survey);

        question.addAnswer(AnswerDTO.with().title("Agree strongly").build());
        question.addAnswer(AnswerDTO.with().title("Agree somewhat").build());
        question.addAnswer(AnswerDTO.with().title("Neither agree nor disagree")
                .build());
        question.addAnswer(AnswerDTO.with().title("Disagree somewhat").build());
        question.addAnswer(AnswerDTO.with().title("Agree strongly").build());
        question.addAnswer(AnswerDTO.with().title("Disagree strongly").build());

        question = questionService.save(question);

        // Rating Scale (Agree-Disagree)
        question = QuestionDTO.with().type(QuestionType.F)
                .language(Language.EN).languageSettingsStart()
                .title("<b>Resturant</b>").languageSettingsEnd()
                .isRequired(true).build();

        subquestions = new ArrayList<>();
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("My food order was correct and complete")
                .languageSettingsEnd().build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("Employees are patient when taking my order")
                .languageSettingsEnd().build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("I was served promptly").languageSettingsEnd().build());
        subquestions
                .add(QuestionDTO
                        .with()
                        .language(Language.EN)
                        .type(QuestionType.L)
                        .languageSettingsStart()
                        .title("Availability of sauces, utensils, napkins, etc. was good")
                        .languageSettingsEnd().build());

        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("The menu board was easy to read").languageSettingsEnd()
                .build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("The drive-thru sound system was cleara")
                .languageSettingsEnd().build());

        question.setSubquestions(subquestions);

        question.setPage(page);
        question.setSurvey(survey);

        question.addAnswer(AnswerDTO.with().title("Agree strongly").build());
        question.addAnswer(AnswerDTO.with().title("Agree somewhat").build());
        question.addAnswer(AnswerDTO.with().title("Neither agree nor disagree")
                .build());
        question.addAnswer(AnswerDTO.with().title("Disagree somewhat").build());
        question.addAnswer(AnswerDTO.with().title("Agree strongly").build());
        question.addAnswer(AnswerDTO.with().title("Disagree strongly").build());

        question = questionService.save(question);

        // Multiple Choice (Only One Answer)
        question = QuestionDTO.with().type(QuestionType.L)
                .language(Language.EN).languageSettingsStart()
                .title("Indicate total household income").languageSettingsEnd()
                .isRequired(true).build();
        question.setPage(page);
        question.setSurvey(survey);

        question.addAnswer(AnswerDTO.with().title("under 25,000€").build());
        question.addAnswer(AnswerDTO.with().title("25,000 - 29,999€").build());
        question.addAnswer(AnswerDTO.with().title("30,000 - 34,999€").build());
        question.addAnswer(AnswerDTO.with().title("35,000 - 39,999€").build());
        question.addAnswer(AnswerDTO.with().title("Over 85,000€").build());

        question = questionService.save(question);

        return survey;
    }

    public SurveyDTO createDemoSurvey() {
        SurveyDTO survey = SurveyDTO
                .with()
                .language(Language.EN)
                .surveyLanguageSettingsStart()
                .title("Sample Survey")
                .description(
                        "<p>This is a <strong><em>sample survey</em></strong> designed for testing GazpachoSurvey.</p>")
                .welcomeText(
                        "Thank you for taking the time to participate in this survey.")
                .surveyLanguageSettingsEnd().build();
        survey = surveyService.save(survey);

        PageDTO page = PageDTO.with().pageLanguageSettingsStart()
                .title("Page 1").pageLanguageSettingsEnd().build();
        PageDTO page1 = pageService.addPage(survey.getId(), page);

        page = PageDTO.with().pageLanguageSettingsStart().title("Page 2")
                .pageLanguageSettingsEnd().build();
        PageDTO page2 = pageService.addPage(survey.getId(), page);

        page = PageDTO.with().pageLanguageSettingsStart().title("Page 3")
                .pageLanguageSettingsEnd().build();
        PageDTO page3 = pageService.addPage(survey.getId(), page);

        LabelSetDTO labelSet = LabelSetDTO.with().language(Language.EN)
                .name("Feelings").build();
        labelSet = labelSetService.save(labelSet);

        LabelDTO label = LabelDTO.with().title("Agree strongly").build();
        labelSetService.addLabel(labelSet.getId(), label);

        label = LabelDTO.with().title("Agree somewhat").build();
        labelSetService.addLabel(labelSet.getId(), label);

        label = LabelDTO.with().title("Neither agree nor disagree").build();
        labelSetService.addLabel(labelSet.getId(), label);

        label = LabelDTO.with().title("Disagree somewhat").build();
        labelSetService.addLabel(labelSet.getId(), label);

        label = LabelDTO.with().title("Disagree strongly").build();
        labelSetService.addLabel(labelSet.getId(), label);

        // 1 Single Textbox
        QuestionDTO question = QuestionDTO.with().type(QuestionType.S)
                .language(Language.EN).languageSettingsStart()
                .title("What is your name?").languageSettingsEnd()
                .isRequired(true).build();
        Integer questionId = questionService.addQuestion(page1.getId(),
                question);

        // 2 Multiple Choice (Only One Answer)
        question = QuestionDTO.with().type(QuestionType.L)
                .language(Language.EN).languageSettingsStart()
                .title("What is your age group?").languageSettingsEnd()
                .isRequired(true).build();

        question.addAnswer(AnswerDTO.with().title("0-14 years").build());
        question.addAnswer(AnswerDTO.with().title("15-19 years").build());
        question.addAnswer(AnswerDTO.with().title("20-24 years").build());
        question.addAnswer(AnswerDTO.with().title("25-29 years").build());
        question.addAnswer(AnswerDTO.with().title("30-34 years").build());
        question.addAnswer(AnswerDTO.with().title("35-39 years").build());
        question.addAnswer(AnswerDTO.with().title("40-44 years").build());
        question.addAnswer(AnswerDTO.with().title("45-49 years").build());
        question.addAnswer(AnswerDTO.with().title("50-54 years").build());
        question.addAnswer(AnswerDTO.with().title("55-59 years").build());
        question.addAnswer(AnswerDTO.with().title("60-64 years").build());
        question.addAnswer(AnswerDTO.with().title("65-69 years").build());
        question.addAnswer(AnswerDTO.with().title("70-74 years").build());
        question.addAnswer(AnswerDTO.with().title("75-79 years").build());
        question.addAnswer(AnswerDTO.with().title("80 and over").build());
        questionId = questionService.addQuestion(page1.getId(), question);

        // 3 Numeric
        question = QuestionDTO.with().type(QuestionType.N)
                .language(Language.EN).languageSettingsStart()
                .title("And for our records, specifically how old are you?")
                .languageSettingsEnd().isRequired(true).build();
        questionId = questionService.addQuestion(page1.getId(), question);

        // 4 Comment/Essay Box
        question = QuestionDTO
                .with()
                .type(QuestionType.T)
                .language(Language.EN)
                .languageSettingsStart()
                .title("Please tell us a little about yourself. What was your first job, and did you enjoy it?")
                .languageSettingsEnd().isRequired(true).build();
        questionId = questionService.addQuestion(page2.getId(), question);

        // 5 Multiple Choice (Only One Answer)
        question = QuestionDTO
                .with()
                .type(QuestionType.L)
                .language(Language.EN)
                .languageSettingsStart()
                .title("Given your extraordinary age, how do you find using this survey tool?")
                .languageSettingsEnd().isRequired(true).build();
        question.addAnswer(AnswerDTO.with()
                .title("Very difficult to read, my eyesight is dim").build());
        question.addAnswer(AnswerDTO.with()
                .title("Easy, my carer is doing it all for me").build());
        question.addAnswer(AnswerDTO
                .with()
                .title("How <b><i>dare</i></b> you insult me like that! I'm YOUNG")
                .build());

        questionId = questionService.addQuestion(page2.getId(), question);

        // 6 Multiple Choice (Only One Answer)
        question = QuestionDTO
                .with()
                .type(QuestionType.L)
                .language(Language.EN)
                .languageSettingsStart()
                .title("<font size='+2'><br />&nbsp;<br />Which of these ads makes you want to find out more?<br />&nbsp;<br /></font>")
                .languageSettingsEnd().isRequired(true).build();
        question.addAnswer(AnswerDTO.with().title("Ad one").build());
        question.addAnswer(AnswerDTO.with().title("Ad two").build());
        question.addAnswer(AnswerDTO.with().title("Ad three").build());

        questionId = questionService.addQuestion(page3.getId(), question);

        // 7 Rating Scale (Agree-Disagree)
        question = QuestionDTO
                .with()
                .type(QuestionType.F)
                .language(Language.EN)
                .languageSettingsStart()
                .title("Please have a good look at this ad, and then complete the questions below.<br /><img src='http://www.aptigence.com.au/images/lawyer1.jpg' border='1'>")
                .languageSettingsEnd().isRequired(true).build();

        List<QuestionDTO> subquestions = new ArrayList<>();
        subquestions
                .add(QuestionDTO
                        .with()
                        .language(Language.EN)
                        .type(QuestionType.L)
                        .languageSettingsStart()
                        .title("This ad suggests the lawyer is on my side, not his own")
                        .languageSettingsEnd().build());
        subquestions
                .add(QuestionDTO
                        .with()
                        .language(Language.EN)
                        .type(QuestionType.L)
                        .languageSettingsStart()
                        .title("This ad suggests that the lawyer is interested in a life of frugal community service")
                        .languageSettingsEnd().build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("This ad would be enough to get me to hire this lawyer")
                .languageSettingsEnd().build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("This ad gives me confidence in the lawyers experience")
                .languageSettingsEnd().build());
        question.setSubquestions(subquestions);

        question.setPage(page3);
        question.setSurvey(survey);

        question.addAnswer(AnswerDTO.with().title("Agree strongly").build());
        question.addAnswer(AnswerDTO.with().title("Agree somewhat").build());
        question.addAnswer(AnswerDTO.with().title("Neither agree nor disagree")
                .build());
        question.addAnswer(AnswerDTO.with().title("Disagree somewhat").build());
        question.addAnswer(AnswerDTO.with().title("Agree strongly").build());
        question.addAnswer(AnswerDTO.with().title("Disagree strongly").build());

        question = questionService.save(question);

        // 8. Multiple_Choice_Multiple_Answers
        question = QuestionDTO
                .with()
                .type(QuestionType.M)
                .language(Language.EN)
                .languageSettingsStart()
                .title("What flavors of ice cream do you like?. Choose all that apply.")
                .languageSettingsEnd().isRequired(true).page(page3)
                .survey(survey).build();
        question.addAnswer(AnswerDTO.with().language(Language.EN)
                .title("Vanilla").build());
        question.addAnswer(AnswerDTO.with().language(Language.EN)
                .title("Chocolate").build());
        question.addAnswer(AnswerDTO.with().language(Language.EN)
                .title("Strawberry").build());
        question.addAnswer(AnswerDTO.with().language(Language.EN)
                .title("Pistachio").build());
        question = questionService.save(question);

        return survey;
    }

    protected Set<ParticipantDTO> addParticipants() {
        ParticipantDTO tyrion = ParticipantDTO.with().preferedLanguage(Language.EN).firstname("Tyrion")
                .lastname("Lannister")
                .email("tyrion.lannister@kingslanding.net").build();
        tyrion = participantService.save(tyrion);

        ParticipantDTO jon = ParticipantDTO.with().preferedLanguage(Language.ES).firstname("Jon")
                .lastname("Snow").email("jon.snow@nightswatch.net").build();

        ParticipantDTO arya = ParticipantDTO.with().firstname("Arya")
                .lastname("Stark").email("arya.stark@winterfell.net").build();

        ParticipantDTO catelyn = ParticipantDTO.with().preferedLanguage(Language.FI).firstname("Catelyn")
                .lastname("Stark").email("catelyn.stark@winterfell.net")
                .build();

        Set<ParticipantDTO> participants = new HashSet<>();
        participants.add(tyrion);
        participants.add(arya);
        participants.add(catelyn);
        participants.add(jon);
        return participants;
    }

    public MailMessageTemplateDTO asignDefaultMailTemplate(SurveyDTO survey) {
        MailMessageTemplateDTO mailMessageTemplate = MailMessageTemplateDTO
                .with()
                .language(Language.EN)
                .survey(survey)
                .type(MailMessageTemplateType.INVITATION)
                .from("support@gazpacho.net")
                .replyTo("support@gazpacho.net")
                .mailMessageTemplateLanguageSettingsStart()
                .subject("Invitation to participate in survey")
                .body("Dear Mr. $lastname, <br> You have been invited to take this survey. <br>"
                        + "The questionnaire will take about 15 minutes to complete and if you get interrupted, you can return later and continue where you left off."
                        + "<a href=\"$link\">Click here</a> to take the survey")
                .mailMessageTemplateLanguageSettingsEnd().build();
        mailMessageTemplate = mailMessageTemplateService
                .save(mailMessageTemplate);

        MailMessageTemplateLanguageSettingsDTO languageSettings = MailMessageTemplateLanguageSettingsDTO
                .with()
                .subject("Invitación para participar en una encuesta")
                .body("Estimado Sr. $lastname, <br> Has sido invitado para participar en esta encuesta <br>"
                        + "Nos dedicas 15 minutos para realizar la encuesta?, puedes interrumpirla y completarla más tarde si es necesario"
                        + "<a href=\"$link\">Click aqui</a> para empezar").build();

        mailMessageTemplateService.saveTranslation(mailMessageTemplate.getId(),
                Language.ES, languageSettings);

        return mailMessageTemplate;
    }
}
