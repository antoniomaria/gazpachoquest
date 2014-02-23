package net.sf.gazpachoquest.repository;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.repository.BrowsedElementRepository;
import net.sf.gazpachoquest.repository.QuestionnairRepository;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.BrowsedQuestion;

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
@DatabaseSetup("BrowsedElementRepository-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
@Ignore
public class BrowsedElementRepositoryTest {

    @Autowired
    private BrowsedElementRepository repository;

    @Autowired
    private QuestionnairRepository questionnairRepository;

    @Test
    public void findLastTest() {
        Integer questionnairId = 63;
        BrowsedQuestion browsedQuestion = (BrowsedQuestion) repository.findLast(questionnairId);
        assertThat(browsedQuestion).isEqualTo(BrowsedQuestion.with().id(115).build());
    }

    @Test
    public void findNextTest() {
        Integer questionnairId = 113;
        BrowsedQuestion browsedQuestion = (BrowsedQuestion) repository.findLast(questionnairId);
        BrowsedElement next = repository.findNext(questionnairId, browsedQuestion.getCreatedDate());
        assertThat(next).isEqualTo(BrowsedQuestion.with().id(116).build());
    }

    @Test
    public void findPreviousTest() {
        Integer questionnairId = 113;
        BrowsedQuestion browsedQuestion = (BrowsedQuestion) repository.findLast(questionnairId);
        BrowsedElement previous = repository.findPrevious(questionnairId, browsedQuestion.getCreatedDate());
        assertThat(previous).isEqualTo(BrowsedQuestion.with().id(114).build());
    }

}
