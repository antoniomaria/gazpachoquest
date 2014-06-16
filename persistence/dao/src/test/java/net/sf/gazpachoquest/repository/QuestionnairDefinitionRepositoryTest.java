package net.sf.gazpachoquest.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionGroupLanguageSettings;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnairDefinitionLanguageSettings;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnairDefinitionRepository-dataset.xml")
@DatabaseTearDown("QuestionnairDefinitionRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnairDefinitionRepositoryTest {

    @Autowired
    private QuestionnairDefinitionRepository repository;

    @Test
    public void findOne() {
        Integer questionnairDefinitionId = 7;
        QuestionnairDefinition questionnairDefinition = repository.findOne(questionnairDefinitionId);
        List<QuestionGroup> questionGroups = questionnairDefinition.getQuestionGroups();
        assertThat(questionGroups).hasSize(3);
    }

    @Test
    public void saveWithQuestionGroups() {
        QuestionnairDefinitionLanguageSettings settings = QuestionnairDefinitionLanguageSettings.with()
                .title("My QuestionnairDefinition example").description("My questionnairDefinition description")
                .build();
        QuestionnairDefinition questionnairDefinition = QuestionnairDefinition.with().language(Language.ES)
                .languageSettings(settings).build();
        QuestionGroup questionGroup = new QuestionGroup();
        questionGroup.setLanguage(Language.ES);
        QuestionGroupLanguageSettings groupSettings = new QuestionGroupLanguageSettings();
        groupSettings.setTitle("Group 1");
        questionGroup.setLanguageSettings(groupSettings);

        questionnairDefinition.addQuestionGroup(questionGroup);

        repository.save(questionnairDefinition);

        Question question = new Question();
        question.setLanguage(Language.ES);
        question.setCode("Q1");
        question.setType(QuestionType.S);
        QuestionLanguageSettings questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("Question 1");

        question.setLanguageSettings(questionLanguageSettings);

        questionGroup.addQuestion(question);

        question = new Question();
        question.setCode("Q2");
        question.setType(QuestionType.S);
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
        QuestionnairDefinitionLanguageSettings languageSettings = QuestionnairDefinitionLanguageSettings.with()
                .title("My QuestionnairDefinition").description("my description").build();
        QuestionnairDefinition questionnairDefinition = QuestionnairDefinition.with().language(Language.EN)
                .languageSettings(languageSettings).build();
        questionnairDefinition = repository.save(questionnairDefinition);
        assertThat(questionnairDefinition.getCreatedDate()).isNotNull();
        assertThat(questionnairDefinition.getCreatedBy()).isNotNull();

        languageSettings = QuestionnairDefinitionLanguageSettings.with().description("my description")
                .title("My QuestionnairDefinition. Version 1").build();
        questionnairDefinition.setLanguageSettings(languageSettings);
        questionnairDefinition = repository.save(questionnairDefinition);
        assertThat(questionnairDefinition.getLastModifiedBy()).isNotNull();
        assertThat(questionnairDefinition.getLastModifiedDate()).isNotNull();
    }

    @Test
    public void questionsCountGroupByQuestionGroupsTest() {
        Integer questionnairDefinitionId = 7;
        List<Object[]> result = repository.questionsCountGroupByQuestionGroups(questionnairDefinitionId);
        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isEqualTo(new Object[] { 11, 2L, 0 });
        assertThat(result.get(1)).isEqualTo(new Object[] { 10, 3L, 1 });
        assertThat(result.get(2)).isEqualTo(new Object[] { 9, 2L, 2 });
    }

    @Test
    public void questionsCountTest() {
        Integer questionnairDefinitionId = 7;
        Integer count = repository.questionsCount(questionnairDefinitionId);
        assertThat(count).isEqualTo(7);
    }

}
