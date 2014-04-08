/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.extractor.dbunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBUnitDataExtractorRunner {

    private final static Logger logger = LoggerFactory.getLogger(DBUnitDataExtractorRunner.class);

    public static void main(final String[] args) throws Exception {
        String dbEngine = "db_postgres";
        logger.info("Extracting data from {} database in DBUnit format", dbEngine);

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("postgres", dbEngine);
        ctx.refresh();
        ctx.setConfigLocations(new String[] { "dbunitextractor-datasource-context.xml", "dbunitextractor-context.xml" });
        /*-
        ctx.getEnvironment().getPropertySources()
                .addLast(new ResourcePropertySource(String.format("classpath:/database/%s.properties", dbEngine))); */
        ctx.refresh();

        DBUnitDataExtractor extractor = (DBUnitDataExtractor) ctx.getBean("dbUnitDataExtractor");
        extractor.extract();
        ctx.close();

        logger.info("Done successfully. Check your target directory");

    }
}
