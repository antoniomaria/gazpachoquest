package net.sf.gazpachoquest.questionnaires;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.vaadin.cdi.ArchiveProvider;

// import org.jboss.arquillian.api.Deployment;

@RunWith(Arquillian.class)
@RunAsClient
public class QuestionnairesUITest {

    /**
     * * Note in this example, we must add content to "beans.xml" in order to
     * enable * our decorator in CDI/Weld -- this
     * is done in the deployment using the syntax below:
     */
    @Deployment
    public static Archive<?> createTestArchive() {
        return ArchiveProvider.createWebArchive("default", QuestionnairesUI.class, QuestionnairsClient.class);
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

    @Inject
    private QuestionnairesUI questionnairesUI;

    @Test
    public void initTest() {
        questionnairesUI.init(null);
        System.out.println("hola holitas");
    }
}
