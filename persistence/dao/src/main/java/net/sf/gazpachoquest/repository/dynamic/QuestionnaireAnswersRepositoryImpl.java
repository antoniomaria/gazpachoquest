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
import java.util.Locale;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionOption;
import net.sf.gazpachoquest.domain.core.QuestionnaireAnswers;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.qbe.SearchParameters;
import net.sf.gazpachoquest.repository.QuestionOptionRepository;
import net.sf.gazpachoquest.repository.QuestionRepository;
import net.sf.gazpachoquest.repository.QuestionnaireDefinitionRepository;
import net.sf.gazpachoquest.types.EntityStatus;
import net.sf.gazpachoquest.types.QuestionType;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.dynamic.DynamicClassLoader;
import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.jpa.JpaHelper;
import org.eclipse.persistence.jpa.dynamic.JPADynamicHelper;
import org.eclipse.persistence.jpa.dynamic.JPADynamicTypeBuilder;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.tools.schemaframework.SchemaManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Repository
public class QuestionnaireAnswersRepositoryImpl implements QuestionnaireAnswersRepository {

    private static final Logger logger = LoggerFactory.getLogger(QuestionnaireAnswersRepositoryImpl.class);

    private static final String PACKAGE_PREFIX = "net.sf.gazpachoquest.domain.dynamic.";

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QuestionOptionRepository questionOptionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionnaireDefinitionRepository questionnaireDefinitionRepository;

    @Override
    @Transactional
    public void activeAllAnswers() {
        final Session session = JpaHelper.getEntityManager(entityManager).getSession();
        final DynamicClassLoader dcl = DynamicClassLoader.lookup(session);

        final List<QuestionnaireDefinition> confirmedSurveys = questionnaireDefinitionRepository.findByExample(
                QuestionnaireDefinition.with().status(EntityStatus.CONFIRMED).build(), new SearchParameters());

        final List<DynamicType> dynamicTypes = new ArrayList<>();
        final JPADynamicHelper helper = new JPADynamicHelper(entityManager);

        for (final QuestionnaireDefinition questionnaireDefinition : confirmedSurveys) {
            final String entityAlias = new StringBuilder().append(ENTITY_NAME_PREFIX).append(questionnaireDefinition.getId()).toString();
            final DynamicType type = helper.getType(entityAlias);
            if (type == null) {
                dynamicTypes.add(buildDynamicType(dcl, questionnaireDefinition));
            }
        }
        if (!dynamicTypes.isEmpty()) {
            helper.addTypes(true, true, dynamicTypes.toArray(new DynamicType[dynamicTypes.size()]));
        }
        logger.info("{} questionnaire answer tables has been activated", confirmedSurveys.size());

        // Update database
        new SchemaManager(helper.getSession()).createDefaultTables(true);

    }

    @Override
    public void collectAnswers(final QuestionnaireDefinition questionnaireDefinition) {
        Assert.notNull(questionnaireDefinition.getId());
        final Session session = JpaHelper.getEntityManager(entityManager).getSession();
        // DynamicClassLoader dcl = new
        // DynamicClassLoader(Thread.currentThread().getContextClassLoader());
        final DynamicClassLoader dcl = DynamicClassLoader.lookup(session);

        // Create JPA Dynamic Helper (with the entityManager above) and after
        // the types
        // have been created and add the types through the helper.
        final JPADynamicHelper helper = new JPADynamicHelper(entityManager);
        helper.addTypes(true, true, buildDynamicType(dcl, questionnaireDefinition));
        // Update database
        new SchemaManager(helper.getSession()).createDefaultTables(true);

        logger.info("Questionnaire answer table has been created for questionnaireDefinition {}", questionnaireDefinition.getId());
    }

    @Override
    @Transactional
    public QuestionnaireAnswers findByOne(final Integer questionnaireDefinitionId, final Integer id) {
        Assert.notNull(questionnaireDefinitionId, "Questionnaire definition id is required ");
        Assert.notNull(id, "Questionnaire answers id is required");
        QuestionnaireAnswers questionnaireAnswers = null;

        final String entityAlias = new StringBuilder().append(ENTITY_NAME_PREFIX).append(questionnaireDefinitionId).toString();

        final JPADynamicHelper helper = new JPADynamicHelper(entityManager);

        final DynamicType type = helper.getType(entityAlias);

        final DynamicEntity found = entityManager.find(type.getJavaClass(), id);
        if (found != null) {
            questionnaireAnswers = new QuestionnaireAnswers();
            questionnaireAnswers.setId(id);
            final List<String> propertyNames = type.getPropertiesNames();
            for (final String propertyName : propertyNames) {
                final Object value = found.get(propertyName);
                questionnaireAnswers.setAnswer(propertyName, value);
            }
        }
        return questionnaireAnswers;
    }

