package net.sf.gazpachoquest.repository;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.Label;
import net.sf.gazpachoquest.domain.core.LabelSet;
import net.sf.gazpachoquest.domain.core.embeddables.LabelLanguageSettings;
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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("LabelSetRepository-dataset.xml")
@DatabaseTearDown("LabelSetRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class LabelSetRepositoryTest {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private LabelSetRepository labelSetRepository;

    @Test
    public void saveTest() {
        LabelSet labelSet = new LabelSet();
        labelSet.setLanguage(Language.EN);
        labelSet.setName("Feelings");

        LabelLanguageSettings languageSettings = new LabelLanguageSettings();
        languageSettings.setTitle("Totally agree");
        Label label = Label.with().language(Language.EN).languageSettings(languageSettings).build();

        labelSet.addLabel(label);

        LabelSet saved = labelSetRepository.save(labelSet);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getLabels()).isNotEmpty();
        assertThat(saved.getLabels().get(0).getId()).isNotNull();
    }
}
