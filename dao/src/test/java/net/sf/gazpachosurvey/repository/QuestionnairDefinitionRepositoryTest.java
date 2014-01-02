package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachosurvey.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairDefinitionRepository-dataset.xml")
public class QuestionnairDefinitionRepositoryTest {

    @Autowired
    private QuestionnairDefinitionRepository repository;

    @Test
    public void findOne() {
        int surveyId = 2;
        QuestionnairDefinition questionnairDefinition = repository.findOne(surveyId);
        List<QuestionGroup> questionGroups = questionnairDefinition.getQuestionGroups();
        for (QuestionGroup questionGroup : questionGroups) {
            List<Question> questions = questionGroup.getQuestions();
            System.out.println(" **** " + questionGroup.getLanguageSettings().getTitle());
            for (Question question : questions) {
                System.out.println(question.getId() + " " + question.getLanguageSettings().getTitle());
            }
        }
    }

    @Test
    public void saveSurveyWithQuestionGroups() {
        QuestionnairDefinitionLanguageSettings settings = QuestionnairDefinitionLanguageSettings.with().title("My QuestionnairDefinition example")
                .description("My questionnairDefinition description").build();
        QuestionnairDefinition questionnairDefinition = QuestionnairDefinition.with().language(Language.ES).languageSettings(settings).build();
        QuestionGroup questionGroup = new QuestionGroup();
        questionGroup.setLanguage(Language.ES);
        QuestionGroupLanguageSettings groupSettings = new QuestionGroupLanguageSettings();
        groupSettings.setTitle("Group 1");
        questionGroup.setLanguageSettings(groupSettings);

        questionnairDefinition.addQuestionGroup(questionGroup);

        repository.save(questionnairDefinition);

        Question question = new Question();
        question.setLanguage(Language.ES);
        QuestionLanguageSettings questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("Question 1");
        question.setLanguageSettings(questionLanguageSettings);

        questionGroup.addQuestion(question);

        question = new Question();
        question.setLanguage(Language.ES);
        questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("Question 2");
        question.setLanguageSettings(questionLanguageSettings);

        questionGroup.addQuestion(question);

        questionnairDefinition = repository.save(questionnairDefinition);

        QuestionnairDefinition fetched = repository.findOne(questionnairDefinition.getId());
        assertThat(fetched.getQuestionGroups()).hasSize(1);
        assertThat(fetched.getQuestionGroups().get(0).getQuestions()).hasSize(2);
    }

    @Test
    public void saveTest() {
        QuestionnairDefinitionLanguageSettings languageSettings = QuestionnairDefinitionLanguageSettings.with().title("My QuestionnairDefinition").build();
        QuestionnairDefinition questionnairDefinition = QuestionnairDefinition.with().language(Language.EN).languageSettings(languageSettings).build();
        questionnairDefinition = repository.save(questionnairDefinition);
        assertThat(questionnairDefinition.getCreatedDate()).isNotNull();
        assertThat(questionnairDefinition.getCreatedBy()).isNotNull();

        languageSettings = QuestionnairDefinitionLanguageSettings.with().title("My QuestionnairDefinition. Version 1").build();
        questionnairDefinition.setLanguageSettings(languageSettings);
        questionnairDefinition = repository.save(questionnairDefinition);
        assertThat(questionnairDefinition.getLastModifiedBy()).isNotNull();
        assertThat(questionnairDefinition.getLastModifiedDate()).isNotNull();
    }

}
