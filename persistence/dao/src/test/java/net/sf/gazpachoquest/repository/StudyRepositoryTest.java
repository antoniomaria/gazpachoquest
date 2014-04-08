package net.sf.gazpachoquest.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Study;
import net.sf.gazpachoquest.repository.StudyRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

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
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("StudyRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class StudyRepositoryTest {

    @Autowired
    private StudyRepository repository;

    @Test
    public void findOneByQuestionnairDefinitionTest() {
        Integer questionnairDefinitionId = 6;
        List<Study> studies = repository.findByQuestionnairDefinition(questionnairDefinitionId);
        assertThat(studies).containsExactly(Study.with().id(57).build());
    }
}
