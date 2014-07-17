package net.sf.gazpachoquest.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.domain.core.QuestionGroupBreadcrumb;
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
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("BreadcrumbRepository-dataset.xml")
@DatabaseTearDown("BreadcrumbRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class BreadcrumbRepositoryTest {

    @Autowired
    private BreadcrumbRepository repository;

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Test
    public void findByQuestionnairIdAndPosition() {
        Integer questionnairId = 58;
        Integer position = 1;
        Breadcrumb next = repository.findByQuestionnairIdAndPosition(questionnairId, position);
        assertThat(next).isEqualTo(QuestionBreadcrumb.with().id(3).build());
    }

    @Test
    public void findLastAndPositionTest() {
        Integer questionnairId = 58;
        List<Object[]> next = repository.findLastAndPosition(questionnairId);
        assertThat(next).hasSize(1);
        assertThat(next.get(0)).isEqualTo(new Object[] { QuestionGroupBreadcrumb.with().id(3).build(), 1 });
    }
}
