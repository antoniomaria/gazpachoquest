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
package net.sf.gazpachoquest.exporter;

import java.io.IOException;

import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExporterRunner {

    private static Logger logger = LoggerFactory.getLogger(ExporterRunner.class);

    public static void main(final String... args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("exporter-datasource-context.xml",
                "exporter-jpa-context.xml", "services-context.xml", "facades-context.xml", "components-context.xml");
        Exporter exporter = ctx.getBean(Exporter.class);
        StopWatch stopWatch = new StopWatch();
        logger.info("Exporting questionnair definition");
        stopWatch.start();
        exporter.doExport();
        stopWatch.stop();
        logger.info("Export process ended in {} {}", stopWatch.getTime(), "ms");
        ctx.close();
    }
}
