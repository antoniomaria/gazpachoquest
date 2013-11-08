package net.sf.gazpachosurvey.repository.dynamic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachosurvey.domain.core.Answer;
import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.RespondentAnswers;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.repository.AnswerRepository;
import net.sf.gazpachosurvey.repository.QuestionRepository;
import net.sf.gazpachosurvey.repository.SurveyRepository;
import net.sf.gazpachosurvey.repository.qbe.SearchParameters;
import net.sf.gazpachosurvey.types.EntityStatus;
import net.sf.gazpachosurvey.types.QuestionType;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.dynamic.DynamicClassLoader;
import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.jpa.dynamic.JPADynamicHelper;
import org.eclipse.persistence.jpa.dynamic.JPADynamicTypeBuilder;
import org.eclipse.persistence.tools.schemaframework.SchemaManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component
public class RespondentAnswersRepositoryImpl implements
        RespondentAnswersRepository {

    private static final Logger logger = LoggerFactory
            .getLogger(RespondentAnswersRepositoryImpl.class);

    private static final String PACKAGE_PREFIX = "net.sf.gazpachosurvey.domain.dynamic.";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void collectAnswers(Survey survey) {
        Assert.notNull(survey.getId());
        // Create JPA Dynamic Helper (with the entityManager above) and after
        // the types
        // have been created and add the types through the helper.
        JPADynamicHelper helper = new JPADynamicHelper(entityManager);
        helper.addTypes(true, true, buildDynamicType(survey.getId()));
        // Update database
        new SchemaManager(helper.getSession()).createDefaultTables(true);

        logger.info("Answer table has been created for survey {}",
                survey.getId());
    }

    @Override
    public void activeAllAnswers() {
        List<Survey> confirmedSurveys = surveyRepository.findByExample(Survey
                .with().status(EntityStatus.CONFIRMED).build(),
                new SearchParameters());
        List<DynamicType> dynamicTypes = new ArrayList<>();
        for (Survey survey : confirmedSurveys) {
            dynamicTypes.add(buildDynamicType(survey.getId()));
        }
        if (!dynamicTypes.isEmpty()) {
            JPADynamicHelper helper = new JPADynamicHelper(entityManager);
            helper.addTypes(true, true,
                    dynamicTypes.toArray(new DynamicType[dynamicTypes.size()]));
        }
        logger.info("{} respondent answer tables has been activated", confirmedSurveys.size());
        
    }

    @Transactional
    public RespondentAnswers save(RespondentAnswers respondentAnswers) {
        Assert.notNull(respondentAnswers.getRespondent());

        StringBuilder tableName = new StringBuilder().append(TABLE_NAME_PREFIX)
                .append(respondentAnswers.getRespondent().getSurvey().getId());

        DynamicEntity entity = newInstance(tableName.toString());

        if (!respondentAnswers.isNew()) {
            entity.set("id", respondentAnswers.getId());
        }
        entity.set("respondentId", respondentAnswers.getRespondent().getId());

        if (!respondentAnswers.isNew()) {
            entity = entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
            respondentAnswers.setId((Integer) entity.get("id"));
        }
        entityManager.flush();
        return respondentAnswers;
    }

    private DynamicEntity newInstance(String entityAlias) {
        JPADynamicHelper helper = new JPADynamicHelper(entityManager);
        ClassDescriptor descriptor = helper.getSession().getDescriptorForAlias(
                entityAlias);
        return (DynamicEntity) descriptor.getInstantiationPolicy()
                .buildNewInstance();
    }

    private DynamicType buildDynamicType(Integer surveyId) {
        DynamicClassLoader dcl = new DynamicClassLoader(getClass()
                .getClassLoader());

        String tableName = new StringBuilder().append(TABLE_NAME_PREFIX)
                .append(surveyId).toString();

        Class<?> dynamicClass = dcl.createDynamicClass(PACKAGE_PREFIX
                + tableName);

        JPADynamicTypeBuilder respondentAnswersTypeBuilder = new JPADynamicTypeBuilder(
                dynamicClass, null, tableName);

        respondentAnswersTypeBuilder
                .addDirectMapping("id", Integer.class, "id");
        respondentAnswersTypeBuilder.addDirectMapping("respondentId",
                Integer.class, "respondent_id");

        Question example = new Question();
        example.setSurvey(Survey.with().id(surveyId).build());

        List<Question> questions = questionRepository.findByExample(example,
                new SearchParameters().orderBy("id"));

        for (Question question : questions) {
            processQuestion(respondentAnswersTypeBuilder, question);
        }

        respondentAnswersTypeBuilder.setPrimaryKeyFields("id");
        respondentAnswersTypeBuilder.configureSequencing(tableName + "_seq",
                "id");
        return respondentAnswersTypeBuilder.getType();
    }

    private void processQuestion(JPADynamicTypeBuilder surveyAnswer,
            Question question) {
        QuestionType questionType = question.getType();
        List<Question> subquestions = question.getSubquestions();
        if (subquestions.isEmpty()) {
            if (questionType.hasMultipleAnswers()) {
                String baseFieldName = "q" + question.getId();
                List<Answer> answers = question.getAnswers();
                for (Answer answer : answers) {
                    String fieldName = new StringBuilder(baseFieldName)
                            .append("x").append(answer.getId()).toString();
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

}
