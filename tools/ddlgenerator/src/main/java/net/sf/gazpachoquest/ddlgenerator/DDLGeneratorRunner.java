package net.sf.gazpachoquest.ddlgenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DDLGeneratorRunner {

    private static final Logger logger = LoggerFactory.getLogger(DDLGeneratorRunner.class);

    public static void main(String args[]) throws Exception {
        logger.info("Generating ddl schema using META-INF/default-persistence.xml settings");
        new DDLGenerator().generate("default");
        logger.info("Done successfully. Check your target/generated-sources directory");
    }
}
