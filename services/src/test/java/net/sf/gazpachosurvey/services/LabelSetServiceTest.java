package net.sf.gazpachosurvey.services;

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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("LabelSetService-dataset.xml")
public class LabelSetServiceTest {

    @Autowired
    private LabelSetService labelSetService;

    @Test
    public void saveTest() {
        LabelSet labelSet = new LabelSet();
        labelSet.setLanguage(Language.EN);
        labelSet.setName("Feelings");

        Label label = new Label();
        label.setLanguage(Language.EN);
        LabelLanguageSettings languageSettings = new LabelLanguageSettings();
        languageSettings.setTitle("Agree somehow");
        label.setLanguageSettings(languageSettings);

        labelSet.addLabel(label);

        LabelSet created = labelSetService.save(labelSet);

        LabelSet detached = new LabelSet();
        detached.setId(created.getId());

        label = new Label();
        label.setLanguage(Language.EN);
        languageSettings = new LabelLanguageSettings();
        languageSettings.setTitle("Totally agree");
        label.setLanguageSettings(languageSettings);

        detached.addLabel(label);
        labelSet = labelSetService.save(detached);

        assertThat(labelSet.getLabels()).hasSize(2);
    }
}
