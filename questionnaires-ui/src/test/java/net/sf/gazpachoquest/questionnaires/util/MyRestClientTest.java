package net.sf.gazpachoquest.questionnaires.util;

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
 * @see http://java.dzone.com/articles/injecting-string-resource
 * @author antoniomaria
 * 
 */
@RunWith(Arquillian.class)
public class MyRestClientTest {

    @Inject
    @GazpachoClient
    private MyRestClient myRestClient;

    @Deployment
    public static Archive<?> createTestArchive() {
        String beansDescriptor = Descriptors.create(BeansDescriptor.class).exportAsString();

        JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "myarchive.jar").addClasses(ClientProducer.class)
                .addClasses(GazpachoClient.class).addClasses(MyRestClient.class).addClasses(MyRestClientImpl.class)

                .addAsResource("resources/messages.properties")
                .addAsManifestResource(new StringAsset(beansDescriptor), "beans.xml");

        return archive;
    }

    @Test
    public void getIdTest() {
        System.out.println("y de winner is: " + myRestClient.getId());
    }
}
