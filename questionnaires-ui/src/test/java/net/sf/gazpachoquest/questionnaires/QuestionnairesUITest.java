package net.sf.gazpachoquest.questionnaires;

import javax.inject.Inject;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.Archives;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.impl.base.asset.ByteArrayAsset;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.vaadin.cdi.internal.BeanStoreContainer;
import com.vaadin.cdi.internal.ContextDeployer;

@RunWith(Arquillian.class)
public class QuestionnairesUITest {

    /**
     * * Note in this example, we must add content to "beans.xml" in order to enable * our decorator in CDI/Weld -- this
     * is done in the deployment using the syntax below:
     */
    @Deployment
    public static Archive<?> createTestArchive() {
        return Archives
                .create("test.jar", JavaArchive.class)
                .addClasses(ContextDeployer.class, QuestionnairesUI.class, QuestionnairsClient.class,
                        BeanStoreContainer.class)
                .addManifestResource(
                        new ByteArrayAsset(
                                "<decorators><class>net.sf.gazpachoquest.questionnaires</class></decorators>"
                                        .getBytes()), ArchivePaths.create("beans.xml"));
    }

    @Inject
    private QuestionnairesUI questionnairesUI;

    @Test
    public void initTest() {
        questionnairesUI.init(null);
        System.out.println("hola holitas");
    }
}
