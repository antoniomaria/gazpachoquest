package net.sf.gazpachosurvey.jpa;

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
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class GenerateDllTest {

    @Test
    @Ignore
    public void DDLGenerationTest() throws IOException {
        generateDDL("default");
    }

    public void generateDDL(String databaseProviderName) throws IOException {

        File target = new File("target/generated-sources/"
                + databaseProviderName);
        target.mkdirs();

        Map<String, String> persistProperties = new HashMap<String, String>();
        persistProperties.put(
                PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML,
                "META-INF/default-persistence.xml");
        persistProperties.put(PersistenceUnitProperties.DDL_GENERATION,
                "drop-and-create-tables");
        persistProperties.put(PersistenceUnitProperties.DDL_GENERATION_MODE,
                "sql-script");
        persistProperties.put(PersistenceUnitProperties.SESSION_CUSTOMIZER,
                "net.sf.gazpachosurvey.jpa.CamelNamingStrategy");

        persistProperties.put(PersistenceUnitProperties.APP_LOCATION,
                target.getPath());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "default", persistProperties);
        emf.createEntityManager();

        Path input = Paths.get(target.getPath(), "createDDL.jdbc");
        Path output = Paths.get(target.getPath(), "createDDL.sql");
        try (BufferedReader br = Files.newBufferedReader(input,
                Charset.defaultCharset());
                BufferedWriter bw = Files.newBufferedWriter(output,
                        Charset.defaultCharset(), StandardOpenOption.CREATE)) {

            String thisLine = null;
            while ((thisLine = br.readLine()) != null) {
                bw.write(thisLine);
                bw.write(";");
                bw.newLine();
            }
        }
        Files.delete(input);
    }
}
