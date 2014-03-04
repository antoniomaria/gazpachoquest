package net.sf.gazpachoquest.questionnaires;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jglue.cdiunit.CdiRunner;
import org.jglue.cdiunit.DummyHttpRequest;
import org.jglue.cdiunit.DummyHttpSession;
import org.jglue.cdiunit.InSessionScope;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
public class QuestionnairesUITest {

    @Inject
    private QuestionnairesUI questionnairesUI;

    @Produces
    HttpServletRequest getRequest() {
        return new DummyHttpRequest();
    }

    @Produces
    HttpSession getSession() {
        return new DummyHttpSession();
    }

    @Test
    @InSessionScope
    public void initTest() {
        questionnairesUI.init(null);
        System.out.println("hola holitas");
    }
}
