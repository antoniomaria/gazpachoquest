package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.Section;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.Language;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("SectionService-dataset.xml")
@DatabaseTearDown("SectionService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class SectionServiceTest {

    @Autowired
    private SectionService sectionService;

    @Test
    public void questionsCountTest() {
        Integer sectionId = 9;
        long count = sectionService.questionsCount(sectionId);
        assertThat(count).isEqualTo(3);
    }

    @Test
    public void findOneTest() {
        Integer sectionId = 9;
        Language language = Language.ES;
        Section section = sectionService.findOne(sectionId, language);
        assertThat(section.getQuestionsId()).isEmpty();
        assertThat(section.getLanguageSettings().getTitle()).isEqualTo("Section 1 Spanish Version");
    }
}
