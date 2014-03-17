package net.sf.gazpachoquest.test.dbunit;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.ResourcePropertySource;

public class DBUnitDataExtractorRunner {

    public static void main(final String[] args) throws Exception {
        String dbEngine = "db_postgres";
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("standalone", dbEngine);
        ctx.refresh();
        ctx.setConfigLocations(new String[] { "datasource-context.xml", "dbunitextractor-context.xml" });
        ctx.getEnvironment().getPropertySources()
                .addLast(new ResourcePropertySource(String.format("classpath:/database/%s.properties", dbEngine)));
        ctx.refresh();

        DBUnitDataExtractor extractor = (DBUnitDataExtractor) ctx.getBean("dbUnitDataExtractor");
        extractor.extract();
        ctx.close();
    }
}
