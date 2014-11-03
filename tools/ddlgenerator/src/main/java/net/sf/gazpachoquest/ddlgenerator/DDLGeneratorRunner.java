/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.ddlgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DDLGeneratorRunner {

    private static final Logger logger = LoggerFactory.getLogger(DDLGeneratorRunner.class);

    public static void main(String args[]) throws Exception {
        logger.info("Generating ddl schema using META-INF/default-persistence.xml settings");
        new DDLGenerator().generate("mysql");
        logger.info("Done successfully. Check your target/generated-sources directory");
    }
}
