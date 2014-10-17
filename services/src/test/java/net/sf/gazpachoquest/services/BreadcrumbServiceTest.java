package net.sf.gazpachoquest.services;

import static org.fest.assertions.api.Assertions.assertThat;

import javax.persistence.metamodel.SingularAttribute;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("BreadcrumbService-dataset.xml")
@DatabaseTearDown("BreadcrumbService-dataset.xml")
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class BreadcrumbServiceTest {

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Test
    public void countByQuestionnair() {
        Integer questionnaireId = 58;
        Integer count = breadcrumbService.countByQuestionnair(questionnaireId);
        assertThat(count).isEqualTo(3);
    }

    @Test
    public void ff() {
        Integer questionnaireId = 58;
        Breadcrumb entity = Breadcrumb.withProps().questionnaire(Questionnaire.with().id(questionnaireId).build())
                .build();
        // DateTime from = new DateTime();
        final SingularAttribute<?, LocalDate> field;
        final LocalDate from;
      //  SearchParameters searchParameters = new SearchParameters().after(field, from);
        //breadcrumbService.deleteByExample(entity, searchParameters);
    }
}
