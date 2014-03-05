package net.sf.gazpachoquest.questionnaires;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MyQuestionnairesUITest {

    /**
     * * Note in this example, we must add content to "beans.xml" in order to
     * enable * our decorator in CDI/Weld -- this
     * is done in the deployment using the syntax below:
     */
    /*-
    @Deployment
    public static Archive<?> createTestArchive() {
        return ArchiveProvider.createWebArchive("default", QuestionnairesUI.class, QuestionnairsClient.class);
    }
     */

    @Inject
    private QuestionnairesUI questionnairesUI;

    public void initTest() {
        // questionnairesUI.init(null);
        System.out.println("hola holitas");
    }
}
