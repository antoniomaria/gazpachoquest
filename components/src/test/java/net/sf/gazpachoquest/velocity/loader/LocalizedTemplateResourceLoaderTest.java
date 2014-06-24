package net.sf.gazpachoquest.velocity.loader;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.InputStream;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/jpa-test-context.xml", "classpath:/datasource-test-context.xml",
        "classpath:/components-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup("LocalizedTemplateResourceLoader-dataset.xml")
@DatabaseTearDown("LocalizedTemplateResourceLoader-dataset.xml")
public class LocalizedTemplateResourceLoaderTest {

    @Autowired
    private LocalizedTemplateResourceLoader templateloader;

    @Test
    public void getResourceStreamTest() {
        InputStream template = templateloader.getResourceStream("55");
        assertThat(template).isNotNull();

        template = templateloader.getResourceStream("55/ES");
        assertThat(template).isNotNull();
    }

}
