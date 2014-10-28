package net.sf.gazpachoquest.services;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.domain.core.embeddables.QuestionnaireDefinitionLanguageSettings;
import net.sf.gazpachoquest.domain.i18.QuestionnaireDefinitionTranslation;
import net.sf.gazpachoquest.domain.user.User;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.test.shiro.support.AbstractShiroTest;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;
import net.sf.gazpachoquest.types.Topology;

import org.apache.shiro.subject.Subject;
import org.joda.time.LocalDateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("QuestionnaireDefinitionService-dataset.xml")
@DatabaseTearDown("QuestionnaireDefinitionService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class QuestionnaireDefinitionServiceTest extends AbstractShiroTest {

    @Autowired
    @Qualifier("questionnaireDefinitionServiceImpl")
    private QuestionnaireDefinitionService questionnaireDefinitionService;

    @Test
    public void confirmTest() {
        QuestionnaireDefinition questionnaireDefinition = QuestionnaireDefinition.with().id(7).build();
        questionnaireDefinitionService.confirm(questionnaireDefinition);
    }

    @Test
    public void findAllTest() {
        assertThat(questionnaireDefinitionService.findAll()).hasSize(1);
    }

    @Test
    public void findOneTest() {
        int questionnaireDefinitionId = 7;
        QuestionnaireDefinition questionnaireDefinition = questionnaireDefinitionService
                .findOne(questionnaireDefinitionId);
        assertThat(questionnaireDefinition).isNotNull();
    }

    @Test
    public void sectionsCountTest() {
        int questionnaireDefinitionId = 7;
        long count = questionnaireDefinitionService.sectionsCount(questionnaireDefinitionId);
        assertThat(count).isEqualTo(3);
    }

    @Test
    public void getTopologyTest() {
        int questionnaireDefinitionId = 7;
        Topology topology = questionnaireDefinitionService.getTopology(questionnaireDefinitionId);
        assertThat(topology).isEqualTo(Topology.SKIP_PATTERN);
    }
    
    @Test
    public void saveTest() {
        QuestionnaireDefinitionLanguageSettings languageSettings = QuestionnaireDefinitionLanguageSettings.with()
                .title("My QuestionnaireDefinition").description("My description").welcomeText("welcome").endText("").build();

        QuestionnaireDefinition questionnaireDefinition = QuestionnaireDefinition.with().status(EntityStatus.DRAFT).language(Language.EN)
                .languageSettings(languageSettings).sectionInfoVisible(true).progressVisible(true).welcomeVisible(true)
                .randomizationStrategy(RandomizationStrategy.NONE).renderingMode(RenderingMode.SECTION_BY_SECTION)
                .questionNumberVisible(false).build();

        questionnaireDefinition = questionnaireDefinitionService.save(questionnaireDefinition);
        LocalDateTime lastModifiedDate = questionnaireDefinition.getLastModifiedDate();

        QuestionnaireDefinition created = questionnaireDefinitionService.findOne(questionnaireDefinition.getId());
        QuestionnaireDefinitionLanguageSettings newLanguageSettings = QuestionnaireDefinitionLanguageSettings.with()
                .title("My QuestionnaireDefinition. Ver 1").description("My description").welcomeText("my welcome")
                .endText("").build();
        created.setLanguageSettings(newLanguageSettings);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        QuestionnaireDefinition updated = questionnaireDefinitionService.save(created);
        assertThat(lastModifiedDate).isNotEqualTo(updated.getLastModifiedDate());
    }

    @Test
    public void saveTranslationTest() {
        QuestionnaireDefinitionLanguageSettings languageSettings = new QuestionnaireDefinitionLanguageSettings();
        languageSettings.setTitle("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        languageSettings.setDescription("Donec pellentesque consequat orci.");
        languageSettings.setWelcomeText("dolorem");
        languageSettings.setEndText("");

        int questionnairDefinitionId = 7;
        QuestionnaireDefinitionTranslation translation = QuestionnaireDefinitionTranslation.with()
                .translatedEntityId(questionnairDefinitionId).language(Language.FR).languageSettings(languageSettings)
                .build();
        questionnaireDefinitionService.saveTranslation(translation);
        Set<Language> translations = questionnaireDefinitionService.translationsSupported(questionnairDefinitionId);

        assertThat(translations).contains(Language.FR);
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
