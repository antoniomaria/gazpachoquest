package net.sf.gazpachoquest.questionnaires;

import java.io.IOException;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.vaadin.cdi.ArchiveProvider;

@RunWith(Arquillian.class)
@RunAsClient
@Ignore
public class QuestionnairesUITest {

    @ArquillianResource
    private URL contextPath;

    @Deployment
    public static Archive<?> createTestArchive() {
        return ArchiveProvider.createWebArchive("gazpachoquest-questionnaires-ui", QuestionnairesUI.class);
    }

    @Test
    public void initTest() throws IOException, SAXException {
        System.out.println("hola holitas" + contextPath);
        final WebClient webClient = new WebClient();
        webClient.addRequestHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP
                                                                                            // 1.1.
        webClient.addRequestHeader("Pragma", "no-cache"); // HTTP 1.0.
        webClient.addRequestHeader("Expires", "0"); //
        final HtmlPage page = webClient.getPage(contextPath.toExternalForm() + "?invitation=12345678");

        final String pageAsText = page.asText();
        webClient.closeAllWindows();
    }
}
