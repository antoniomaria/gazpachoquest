package net.sf.gazpachosurvey.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachosurvey.domain.core.Answer;
import net.sf.gazpachosurvey.domain.core.Page;
import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.repository.AnswerRepository;
import net.sf.gazpachosurvey.repository.QuestionRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.types.QuestionType;

import org.eclipse.persistence.dynamic.DynamicClassLoader;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.jpa.dynamic.JPADynamicHelper;
import org.eclipse.persistence.jpa.dynamic.JPADynamicTypeBuilder;
import org.eclipse.persistence.tools.schemaframework.SchemaManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("postgres")
@ContextConfiguration(locations = { "classpath:/jpa-context.xml",
        "classpath:/services-context.xml" })
public class DynamicTest {

    @PersistenceContext
    private EntityManager emf;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    public void ff() {
        Answer answer = new Answer();
        Question q = new Question();
        q.setId(2);
        answer.setQuestion(q);
        long count = answerRepository.findCount(answer, new SearchParameters());
        System.out.println("de winner is: " + count);
    }

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void createAnswersTable() {
        String packagePrefix = "net.sf.gazpachosurvey.domain.dynamic.";

        DynamicClassLoader dcl = new DynamicClassLoader(Thread.currentThread()
                .getContextClassLoader());

        int surveyId = 1;
        Survey survey = surveyRepository.findOne(surveyId);

        String tableName = "SurveyAnswers_" + surveyId;

        Class<?> surveyAnswerClass = dcl.createDynamicClass(packagePrefix
                + tableName);

        JPADynamicTypeBuilder surveyAnswer = new JPADynamicTypeBuilder(
                surveyAnswerClass, null, tableName);

        surveyAnswer.addDirectMapping("id", int.class, tableName + ".ID");

        for (Page page : survey.getPages()) {
            List<Question> questions = page.getQuestions();
            for (Question question : questions) {
                QuestionType questionType = question.getType();
                System.out.println(question.getType() + " "
                        + question.getTitle());
                if (questionType.hasMultipleAnswers()) {

                } else {
                    String fieldName = "q" + question.getId();
                    surveyAnswer.addDirectMapping(fieldName,
                            questionType.getAnswerType(), fieldName);
                }
                for (Answer answer : question.getAnswers()) {
                    System.out.println("\t " + answer.getTitle());
                }
            }
        }
        surveyAnswer.setPrimaryKeyFields("ID");
        surveyAnswer.configureSequencing(tableName + "_SEQ", "ID");
        DynamicType[] types = new DynamicType[] { surveyAnswer.getType() };

        // Create JPA Dynamic Helper (with the emf above) and after the types
        // have been created and add the types through the helper.
        JPADynamicHelper helper = new JPADynamicHelper(emf);
        helper.addTypes(true, true, types);

        // Update database
        new SchemaManager(helper.getSession()).createDefaultTables(true);
    }

    @Test
    public void myTest() {

        DynamicClassLoader dcl = new DynamicClassLoader(Thread.currentThread()
                .getContextClassLoader());

        DynamicType[] types = createTypes(dcl,
                "example.jpa.dynamic.model.employee");

        // Create JPA Dynamic Helper (with the emf above) and after the types
        // have been created and add the types through the helper.
        JPADynamicHelper helper = new JPADynamicHelper(emf);
        helper.addTypes(true, true, types);

        // Create database and populate
        new SchemaManager(helper.getSession()).replaceDefaultTables();
    }

    public static DynamicType[] createTypes(DynamicClassLoader dcl,
            String packageName) {
        String packagePrefix = packageName.endsWith(".") ? packageName
                : packageName + ".";

        Class<?> surveyAnswerClass = dcl.createDynamicClass(packagePrefix
                + "SurveyAnswer");

        JPADynamicTypeBuilder surveyAnswer = new JPADynamicTypeBuilder(
                surveyAnswerClass, null, "D_SurveyAnswer");

        surveyAnswer.setPrimaryKeyFields("ID");

        surveyAnswer.addDirectMapping("id", int.class, "D_SurveyAnswer.ID");
        surveyAnswer.addDirectMapping("participant", String.class,
                "D_SurveyAnswer.participant");
        surveyAnswer.addDirectMapping("otrocampo", String.class,
                "D_SurveyAnswer.otrocampo");

        surveyAnswer.configureSequencing("SurveyAnswer_SEQ", "ID");
        DynamicType[] types = new DynamicType[] { surveyAnswer.getType() };
        return types;
    }

}
