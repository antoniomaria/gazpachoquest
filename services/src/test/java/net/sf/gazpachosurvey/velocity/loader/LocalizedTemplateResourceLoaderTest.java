package net.sf.gazpachosurvey.velocity.loader;

import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml",
        "classpath:/services-context.xml" })
public class LocalizedTemplateResourceLoaderTest {

    @Autowired
    private LocalizedTemplateResourceLoader templateloader;

    @Test
    public void getResourceStreamTest(){
       InputStream template = templateloader.getResourceStream("101/ES");
       System.out.println("es null?" + template == null);
    }
    
}
