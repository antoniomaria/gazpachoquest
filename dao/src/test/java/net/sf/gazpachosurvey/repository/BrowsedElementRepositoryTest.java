package net.sf.gazpachosurvey.repository;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.BrowsedQuestion;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.DbUnitRule;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml" })
@DatabaseSetup("BrowsedElementRepository-dataset.xml")
public class BrowsedElementRepositoryTest {

    @Rule
    public DbUnitRule dbUnit = new DbUnitRule();

    @Autowired
    private DataSource datasource;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private BrowsedElementRepository repository;

    @Autowired
    private RespondentRepository respondentRepository;

    @Test
    public void findLastTest() {
        Integer respondentId = 113;
        BrowsedQuestion browsedQuestion = (BrowsedQuestion) repository.findLast(respondentId);
        assertThat(browsedQuestion).isEqualTo(BrowsedQuestion.with().id(115).build());
    }

    @Test
    public void findNextTest() {
        Integer respondentId = 113;
        BrowsedQuestion browsedQuestion = (BrowsedQuestion) repository.findLast(respondentId);
        BrowsedElement next = repository.findNext(respondentId, browsedQuestion.getCreatedDate());
        assertThat(next).isEqualTo(BrowsedQuestion.with().id(116).build());
    }

    @Test
    public void findPreviousTest() {
        Integer respondentId = 113;
        BrowsedQuestion browsedQuestion = (BrowsedQuestion) repository.findLast(respondentId);
        BrowsedElement previous = repository.findPrevious(respondentId, browsedQuestion.getCreatedDate());
        assertThat(previous).isEqualTo(BrowsedQuestion.with().id(114).build());
    }

}
