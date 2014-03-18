package net.sf.gazpachoquest.dbpopulator;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBPopulatorRunner {

    public static void main(final String... args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("dbpopulator-datasource-context.xml",
                "dbpopulator-jpa-context.xml", "services-context.xml", "components-context.xml");
        DBPopulator populator = ctx.getBean(DBPopulator.class);
        populator.populate();
        ctx.close();
    }
}
