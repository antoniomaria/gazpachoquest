package net.sf.gazpachosurvey.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.eclipse.persistence.dynamic.DynamicClassLoader;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.jpa.dynamic.JPADynamicHelper;
import org.eclipse.persistence.jpa.dynamic.JPADynamicTypeBuilder;
import org.eclipse.persistence.tools.schemaframework.SchemaManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml", "classpath:/services-context.xml" })
public class DynamicTest {
    
    @PersistenceContext
    private EntityManager emf;
    
    @Test
    public void myTest(){
        

        DynamicClassLoader dcl = new DynamicClassLoader(Thread.currentThread().getContextClassLoader());
        
        DynamicType[] types = createTypes(dcl, "example.jpa.dynamic.model.employee");

        // Create JPA Dynamic Helper (with the emf above) and after the types
        // have been created and add the types through the helper.
        JPADynamicHelper helper = new JPADynamicHelper(emf);
        helper.addTypes(true, true, types);

        // Create database and populate
        new SchemaManager(helper.getSession()).replaceDefaultTables();
    }
    
    public static DynamicType[] createTypes(DynamicClassLoader dcl, String packageName) {
        String packagePrefix = packageName.endsWith(".") ? packageName : packageName + ".";

        Class<?> surveyAnswerClass = dcl.createDynamicClass(packagePrefix + "SurveyAnswer");

        JPADynamicTypeBuilder surveyAnswer = new JPADynamicTypeBuilder(surveyAnswerClass, null, "D_SurveyAnswer");

        surveyAnswer.setPrimaryKeyFields("ID");

        surveyAnswer.addDirectMapping("id", int.class, "D_SurveyAnswer.ID");
        surveyAnswer.addDirectMapping("participant", String.class, "D_SurveyAnswer.participant");
        surveyAnswer.addDirectMapping("otrocampo", String.class, "D_SurveyAnswer.otrocampo");

        surveyAnswer.configureSequencing("SurveyAnswer_SEQ", "ID");
        DynamicType[] types = new DynamicType[] { surveyAnswer.getType() };
        return types;
    }

}
