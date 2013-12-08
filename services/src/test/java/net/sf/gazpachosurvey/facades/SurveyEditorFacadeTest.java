package net.sf.gazpachosurvey.facades;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.dto.LabelDTO;
import net.sf.gazpachosurvey.dto.LabelSetDTO;
import net.sf.gazpachosurvey.services.LabelSetService;
import net.sf.gazpachosurvey.types.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@DatabaseSetup("SurveyEditorFacade-dataset.xml")
public class SurveyEditorFacadeTest {

    @Autowired
    private SurveyEditorFacade surveyEditorFacade;

    @Autowired
    private LabelSetService labelSetService;

    @Test
    public void saveLabelSetTest() {

        LabelSetDTO labelSet = LabelSetDTO.with().language(Language.EN).name("Feelings").build();
        labelSet = surveyEditorFacade.save(labelSet);
        int labelSetId = labelSet.getId();
        assertThat(labelSetId).isNotNull();

        LabelDTO label = LabelDTO.with().language(Language.EN).title("Agree strongly").build();
        labelSet.addLabel(label);
        labelSet = surveyEditorFacade.save(labelSet);
        assertThat(labelSet.getLabels()).isNotEmpty();
        label = labelSet.getLabels().get(0);
        assertThat(label.getId()).isNotNull();

        label = LabelDTO.with().language(Language.EN).title("Agree somewhat").build();
        labelSet.addLabel(label);

        label = LabelDTO.with().language(Language.EN).title("Neither agree nor disagree").build();
        labelSet.addLabel(label);

        labelSet.swapLabel(0, labelSet.getLabels().size() - 1);
        labelSet = surveyEditorFacade.save(labelSet);
        List<LabelDTO> expected = labelSet.getLabels();
        
        //LabelSetDTO fetched = labelSetService.findOne(labelSetId);
        // List<LabelDTO> fetchedLabels = fetched.getLabels();
        //assertThat(fetchedLabels).containsExactly(expected.get(0), expected.get(1), expected.get(2));
    }
}
