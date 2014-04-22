/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.repository.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.QuestionnairAnswers;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.qbe.support.SearchParameters;
import net.sf.gazpachoquest.repository.QuestionOptionRepository;
import net.sf.gazpachoquest.repository.QuestionRepository;
import net.sf.gazpachoquest.repository.QuestionnairDefinitionRepository;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.QuestionType;

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

    private static final String PACKAGE_PREFIX = "net.sf.gazpachoquest.domain.dynamic.";

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
        DynamicClassLoader dcl = new DynamicClassLoader(Thread.currentThread().getContextClassLoader());
        List<QuestionnairDefinition> confirmedSurveys = questionnairDefinitionRepository.findByExample(
                QuestionnairDefinition.with().status(EntityStatus.CONFIRMED).build(), new SearchParameters());

        List<DynamicType> dynamicTypes = new ArrayList<>();
        JPADynamicHelper helper = new JPADynamicHelper(entityManager);

        for (QuestionnairDefinition questionnairDefinition : confirmedSurveys) {
            String entityAlias = new StringBuilder().append(ENTITY_NAME_PREFIX).append(questionnairDefinition.getId())
                    .toString();
            DynamicType type = helper.getType(entityAlias);
            if (type == null) {
                dynamicTypes.add(buildDynamicType(dcl, questionnairDefinition));
            }
        }
        if (!dynamicTypes.isEmpty()) {
            helper.addTypes(true, true, dynamicTypes.toArray(new DynamicType[dynamicTypes.size()]));
        }
        logger.info("{} questionnair answer tables has been activated", confirmedSurveys.size());

        // Update database
        new SchemaManager(helper.getSession()).createDefaultTables(true);

    }

    @Override
    public void collectAnswers(final QuestionnairDefinition questionnairDefinition) {
        Assert.notNull(questionnairDefinition.getId());
        DynamicClassLoader dcl = new DynamicClassLoader(Thread.currentThread().getContextClassLoader());
        // Create JPA Dynamic Helper (with the entityManager above) and after
        // the types
        // have been created and add the types through the helper.
        JPADynamicHelper helper = new JPADynamicHelper(entityManager);
        helper.addTypes(true, true, buildDynamicType(dcl, questionnairDefinition));
        // Update database
        new SchemaManager(helper.getSession()).createDefaultTables(true);

        logger.info("Questionnair answer table has been created for questionnairDefinition {}",
                questionnairDefinition.getId());
    }

    @Override
    @Transactional
    public QuestionnairAnswers findByOne(Integer questionnairDefinitionId, Integer id) {
        Assert.notNull(questionnairDefinitionId);
        QuestionnairAnswers questionnairAnswers = null;

        String entityAlias = new StringBuilder().append(ENTITY_NAME_PREFIX).append(questionnairDefinitionId).toString();

        JPADynamicHelper helper = new JPADynamicHelper(entityManager);

        DynamicType type = helper.getType(entityAlias);

        DynamicEntity found = entityManager.find(type.getJavaClass(), id);
        if (found != null) {
            questionnairAnswers = new QuestionnairAnswers();
            questionnairAnswers.setId(id);
            List<String> propertyNames = type.getPropertiesNames();
            for (String propertyName : propertyNames) {
                Object value = found.get(propertyName);
                questionnairAnswers.setAnswer(propertyName, value);
            }
        }
        return questionnairAnswers;
    }

    @Override
    @Transactional
    public QuestionnairAnswers save(final Integer questionnairDefinitionId,
            final QuestionnairAnswers questionnairAnswers) {

        String entityAlias = new StringBuilder().append(ENTITY_NAME_PREFIX).append(questionnairDefinitionId).toString();

        Map<String, Object> answers = questionnairAnswers.getAnswers();
        DynamicEntity entity = newInstance(entityAlias);
        if (!questionnairAnswers.isNew()) {
            entity.set("id", questionnairAnswers.getId());
        }
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
        // entityManager.flush();
        // entityManager.clear();
        return questionnairAnswers;
    }

    private DynamicType buildDynamicType(DynamicClassLoader dcl, final QuestionnairDefinition questionnairDefinition) {

        String entityAlias = new StringBuilder().append(ENTITY_NAME_PREFIX).append(questionnairDefinition.getId())
                .toString();

        Class<?> dynamicClass = dcl.createDynamicClass(PACKAGE_PREFIX + entityAlias);

        JPADynamicTypeBuilder builder = new JPADynamicTypeBuilder(dynamicClass, null, entityAlias);
        configure(builder, entityAlias, questionnairDefinition.getId());
        return builder.getType();
    }

    private void configure(JPADynamicTypeBuilder questionnairAnswer, String entityName, Integer questionnairDefinitionId) {
        questionnairAnswer.addDirectMapping("id", Integer.class, "id");

        List<Question> questions = questionRepository.findByQuestionnairId(questionnairDefinitionId);

        for (Question question : questions) {
            processQuestion(questionnairAnswer, question);
        }

        questionnairAnswer.setPrimaryKeyFields("id");
        questionnairAnswer.configureSequencing(entityName + "_seq", "id");

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
            Assert.notEmpty(subquestions, String.format("Type %s requires subquestion", questionType));
            for (Question subquestion : subquestions) {
                processQuestion(builder, subquestion);
            }
        }

    }

}
