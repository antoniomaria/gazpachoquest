package net.sf.gazpachosurvey.dbpopulator;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBPopulatorRunner {

    public static void main(String ... args){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "dbpopulator-datasource-context.xml", "dbpopulator-jpa-context.xml", "services-context.xml", "mail-context.xml");
        DBPopulator populator = (DBPopulator) ctx
                .getBean(DBPopulator.class);
        populator.populate();
        ctx.close();
    }
}
