package net.sf.gazpachoquest.test.dbunit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBUnitDataExtractorRunner {

    public static void main(final String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("dbunitextractor-context.xml");
        DBUnitDataExtractor extractor = (DBUnitDataExtractor) ctx.getBean("dbUnitDataExtractor");
        extractor.extract();
        ctx.close();
    }

}
