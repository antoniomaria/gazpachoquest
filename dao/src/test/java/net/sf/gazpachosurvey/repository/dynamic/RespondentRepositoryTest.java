package net.sf.gazpachosurvey.repository.dynamic;

import net.sf.gazpachosurvey.domain.core.Survey;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml",
        "classpath:/jpa-context.xml" })
public class RespondentRepositoryTest {

    @Autowired
    private RespondentRepository repository;
    
    @Test
    public void createRespondentTest(){
        Survey survey = Survey.with().id(1).build();
       // repository.createRespondentTable(survey);
    }
    
    @Test
    public void saveRespondentTest(){
        Survey survey = Survey.with().id(1).build();
        repository.save();
    }
}
