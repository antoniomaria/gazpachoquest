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
package net.sf.gazpachoquest.dbpopulator;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBPopulatorRunner {

    private static Logger logger = LoggerFactory.getLogger(DBPopulatorRunner.class);

    public static void main(final String... args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("dbpopulator-datasource-context.xml",
                "dbpopulator-jpa-context.xml", "services-context.xml", "facades-context.xml", "components-context.xml");
        DBPopulator populator = ctx.getBean(DBPopulator.class);
        StopWatch stopWatch = new StopWatch();
        logger.info("Populating database");
        stopWatch.start();
        populator.populate();
        stopWatch.stop();
        logger.info("Database populated in {} {}", stopWatch.getTime(), "ms");

        ctx.close();
    }
}
