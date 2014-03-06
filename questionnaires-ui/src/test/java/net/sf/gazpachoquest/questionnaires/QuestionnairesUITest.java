package net.sf.gazpachoquest.questionnaires;

import java.io.IOException;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.vaadin.cdi.ArchiveProvider;

// import org.jboss.arquillian.api.Deployment;

@RunWith(Arquillian.class)
@RunAsClient
public class QuestionnairesUITest {

    @ArquillianResource
    private URL contextPath;

    @Deployment
    public static Archive<?> createTestArchive() {
        return ArchiveProvider.createWebArchive("gazpachoquest-questionnaires-ui", QuestionnairesUI.class,
                QuestionnairsClient.class);
    }

    /*-
    public static Archive<?> createTestArchive() {
        return Archives
                .create("test.jar", JavaArchive.class)
                .addClasses(ContextDeployer.class, QuestionnairesUI.class, QuestionnairsClient.class,
                        BeanStoreContainer.class)
                .addManifestResource(
                        new ByteArrayAsset(
                                "<decorators><class>net.sf.gazpachoquest.questionnaires</class></decorators>"
                                        .getBytes()), ArchivePaths.create("beans.xml"));
    }*/

    @Test
    public void initTest() throws IOException, SAXException {
        System.out.println("hola holitas" + contextPath);
        final WebClient webClient = new WebClient();
        final HtmlPage page = webClient.getPage(contextPath.toExternalForm());

        final String pageAsText = page.asText();

        System.out.println(pageAsText);

        webClient.closeAllWindows();
    }
}
