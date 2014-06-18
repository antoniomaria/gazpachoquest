package net.sf.gazpachoquest.repository;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.repository.BreadcrumbRepository;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.junit.Ignore;
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
@DatabaseSetup("BreadcrumbRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
@Ignore
public class BreadcrumbRepositoryTest {

    @Autowired
    private BreadcrumbRepository repository;

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Test
    public void findLastTest() {
        Integer questionnairId = 63;
        QuestionBreadcrumb questionBreadcrumb = (QuestionBreadcrumb) repository.findLast(questionnairId);
        assertThat(questionBreadcrumb).isEqualTo(QuestionBreadcrumb.with().id(115).build());
    }

    @Test
    public void findNextTest() {
        Integer questionnairId = 113;
        QuestionBreadcrumb questionBreadcrumb = (QuestionBreadcrumb) repository.findLast(questionnairId);
        Breadcrumb next = repository.findNext(questionnairId, questionBreadcrumb.getCreatedDate());
        assertThat(next).isEqualTo(QuestionBreadcrumb.with().id(116).build());
    }

    @Test
    public void findPreviousTest() {
        Integer questionnairId = 113;
        QuestionBreadcrumb questionBreadcrumb = (QuestionBreadcrumb) repository.findLast(questionnairId);
        Breadcrumb previous = repository.findPrevious(questionnairId, questionBreadcrumb.getCreatedDate());
        assertThat(previous).isEqualTo(QuestionBreadcrumb.with().id(114).build());
    }

}
