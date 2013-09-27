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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml",
        "classpath:/services-context.xml", "classpath:/mail-context.xml" })
public class VelocityExample {

    @Autowired
    VelocityEngineFactoryBean velocityFactory;

    @Test
    public void helloWorld() {
        VelocityEngine engine = velocityFactory.getObject();

        StringResourceRepository repo = StringResourceLoader.getRepository();
        repo.putStringResource("myTemplate",
                "Hi, ${username}... this is some template!");
        Template testTemplate = engine.getTemplate("myTemplate");
        
        VelocityContext context = new VelocityContext();
        context.put("username", "Antonio Maria");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        testTemplate.merge( context, writer );
        /* show the World */
        System.out.println( writer.toString() );  
    }

    @Test
    public void readTemplate() {
        VelocityEngine velocityEngine = velocityFactory.getObject();
       Map<String, String> model = new HashMap<>();
       model.put("lastname", "Sanchez Berrocal");
       
       String result = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "EN/251", "UTF-8",  model);
       
    System.out.println("template: " + result);
    }
}
