package net.sf.gazpachosurvey.services;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.gazpachosurvey.dto.AnswerDTO;
import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.ParticipantDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.dto.SurveyRunningDTO;
import net.sf.gazpachosurvey.dto.UserDTO;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;
import net.sf.gazpachosurvey.types.SurveyRunningType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml",
        "classpath:/services-context.xml" })
/*
 * @TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
 * DirtiesContextTestExecutionListener.class,
 * TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class
 * })
 * 
 * @DatabaseSetup("SurveyRepositoryTest-dataset.xml")
 */public class SurveyServiceTest {

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

    @Test
    public void saveSurveyTest() {
        userService.save(UserDTO.with().firstName("temporal.support")
                .lastName("support").email("support.temporal@gazpacho.net")
                .build());

        SurveyDTO survey = SurveyDTO
                .with()
                .language(Language.EN)
                .surveyLanguageSettingsStart()
                .title("Sample Survey")
                .description(
                        "<p>This is a <strong><em>sample survey</em></strong> designed for testing GazpachoSurvey.</p>")
                .welcomeText(
                        "Thank you for taking the time to participate in this survey.")
                .surveyLanguageSettingsEnd().
                build();
        survey = surveyService.save(survey);
        assertThat(survey.getId()).isNotNull();

        PageDTO page = PageDTO.with().pageLanguageSettingsStart()
                .title("Page 1").pageLanguageSettingsEnd().build();
        PageDTO page1 = pageService.addPage(survey.getId(), page);
        assertThat(page1.getId()).isNotNull();

        page = PageDTO.with().pageLanguageSettingsStart().title("Page 2")
                .pageLanguageSettingsEnd().build();
        PageDTO page2 = pageService.addPage(survey.getId(), page);
        assertThat(page2.getId()).isNotNull();

        page = PageDTO.with().pageLanguageSettingsStart().title("Page 3")
                .pageLanguageSettingsEnd().build();
        PageDTO page3 = pageService.addPage(survey.getId(), page);
        assertThat(page3.getId()).isNotNull();

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
                .language(Language.EN).languageSettingsStart().
                title("What is your name?").languageSettingsEnd()
                .isRequired(true).build();
        Integer questionId = questionService.addQuestion(page1.getId(),
                question);

        // 2 Multiple Choice (Only One Answer)
        question = QuestionDTO.with().type(QuestionType.L)
                .language(Language.EN).
                languageSettingsStart().
                title("What is your age group?").languageSettingsEnd()
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
                .title("And for our records, specifically how old are you?").languageSettingsEnd()
                .isRequired(true).build();
        questionId = questionService.addQuestion(page1.getId(), question);

        // 4 Comment/Essay Box
        question = QuestionDTO
                .with()
                .type(QuestionType.T)
                .language(Language.EN).languageSettingsStart()
                .title("Please tell us a little about yourself. What was your first job, and did you enjoy it?").languageSettingsEnd()
                .isRequired(true).build();
        questionId = questionService.addQuestion(page2.getId(), question);

        // 5 Multiple Choice (Only One Answer)
        question = QuestionDTO
                .with()
                .type(QuestionType.L)
                .language(Language.EN).languageSettingsStart()
                .title("Given your extraordinary age, how do you find using this survey tool?").languageSettingsEnd()
                .isRequired(true).build();
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
                .language(Language.EN).languageSettingsStart()
                .title("<font size='+2'><br />&nbsp;<br />Which of these ads makes you want to find out more?<br />&nbsp;<br /></font>").languageSettingsEnd()
                .isRequired(true).build();
        question.addAnswer(AnswerDTO.with().title("Ad one").build());
        question.addAnswer(AnswerDTO.with().title("Ad two").build());
        question.addAnswer(AnswerDTO.with().title("Ad three").build());

        questionId = questionService.addQuestion(page3.getId(), question);

        // 7 Rating Scale (Agree-Disagree)
        question = QuestionDTO
                .with()
                .type(QuestionType.F)
                .language(Language.EN).languageSettingsStart()
                .title("Please have a good look at this ad, and then complete the questions below.<br /><img src='http://www.aptigence.com.au/images/lawyer1.jpg' border='1'>")
                .languageSettingsEnd().isRequired(true).build();

        List<QuestionDTO> subquestions = new ArrayList<>();
        subquestions
                .add(QuestionDTO
                        .with()
                        .language(Language.EN)
                        .type(QuestionType.L).languageSettingsStart()
                        .title("This ad suggests the lawyer is on my side, not his own").languageSettingsEnd()
                        .build());
        subquestions
                .add(QuestionDTO
                        .with()
                        .language(Language.EN)
                        .type(QuestionType.L).languageSettingsStart()
                        .title("This ad suggests that the lawyer is interested in a life of frugal community service").languageSettingsEnd()
                        .build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("This ad would be enough to get me to hire this lawyer").languageSettingsEnd()
                .build());
        subquestions.add(QuestionDTO.with().language(Language.EN)
                .type(QuestionType.L).languageSettingsStart()
                .title("This ad gives me confidence in the lawyers experience").languageSettingsEnd()
                .build());
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
                .language(Language.EN).languageSettingsStart()
                .title("What flavors of ice cream do you like?. Choose all that apply.").languageSettingsEnd()
                .isRequired(true).page(page3).survey(survey).build();
        question.addAnswer(AnswerDTO.with().language(Language.EN)
                .title("Vanilla").build());
        question.addAnswer(AnswerDTO.with().language(Language.EN)
                .title("Chocolate").build());
        question.addAnswer(AnswerDTO.with().language(Language.EN)
                .title("Strawberry").build());
        question.addAnswer(AnswerDTO.with().language(Language.EN)
                .title("Pistachio").build());
        question = questionService.save(question);

        ParticipantDTO tyrion = ParticipantDTO.with().firstname("Tyrion")
                .lastname("Lannister")
                .email("tyrion.lannister@kingslanding.net").build();
        tyrion = participantService.save(tyrion);

        ParticipantDTO jon = ParticipantDTO.with().firstname("Jon")
                .lastname("Snow").email("jon.snow@nightswatch.net").build();

        ParticipantDTO arya = ParticipantDTO.with().firstname("Arya")
                .lastname("Stark").email("arya.stark@winterfell.net").build();

        ParticipantDTO catelyn = ParticipantDTO.with().firstname("Catelyn")
                .lastname("Stark").email("catelyn.stark@winterfell.net")
                .build();

        Set<ParticipantDTO> participants = new HashSet<>();
        participants.add(tyrion);
        participants.add(arya);
        participants.add(catelyn);
        participants.add(jon);
        SurveyRunningDTO surveyRunning = SurveyRunningDTO.with()
                .type(SurveyRunningType.BY_INVITATION).name("my first running")
                .participants(participants).build();

        surveyRunningService.save(surveyRunning);

    }

    @Test
    public void confirmTest() {
        SurveyDTO survey = SurveyDTO.with().id(1).build();
        surveyService.confirm(survey);

    }

    @Test
    public void findOneTest() {
        SurveyDTO survey = surveyService.findOne(1);

        System.out.println("Questions " + survey.getQuestions());

        survey = surveyService.findOne(1, "SurveyWithQuestions");

        System.out.println("Questions " + survey.getQuestions());
    }
    @Test
    public void saveTranslationTest(){
        SurveyDTO survey = surveyService.findOne(3);
        SurveyLanguageSettingsDTO languageSettings = new SurveyLanguageSettingsDTO();
        languageSettings.setTitle("mi titulo! !!! !!! !");
        languageSettings.setDescription("mi descripcion modified");
        surveyService.saveTranslation(3, Language.FR, languageSettings);
    }

}
