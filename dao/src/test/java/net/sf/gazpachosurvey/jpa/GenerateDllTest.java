package net.sf.gazpachosurvey.jpa;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.Test;

public class GenerateDllTest {

    @Test
    public void DDLGenerationTest() {
        generateDDL("mysql");
        generateDDL("postgres");
        generateDDL("hsql");
    }

    public void generateDDL(String databaseProviderName) {
        
        File target = new File("target/generated-sources/" + databaseProviderName);
        target.mkdirs();
        
        Map<String, String> persistProperties = new HashMap<String, String>();
        persistProperties.put(
                PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML,
                "META-INF/test-persistence.xml");
        persistProperties.put(PersistenceUnitProperties.DDL_GENERATION,
                "drop-and-create-tables");
        persistProperties.put(PersistenceUnitProperties.DDL_GENERATION_MODE,
                "sql-script");
        persistProperties.put(PersistenceUnitProperties.SESSION_CUSTOMIZER,
                "net.sf.gazpachosurvey.jpa.CamelNamingStrategy");

        persistProperties.put(PersistenceUnitProperties.APP_LOCATION,
                target.getPath());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                databaseProviderName + "PersistenceUnit", persistProperties);
        emf.createEntityManager();
    }
}
