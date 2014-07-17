package net.sf.gazpachoquest.questionnair.support;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.test.dbunit.support.ColumnDetectorXmlDataSetLoader;
import net.sf.gazpachoquest.types.RandomizationStrategy;

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
        "classpath:/services-context.xml", "classpath:/components-context.xml", "classpath:/questionnair-context.xml",
        "classpath:/facades-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DbUnitConfiguration(dataSetLoader = ColumnDetectorXmlDataSetLoader.class)
public class PageMetadataCreatorTest {

    @Autowired
    private PageMetadataCreator pageMetadataCreator;

    @Autowired
    private BreadcrumbService breadcrumbService;

    @DatabaseSetup("PageMetadataCreatorTest-dataset.xml")
    @DatabaseTearDown("PageMetadataCreatorTest-dataset.xml")
    @Test
    public void createForQuestionGroupNoRandomizationTest() {
        Breadcrumb breadcrumb = breadcrumbService.findOne(201);
        PageMetadataStructure metadata = pageMetadataCreator.create(RandomizationStrategy.NONE, breadcrumb);
        assertThat(metadata.getCount()).isEqualTo(3);
        assertThat(metadata.getNumber()).isEqualTo(3);
    }

    @Test
    @DatabaseSetup("PageMetadataCreatorQuestionRandomizationStrategyTest-dataset.xml")
    @DatabaseTearDown("PageMetadataCreatorQuestionRandomizationStrategyTest-dataset.xml")
    public void createRandomizationPerQuestionEnabledTest() {
        /*-
        Breadcrumb breadcrumb = breadcrumbService.findOne(103);
        PageMetadataStructure metadata = pageMetadataCreator.create(RandomizationStrategy.QUESTIONS_RANDOMIZATION,
                breadcrumb);
        assertThat(metadata.getCount()).isEqualTo(8);
        assertThat(metadata.getNumber()).isEqualTo(2);*/
        breadcrumbService.deleteByExample(Breadcrumb.withProps().questionnair(Questionnair.with().id(64).build())
                .build(), new SearchParameters());
    }

}
