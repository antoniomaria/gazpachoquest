package net.sf.gazpachoquest.repository;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.SectionLanguageSettings;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionLanguageSettings;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnaireDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import org.apache.shiro.subject.Subject;
import org.junit.After;
import org.junit.Before;
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
@DatabaseSetup("QuestionnaireDefinitionRepository-dataset.xml")
@DatabaseTearDown("QuestionnaireDefinitionRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnaireDefinitionRepositoryTest extends AbstractShiroTest {

    @Autowired
    private QuestionnaireDefinitionRepository repository;

    @Test
    public void findOne() {
        Integer questionnairDefinitionId = 7;
        QuestionnaireDefinition questionnaireDefinition = repository.findOne(questionnairDefinitionId);
        List<Section> sections = questionnaireDefinition.getSections();
        assertThat(sections).hasSize(3);
    }

    @Test
    public void saveWithSections() {
        QuestionnaireDefinitionLanguageSettings settings = QuestionnaireDefinitionLanguageSettings.with()
                .title("My QuestionnaireDefinition example").description("My questionnaireDefinition description")
                .welcomeText("welcome").build();
        QuestionnaireDefinition questionnaireDefinition = QuestionnaireDefinition.with().language(Language.ES)
                .languageSettings(settings).sectionInfoVisible(true).progressVisible(true).welcomeVisible(true)
                .randomizationStrategy(RandomizationStrategy.NONE).renderingMode(RenderingMode.SECTION_BY_SECTION).questionNumberVisible(false).build();
        Section section = new Section();
        section.setLanguage(Language.ES);
        section.setRandomizationEnabled(false);
        SectionLanguageSettings groupSettings = new SectionLanguageSettings();
        groupSettings.setTitle("Group 1");
        section.setLanguageSettings(groupSettings);

        questionnaireDefinition.addSection(section);

        repository.save(questionnaireDefinition);

        Question question = new Question();
        question.setLanguage(Language.ES);
        question.setCode("Q1");
        question.setType(QuestionType.S);
        QuestionLanguageSettings questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("Question 1");

        question.setLanguageSettings(questionLanguageSettings);
        question.setOtherAllowed(false);
        question.setRequired(false);
        section.addQuestion(question);

        question = new Question();
        question.setCode("Q2");
        question.setType(QuestionType.S);
        question.setLanguage(Language.ES);
        questionLanguageSettings = new QuestionLanguageSettings();
        questionLanguageSettings.setTitle("Question 2");
        question.setLanguageSettings(questionLanguageSettings);
        question.setOtherAllowed(false);
        question.setRequired(false);
        section.addQuestion(question);

        questionnaireDefinition = repository.save(questionnaireDefinition);

        QuestionnaireDefinition fetched = repository.findOne(questionnaireDefinition.getId());
        assertThat(fetched.getSections()).hasSize(1);
        assertThat(fetched.getSections().get(0).getQuestions()).hasSize(2);
    }

    @Test
    public void saveTest() {
        QuestionnaireDefinitionLanguageSettings languageSettings = QuestionnaireDefinitionLanguageSettings.with()
                .title("My QuestionnaireDefinition").description("my description").welcomeText("welcome").build();
        QuestionnaireDefinition questionnaireDefinition = QuestionnaireDefinition.with().language(Language.EN)
                .languageSettings(languageSettings).sectionInfoVisible(true).progressVisible(true)
                .welcomeVisible(true).randomizationStrategy(RandomizationStrategy.NONE).questionNumberVisible(false)
                .renderingMode(RenderingMode.SECTION_BY_SECTION).build();
        questionnaireDefinition = repository.save(questionnaireDefinition);
        assertThat(questionnaireDefinition.getCreatedDate()).isNotNull();
        assertThat(questionnaireDefinition.getCreatedBy()).isNotNull();

        languageSettings = QuestionnaireDefinitionLanguageSettings.with().description("my description")
                .title("My QuestionnaireDefinition. Version 1").welcomeText("welcome").build();
        questionnaireDefinition.setLanguageSettings(languageSettings);
        questionnaireDefinition = repository.save(questionnaireDefinition);
        assertThat(questionnaireDefinition.getLastModifiedBy()).isNotNull();
        assertThat(questionnaireDefinition.getLastModifiedDate()).isNotNull();
    }

    @Test
    public void questionsCountGroupBySectionsTest() {
        Integer questionnairDefinitionId = 7;
        List<Object[]> result = repository.questionsCountGroupBySections(questionnairDefinitionId);
        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isEqualTo(new Object[] { 11, 2L, 0 });
        assertThat(result.get(1)).isEqualTo(new Object[] { 10, 3L, 1 });
        assertThat(result.get(2)).isEqualTo(new Object[] { 9, 3L, 2 });
    }

    @Test
    public void questionsCountTest() {
        Integer questionnairDefinitionId = 7;
        Integer count = repository.questionsCount(questionnairDefinitionId);
        assertThat(count).isEqualTo(8);
    }

    @Before
    public void setUpSubject() {
        Subject subjectUnderTest = createNiceMock(Subject.class);
        User support = User.with().id(1).build();
        expect(subjectUnderTest.getPrincipal()).andReturn(support).anyTimes();
        replay(subjectUnderTest);
        // 2. Bind the subject to the current thread:
        setSubject(subjectUnderTest);
    }

    @After
    public void tearDownSubject() {
        // 3. Unbind the subject from the current thread:
        clearSubject();
    }

}
