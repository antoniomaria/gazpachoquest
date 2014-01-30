package net.sf.gazpachosurvey.repository.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionOption;
import net.sf.gazpachosurvey.domain.core.QuestionnairAnswers;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.repository.QuestionOptionRepository;
import net.sf.gazpachosurvey.repository.QuestionRepository;
import net.sf.gazpachosurvey.repository.QuestionnairDefinitionRepository;
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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Repository
public class QuestionnairAnswersRepositoryImpl implements QuestionnairAnswersRepository {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnairAnswersRepositoryImpl.class);

    private static final String PACKAGE_PREFIX = "net.sf.gazpachosurvey.domain.dynamic.";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QuestionOptionRepository questionOptionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionnairDefinitionRepository questionnairDefinitionRepository;

    @Override
    @Transactional
    public void activeAllAnswers() {
        List<QuestionnairDefinition> confirmedSurveys = questionnairDefinitionRepository.findByExample(
                QuestionnairDefinition.with().status(EntityStatus.CONFIRMED).build(), new SearchParameters());
        List<DynamicType> dynamicTypes = new ArrayList<>();
        for (QuestionnairDefinition questionnairDefinition : confirmedSurveys) {
            dynamicTypes.add(buildDynamicType(questionnairDefinition));
        }
        if (!dynamicTypes.isEmpty()) {
            JPADynamicHelper helper = new JPADynamicHelper(entityManager);
            helper.addTypes(true, true, dynamicTypes.toArray(new DynamicType[dynamicTypes.size()]));

            DynamicType Algo = helper.getType(TABLE_NAME_PREFIX + 6);
            System.out.println("fin");
        }
        logger.info("{} questionnair answer tables has been activated", confirmedSurveys.size());

    }

    @Override
    public void collectAnswers(final QuestionnairDefinition questionnairDefinition) {
        Assert.notNull(questionnairDefinition.getId());
        // Create JPA Dynamic Helper (with the entityManager above) and after
        // the types
        // have been created and add the types through the helper.
        JPADynamicHelper helper = new JPADynamicHelper(entityManager);
        helper.addTypes(true, true, buildDynamicType(questionnairDefinition));
        // Update database
        new SchemaManager(helper.getSession()).createDefaultTables(true);

        logger.info("Questionnair answer table has been created for questionnairDefinition {}",
                questionnairDefinition.getId());
    }

    @Override
    @Transactional
    public QuestionnairAnswers findByOne(QuestionnairDefinition questionnairDefinition, Integer id) {
        Assert.notNull(questionnairDefinition);
        Assert.notNull(id);

        JPADynamicHelper helper = new JPADynamicHelper(entityManager);
        String typeName = new StringBuilder().append(TABLE_NAME_PREFIX).append(questionnairDefinition.getId())
                .toString();

        DynamicType type = helper.getType(typeName);

        DynamicEntity entity = (DynamicEntity) entityManager.find(type.getClass(), id);
        QuestionnairAnswers questionnairAnswers = null;
        if (entity != null) {
            questionnairAnswers = new QuestionnairAnswers();
        }
        List<String> codes = type.getPropertiesNames();
        for (String string : codes) {
            System.out.println("code-> " + string);
        }
        return questionnairAnswers;
    }

    @Override
    @Transactional
    public QuestionnairAnswers save(final QuestionnairAnswers questionnairAnswers) {
        Assert.notNull(questionnairAnswers.getQuestionnair());

        StringBuilder tableName = new StringBuilder().append(TABLE_NAME_PREFIX).append(
                questionnairAnswers.getQuestionnair().getQuestionnairDefinition().getId());

        DynamicEntity entity = newInstance(tableName.toString());

        if (!questionnairAnswers.isNew()) {
            entity.set("id", questionnairAnswers.getId());
        }
        entity.set("questionnairId", questionnairAnswers.getQuestionnair().getId());
        Map<String, Object> answers = questionnairAnswers.getAnswers();
        Set<String> questionCodes = answers.keySet();
        for (String questionCode : questionCodes) {
            Object answer = answers.get(questionCode);
            entity.set(questionCode, answer);
        }

        if (!questionnairAnswers.isNew()) {
            entity = entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
            questionnairAnswers.setId((Integer) entity.get("id"));
        }
        entityManager.flush();

        return questionnairAnswers;
    }

    private DynamicType buildDynamicType(final QuestionnairDefinition questionnairDefinition) {
        DynamicClassLoader dcl = new DynamicClassLoader(getClass().getClassLoader());

        String tableName = new StringBuilder().append(TABLE_NAME_PREFIX).append(questionnairDefinition.getId())
                .toString();

        Class<?> dynamicClass = dcl.createDynamicClass(PACKAGE_PREFIX + tableName);

        JPADynamicTypeBuilder respondentAnswersTypeBuilder = new JPADynamicTypeBuilder(dynamicClass, null, tableName);

        respondentAnswersTypeBuilder.addDirectMapping("id", Integer.class, "id");
        respondentAnswersTypeBuilder.addDirectMapping("questionnairId", Integer.class, "questionnair_id");

        List<Question> questions = questionRepository.findByQuestionnairId(questionnairDefinition.getId());

        for (Question question : questions) {
            processQuestion(respondentAnswersTypeBuilder, question);
        }

        respondentAnswersTypeBuilder.setPrimaryKeyFields("id");
        respondentAnswersTypeBuilder.configureSequencing(tableName + "_seq", "id");
        return respondentAnswersTypeBuilder.getType();
    }

    private DynamicEntity newInstance(final String entityAlias) {
        JPADynamicHelper helper = new JPADynamicHelper(entityManager);
        ClassDescriptor descriptor = helper.getSession().getDescriptorForAlias(entityAlias);
        return (DynamicEntity) descriptor.getInstantiationPolicy().buildNewInstance();
    }

    private void processQuestion(final JPADynamicTypeBuilder builder, final Question question) {
        QuestionType questionType = question.getType();
        if (!questionType.hasSubquestions()) {
            if (questionType.hasMultipleAnswers()) {
                String baseFieldName = new StringBuilder().append(question.getCode()).toString();
                List<QuestionOption> questionOptions = question.getQuestionOptions();
                for (QuestionOption questionOption : questionOptions) {
                    String fieldName = new StringBuilder(baseFieldName).append("_").append(questionOption.getCode())
                            .toString().toLowerCase();
                    builder.addDirectMapping(fieldName, questionType.getAnswerType(), fieldName);
                }
            } else {
                String fieldName = new StringBuilder().append(question.getCode().replace(".", "_")).toString()
                        .toLowerCase();
                builder.addDirectMapping(fieldName, questionType.getAnswerType(), fieldName);
            }
        } else {
            Question example = Question.with().parent(Question.with().id(question.getId()).build()).build();
            List<Question> subquestions = questionRepository.findByExample(example, new SearchParameters());

            for (Question subquestion : subquestions) {
                processQuestion(builder, subquestion);
            }
        }

    }

}