    @Override
    @Transactional
    public QuestionnaireAnswers save(final Integer questionnaireDefinitionId, final QuestionnaireAnswers questionnaireAnswers) {

        final String entityAlias = new StringBuilder().append(ENTITY_NAME_PREFIX).append(questionnaireDefinitionId).toString();

        final Map<String, Object> answers = questionnaireAnswers.getAnswers();
        final DynamicEntity entity = newInstance(entityAlias);
        if (!questionnaireAnswers.isNew()) {
            entity.set("id", questionnaireAnswers.getId());
        }
        for (final Map.Entry<String, Object> entry : answers.entrySet()) {
            final String questionCode = entry.getKey();
            final Object answer = entry.getValue();
            entity.set(questionCode, answer);
        }
        if (!questionnaireAnswers.isNew()) {
            entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
            questionnaireAnswers.setId((Integer) entity.get("id"));
        }
        return questionnaireAnswers;
    }

    private DynamicType buildDynamicType(final DynamicClassLoader dcl, final QuestionnaireDefinition questionnaireDefinition) {

        final String entityAlias = new StringBuilder().append(ENTITY_NAME_PREFIX).append(questionnaireDefinition.getId()).toString();

        final Class<?> dynamicClass = dcl.createDynamicClass(PACKAGE_PREFIX + entityAlias);

        final JPADynamicTypeBuilder builder = new JPADynamicTypeBuilder(dynamicClass, null, entityAlias);
        configure(builder, entityAlias, questionnaireDefinition.getId());
        return builder.getType();
    }

    private void configure(final JPADynamicTypeBuilder questionnaireAnswer, final String entityName, final Integer questionnaireDefinitionId) {
        questionnaireAnswer.addDirectMapping("id", Integer.class, "id");

        final List<Question> questions = questionRepository.findByQuestionnaireId(questionnaireDefinitionId);

        for (final Question question : questions) {
            processQuestion(questionnaireAnswer, question);
        }

        questionnaireAnswer.setPrimaryKeyFields("id");
        questionnaireAnswer.configureSequencing(entityName + "_seq", "id");

    }

    private DynamicEntity newInstance(final String entityAlias) {
        final JPADynamicHelper helper = new JPADynamicHelper(entityManager);
        final ClassDescriptor descriptor = helper.getSession().getDescriptorForAlias(entityAlias);
        Assert.notNull(descriptor, " Not found dynamic class descriptor for entity: " + entityAlias);
        return (DynamicEntity) descriptor.getInstantiationPolicy().buildNewInstance();
    }

    private void processQuestion(final JPADynamicTypeBuilder builder, final Question question) {
        Assert.notNull(question.getId(), String.format("Persist question first = {%s}", question));
        Assert.notNull(question.getType(), String.format("Not questionType for question = {%s}, ", question));

        final QuestionType questionType = question.getType();
        if (!questionType.hasSubquestions()) {
            if (questionType.hasMultipleAnswers()) {
                final String baseFieldName = new StringBuilder().append(question.getCode()).toString();
                final List<QuestionOption> questionOptions = question.getQuestionOptions();
                for (final QuestionOption questionOption : questionOptions) {
                    final String fieldName = new StringBuilder(baseFieldName).append("_").append(questionOption.getCode()).toString()
                            .toLowerCase(Locale.ENGLISH);
                    builder.addDirectMapping(fieldName, questionType.getAnswerType(), fieldName);
                }
            } else {
                final String fieldName = new StringBuilder().append(question.getCode().replace(".", "_")).toString().toLowerCase(Locale.ENGLISH);
                builder.addDirectMapping(fieldName, questionType.getAnswerType(), fieldName);
            }
        } else {
            final Question example = Question.with().parent(Question.with().id(question.getId()).build()).build();
            final List<Question> subquestions = questionRepository.findByExample(example, new SearchParameters());
            Assert.notEmpty(subquestions, String.format("Type %s requires subquestion", questionType));
            for (final Question subquestion : subquestions) {
                processQuestion(builder, subquestion);
            }
        }

    }
}
