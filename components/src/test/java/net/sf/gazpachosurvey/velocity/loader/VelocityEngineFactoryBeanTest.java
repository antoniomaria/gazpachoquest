package net.sf.gazpachosurvey.velocity.loader;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("VelocityEngineFactoryBean-dataset.xml")
public class VelocityEngineFactoryBeanTest {

    @Autowired
    private VelocityEngineFactoryBean velocityFactory;

    @Test
    public void renderTemplateTest() {
        Map<String, Object> model = new HashMap<>();
        model.put("lastname", "test");
        model.put("firstname", "test");
        model.put("gender", "bot");
        model.put("link", "http://localhost:8080/questionaires-ui/token=1234");
        VelocityEngine velocityEngine = velocityFactory.getObject();
        String templateId = "125";
        String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateId, "UTF-8", model);
        assertThat(body).contains("Estimado Sr. test");
    }
}
