package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachosurvey.domain.core.Study;
import net.sf.gazpachosurvey.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-context.xml", "classpath:/datasource-context.xml" })
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class StudyRepositoryTest {

    @Autowired
    private StudyRepository repository;

    @Test
    public void findOneByQuestionnairDefinitionTest() {
        Integer questionnairDefinitionId = 6;
        List<Study> studies = repository.findOneByQuestionnairDefinition(questionnairDefinitionId);
        assertThat(studies).containsExactly(Study.with().id(57).build());
    }
}
