package net.sf.gazpachoquest.questionnaires.util;

import java.util.Locale;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.beans10.BeansDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @see https://community.jboss.org/message/729492a
 * @author antoniomaria
 * 
 */
@RunWith(Arquillian.class)
public class MessageResourceTest {

    @Inject
    private MessageResource messageResource;

    @Deployment
    public static Archive<?> createTestArchive() {
        String beansDescriptor = Descriptors.create(BeansDescriptor.class).exportAsString();

        JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "myarchive.jar").addClasses(MessageResource.class)
                .addAsResource("resources/messages.properties")
                .addAsManifestResource(new StringAsset(beansDescriptor), "beans.xml");

        return archive;
    }

    @Test
    public void getStringTest() {
        Locale locale = Locale.ENGLISH;
        String resource = messageResource.getString(locale, "login.language.select.label");
        System.out.println("y de winner is: " + resource);
    }
}
