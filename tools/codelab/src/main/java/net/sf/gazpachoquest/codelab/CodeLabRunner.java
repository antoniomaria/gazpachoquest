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
package net.sf.gazpachoquest.codelab;

import java.io.IOException;

import net.sf.gazpachoquest.codelab.massive.MassiveUserLoadLab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CodeLabRunner {

    public static Logger logger = LoggerFactory.getLogger(CodeLabRunner.class);

    public static void main(final String... args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("codelab-datasource-context.xml",
                "codelab-jpa-context.xml", "services-context.xml", "facades-context.xml", "components-context.xml");
        logger.info("Hand on lab started");
        MassiveUserLoadLab codelab = ctx.getBean(MassiveUserLoadLab.class);
        codelab.execute();
        logger.info("Hand on lab ended");
        ctx.close();
    }
}
