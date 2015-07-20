/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.ddlgenerator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class DDLGenerator {
    public void generate(final String databaseProviderName) throws IOException {
        File target = new File("target/generated-sources/" + databaseProviderName);
        target.delete();
        target.mkdirs();

        Map<String, String> persistProperties = new HashMap<String, String>();
        persistProperties
                .put(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML, "META-INF/default-persistence.xml");
        persistProperties.put(PersistenceUnitProperties.DDL_GENERATION, "drop-and-create-tables");
        persistProperties.put(PersistenceUnitProperties.DDL_GENERATION_MODE, "sql-script");
        persistProperties.put(PersistenceUnitProperties.SESSION_CUSTOMIZER,
                "net.sf.gazpachoquest.jpa.eclipselink.CamelNamingStrategy");

        persistProperties.put(PersistenceUnitProperties.APP_LOCATION, target.getPath());

        if (databaseProviderName.equals("postgres")) {
            addPostgresSettings(persistProperties);
        } else if (databaseProviderName.equals("mysql")) {
            addMysqlSettings(persistProperties);
        } else {
            addHSQLettings(persistProperties);
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gazpachoquest", persistProperties);
        emf.createEntityManager();

        Path input = Paths.get(target.getPath(), "createDDL.jdbc");
        Path output = Paths.get(target.getPath(), "createDDL.sql");
        try (BufferedReader br = Files.newBufferedReader(input, Charset.defaultCharset());
                BufferedWriter bw = Files
                        .newBufferedWriter(output, Charset.defaultCharset(), StandardOpenOption.CREATE)) {

            String thisLine = null;
            while ((thisLine = br.readLine()) != null) {
                bw.write(thisLine);
                bw.write(";");
                bw.newLine();
            }
        }
        Files.delete(input);
    }

    private void addMysqlSettings(Map<String, String> persistProperties) {
        persistProperties.put(PersistenceUnitProperties.JDBC_DRIVER, "com.mysql.jdbc.Driver");
        persistProperties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:mysql://localhost:3306/gazpachoquest");
        persistProperties.put(PersistenceUnitProperties.JDBC_USER, "root");
        persistProperties.put(PersistenceUnitProperties.JDBC_PASSWORD, "admin");
    }

    public void addPostgresSettings(Map<String, String> persistProperties) {
        persistProperties.put(PersistenceUnitProperties.JDBC_DRIVER, "org.postgresql.Driver");
        persistProperties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:postgresql://localhost:5432/gazpachoquest");
        persistProperties.put(PersistenceUnitProperties.JDBC_USER, "postgres");
        persistProperties.put(PersistenceUnitProperties.JDBC_PASSWORD, "admin");
    }

    public void addHSQLettings(Map<String, String> persistProperties) {
        persistProperties.put(PersistenceUnitProperties.JDBC_DRIVER, "org.hsqldb.jdbcDriver");
        persistProperties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:hsqldb:mem:testdb");
        persistProperties.put(PersistenceUnitProperties.JDBC_USER, "sa");
        persistProperties.put(PersistenceUnitProperties.JDBC_PASSWORD, "");
    }
}
