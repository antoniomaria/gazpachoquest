package net.sf.gazpachosurvey.services;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachosurvey.dto.AnswerDTO;
import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.dto.PageDTO;
import net.sf.gazpachosurvey.dto.QuestionDTO;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml", "classpath:/services-context.xml" })
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

    @Test
    public void addSurveyTest() {
        SurveyDTO survey = SurveyDTO
                .with()
                .language(Language.EN)
                .surveyLanguageSettingsStart()
                .title("Slightly Trickier Sample Survey")
                .description(
                        "<p>This is a <strong><em>sample survey</em></strong> designed for testing GazpachoSurvey.</p><p>One of the first things you'll need to do, in order to make this work properly, is to fix up the &quot;reference to previous answers&quot; codes in the first two questions of Group 2.  These questions contain (INSERTANS:1X2X3) code that needs the numbers changed to match questions 1 and 3 of Group 1. In order to find this number out, browse to question 1 of Group 1, and then copy the code from the URL bar in your web browser, starting from the number after &quot;SID=&quot;</p><p><strong><em>IE:</em></strong> 29975&amp;gid=2&amp;qid=4</p><p>Then, replace the &quot;&amp;gid=&quot; with an X, and replace the &quot;&amp;qid=&quot; with an X. So you should have:</p><p>29975X2X4</p><p>Then, you can replace the number in the curly brackets of question 1, group 2, so that it says:</p><p>(INSERTANS:29975X2X4)</p><p>Do the same with the other codes in the questions.</p><p>More information on using the answers to previous questions in your questions is available in the documentation.</p>")
                .welcomeText("Thank you for taking the time to participate in this survey.")
                .surveyLanguageSettingsEnd().build();

        Integer surveyId = surveyService.add(survey);
        assertThat(surveyId).isNotNull();

        PageDTO page = PageDTO.with().pageLanguageSettingsStart().title("Page 1").pageLanguageSettingsEnd().build();
        Integer page1Id = pageService.addPage(surveyId, page);
        assertThat(page1Id).isNotNull();

        page = PageDTO.with().pageLanguageSettingsStart().title("Page 2").pageLanguageSettingsEnd().build();
        Integer page2Id = pageService.addPage(surveyId, page);
        assertThat(page2Id).isNotNull();

        LabelSetDTO labelSet = LabelSetDTO.with().language(Language.EN).name("Feelings").build();

        Integer labelSetId = labelSetService.add(labelSet);

        LabelDTO label = LabelDTO.with().title("Agree strongly").build();
        labelSetService.addLabel(labelSetId, label);

        label = LabelDTO.with().title("Agree somewhat").build();
        labelSetService.addLabel(labelSetId, label);

        label = LabelDTO.with().title("Neither agree nor disagree").build();
        labelSetService.addLabel(labelSetId, label);

        label = LabelDTO.with().title("Disagree somewhat").build();
        labelSetService.addLabel(labelSetId, label);

        label = LabelDTO.with().title("Disagree strongly").build();
        labelSetService.addLabel(labelSetId, label);

        LabelSetDTO winner = labelSetService.findOne(1);

        QuestionDTO question = QuestionDTO.with().title("What is your name?").isRequired(true).build();
        Integer questionId = questionService.addQuestion(page1Id, question);
        questionService.addAnswer(questionId, AnswerDTO.with().title("0-18 years").build());
        questionService.addAnswer(questionId, AnswerDTO.with().title("19-26 years").build());
        questionService.addAnswer(questionId, AnswerDTO.with().title("27-40 years").build());
        questionService.addAnswer(questionId, AnswerDTO.with().title("40-65 years").build());
        questionService.addAnswer(questionId, AnswerDTO.with().title("65- years").build());

        System.out.println("fin" + winner.getName());

    }
}
