package net.sf.gazpachosurvey.repository;

import net.sf.gazpachosurvey.domain.core.Study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-context.xml", "classpath:/datasource-context.xml" })
public class StudyRepositoryTest {

    @Autowired
    private StudyRepository repository;

    @Test
    public void findOne() {
        Integer questionnairDefinitionId = 6;
        Study study = repository.findOneByquestionnairDefinition(questionnairDefinitionId);
        System.out.println("fin: " + study);
    }
}
