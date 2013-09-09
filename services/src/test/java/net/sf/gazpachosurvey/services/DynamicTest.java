package net.sf.gazpachosurvey.services;

import java.util.Date;
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
import org.junit.Ignore;
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
        long count = answerRepository.countByExample(answer,
                new SearchParameters());
        System.out.println("de winner is: " + count);
    }

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void createAnswersTable() {
        String packagePrefix = "net.sf.gazpachosurvey.domain.dynamic.";
        //ClassLoader.getSystemClassLoader().
        
        DynamicClassLoader dcl = new DynamicClassLoader(Thread.currentThread()
                .getContextClassLoader());

        int surveyId = 1;
        Survey survey = surveyRepository.findOne(surveyId);

        String tableName = "SurveyAnswers_" + surveyId;

        Class<?> surveyAnswerClass = dcl.createDynamicClass(packagePrefix
                + tableName);

        JPADynamicTypeBuilder surveyAnswer = new JPADynamicTypeBuilder(
                surveyAnswerClass, null, tableName);

        surveyAnswer.addDirectMapping("id", Integer.class, tableName + ".id");
        surveyAnswer.addDirectMapping("submitDate", Date.class, tableName
                + ".submit_date");
        surveyAnswer.addDirectMapping("startDate", Date.class, tableName
                + ".start_date");
        surveyAnswer.addDirectMapping("ipAddress", String.class, tableName
                + ".ip_address");

        Question example = new Question();
        example.setSurvey(Survey.with().id(surveyId).build());

        List<Question> questions = questionRepository.findByExample(example,
                new SearchParameters().orderBy("id"));

        for (Question question : questions) {
            processQuestion(surveyAnswer, question);
        }

        surveyAnswer.setPrimaryKeyFields("id");
        surveyAnswer.configureSequencing(tableName + "_SEQ", "id");
        DynamicType[] types = new DynamicType[] { surveyAnswer.getType() };

        // Create JPA Dynamic Helper (with the emf above) and after the types
        // have been created and add the types through the helper.
        JPADynamicHelper helper = new JPADynamicHelper(emf);
        helper.addTypes(true, true, types);

        // Update database
        new SchemaManager(helper.getSession()).createDefaultTables(true);
    }

    private void processQuestion(JPADynamicTypeBuilder surveyAnswer,
            Question question) {
        QuestionType questionType = question.getType();
        System.out.println(question.getId() + " " + question.getType() + " "
                + question.getTitle());

        List<Question> subquestions = question.getSubquestions();
        if (subquestions.isEmpty()) {
            if (questionType.hasMultipleAnswers()) {
                String baseFieldName = "q" + question.getId();
                List<Answer> answers = question.getAnswers();
                for (Answer answer : answers) {
                    String fieldName = new StringBuilder(baseFieldName).append("x").append(answer.getId()).toString();
                    surveyAnswer.addDirectMapping(fieldName,
                            questionType.getAnswerType(), fieldName);
                }
            } else {
                String fieldName = "q" + question.getId();
                surveyAnswer.addDirectMapping(fieldName,
                        questionType.getAnswerType(), fieldName);
            }
        }
        for (Question subquestion : subquestions) {
            processQuestion(surveyAnswer, subquestion);
        }
    }

    @Test
    @Ignore
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
