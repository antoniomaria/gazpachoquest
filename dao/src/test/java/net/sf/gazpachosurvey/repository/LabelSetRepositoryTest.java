package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachosurvey.domain.core.Label;
import net.sf.gazpachosurvey.domain.core.LabelSet;
import net.sf.gazpachosurvey.domain.core.embeddables.LabelLanguageSettings;
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
@DatabaseSetup("LabelSetRepository-dataset.xml")
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
