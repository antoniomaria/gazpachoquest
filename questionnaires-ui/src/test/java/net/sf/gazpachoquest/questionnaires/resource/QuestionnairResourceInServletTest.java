package net.sf.gazpachoquest.questionnaires.resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;
import net.sf.gazpachoquest.questionnaires.resource.ResourceProducer;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.beans10.BeansDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @see https://community.jboss.org/message/729492a
 * @see http://java.dzone.com/articles/injecting-string-resource
 * @author antoniomaria
 * 
 */
@RunWith(Arquillian.class)
@RunAsClient
public class QuestionnairResourceInServletTest {

    @ArquillianResource
    private URL contextPath;

    @Deployment
    public static Archive<?> createTestArchive() {

        String beansDescriptor = Descriptors.create(BeansDescriptor.class).exportAsString();
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addClasses(ResourceProducer.class, GazpachoResource.class, QuestionnairResource.class,
                        QuestionnairResourceTestServlet.class)
                .addAsWebInfResource(new StringAsset(beansDescriptor), "beans.xml");
    }

    @Test
    public void listTest() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        final WebClient webClient = new WebClient();

        webClient.addRequestHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP
                                                                                            // 1.1.
        webClient.addRequestHeader("Pragma", "no-cache"); // HTTP 1.0.
        webClient.addRequestHeader("Expires", "0"); //
        final HtmlPage page = webClient.getPage(contextPath.toExternalForm() + "/testServlet");

        final String pageAsText = page.asText();

        System.out.println(pageAsText);

        webClient.closeAllWindows();

    }
}
