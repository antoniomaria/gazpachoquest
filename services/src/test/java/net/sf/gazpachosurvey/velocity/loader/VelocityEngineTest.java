package net.sf.gazpachosurvey.velocity.loader;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;
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
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml",
        "classpath:/datasource-test-context.xml",
        "classpath:/services-context.xml", "classpath:/mail-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@DatabaseSetup("VelocityEngineTest-dataset.xml")
public class VelocityEngineTest {

    @Autowired
    VelocityEngineFactoryBean velocityFactory;

    @Test
    public void mergeTemplateIntoStringTest() {
        VelocityEngine velocityEngine = velocityFactory.getObject();
        Map<String, String> model = new HashMap<>();
        model.put("lastname", "Sanchez Berrocal");

        for (int i = 0; i < 10; i++){

            System.out.println("Step : " + i + " ***********************");
            String result = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, "101", "UTF-8", model);

            System.out.println("template: " + result);
    
        }
            
    
    }
}
