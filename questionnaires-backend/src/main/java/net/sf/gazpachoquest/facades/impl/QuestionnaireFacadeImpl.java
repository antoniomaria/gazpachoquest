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
package net.sf.gazpachoquest.facades.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.Questionnaire;
import net.sf.gazpachoquest.domain.core.QuestionnaireDefinition;
import net.sf.gazpachoquest.dto.PageMetadataDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionGroupDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDTO;
import net.sf.gazpachoquest.dto.QuestionnaireDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.QuestionnairePageDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.BooleanAnswer;
import net.sf.gazpachoquest.dto.answers.SimpleAnswer;
import net.sf.gazpachoquest.facades.QuestionnaireFacade;
import net.sf.gazpachoquest.questionnair.resolver.PageResolver;
import net.sf.gazpachoquest.questionnair.resolver.ResolverSelector;
import net.sf.gazpachoquest.questionnair.support.AnswersPopulator;
import net.sf.gazpachoquest.questionnair.support.PageMetadataCreator;
import net.sf.gazpachoquest.questionnair.support.PageMetadataStructure;
import net.sf.gazpachoquest.questionnair.support.PageStructure;
import net.sf.gazpachoquest.services.QuestionGroupService;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnaireAnswersService;
import net.sf.gazpachoquest.services.QuestionnaireDefinitionService;
import net.sf.gazpachoquest.services.QuestionnaireService;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.NavigationAction;
import net.sf.gazpachoquest.types.RenderingMode;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class QuestionnaireFacadeImpl implements QuestionnaireFacade {

    private static Logger logger = LoggerFactory.getLogger(QuestionnaireFacadeImpl.class);

    @Autowired
    private ResolverSelector resolverSelector;

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionGroupService questionGroupService;

    @Autowired
    private QuestionnaireDefinitionService questionnaireDefinitionService;

    @Autowired
    private QuestionnaireAnswersService questionnaireAnswersService;

    @Autowired
    private AnswersPopulator answersPopulator;

    @Autowired
    private PageMetadataCreator metadataCreator;

    @Autowired
    private Mapper mapper;

    public QuestionnaireFacadeImpl() {
        super();
    }

    @Transactional(readOnly = true)
    @Override
    public QuestionnaireDTO findOne(Integer questionnaireId) {
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        QuestionnaireDefinition definition = questionnaire.getQuestionnairDefinition();
        QuestionnaireDefinitionLanguageSettingsDTO languageSettings = mapper.map(definition.getLanguageSettings(),
                QuestionnaireDefinitionLanguageSettingsDTO.class);

        Set<Language> translations = questionnaireDefinitionService.translationsSupported(definition.getId());

        QuestionnaireDTO questionnaireDTO = QuestionnaireDTO.with().language(definition.getLanguage())
                .languageSettings(languageSettings).id(questionnaireId).progressVisible(definition.isProgressVisible())
                .questionGroupInfoVisible(definition.isQuestionGroupInfoVisible())
                .welcomeVisible(definition.isWelcomeVisible()).build();
        for (Language language : translations) {
            questionnaireDTO.addSupportedLanguage(language);
        }
        questionnaireDTO.addSupportedLanguage(definition.getLanguage());

        return questionnaireDTO;
    }

    @Override
    public QuestionnairePageDTO resolvePage(Integer questionnaireId, RenderingMode mode, Language preferredLanguage,
            NavigationAction action) {
        Questionnaire questionnaire = questionnaireService.findOne(questionnaireId);
        if (mode == null) {
            mode = questionnaire.getQuestionnairDefinition().getRenderingMode();
        }
        PageResolver resolver = resolverSelector.selectBy(mode);
        logger.info("Requesting page {} for questionnaireId = {} in language {} using renderingMode = {}",
                action.toString(), questionnaireId, preferredLanguage, mode);

        PageStructure pageStructure = resolver.resolveNextPage(questionnaire, action);
        QuestionnairePageDTO page = new QuestionnairePageDTO();
        if (pageStructure == null) { // TODO Handle exception
            return page;
        }
        List<QuestionGroup> questionGroups = pageStructure.getQuestionGroups();
        List<QuestionDTO> allVisibleQuestions = new ArrayList<>();
        for (QuestionGroup questionGroup : questionGroups) {
            List<Integer> questionIds = questionGroup.getQuestionsId();
            List<Question> questions = questionService.findInList(questionIds, preferredLanguage);
            QuestionGroup localizedQuestionGroup = QuestionGroup.with().build();
            if (pageStructure.isQuestionGroupInfoAvailable()) {
                localizedQuestionGroup = questionGroupService.findOne(questionGroup.getId(), preferredLanguage);
            }
            QuestionGroupDTO questionGroupDTO = mapper.map(localizedQuestionGroup, QuestionGroupDTO.class);
            page.addQuestionGroup(questionGroupDTO);
            for (Question question : questions) {
                QuestionDTO questionDTO = mapper.map(question, QuestionDTO.class);
                questionGroupDTO.addQuestion(questionDTO);
                allVisibleQuestions.add(questionDTO);
            }
        }
        answersPopulator.populate(questionnaire, allVisibleQuestions);
        PageMetadataStructure metadata = pageStructure.getMetadata();
        page.setMetadata(mapper.map(metadata, PageMetadataDTO.class));
        page.setQuestionGroupInfoAvailable(pageStructure.isQuestionGroupInfoAvailable());

        logger.info("Returning page {} of {} for questionnaireId = {}", metadata.getNumber(), metadata.getCount(),
                questionnaireId);
        return page;
    }

    @Override
    public void saveAnswer(Integer questionnaireId, String questionCode, Answer answer) {
        Questionnaire questionnaire = Questionnaire.with().id(questionnaireId).build();
        if (!(answer instanceof SimpleAnswer)) {
            logger.warn("Answer {} not supported", answer);
            return;
        }
        String sufix = "";
        if (answer instanceof BooleanAnswer) {
            sufix = "_" + ((BooleanAnswer) answer).getOption();
        }
        questionnaireAnswersService.save(questionnaire, questionCode + sufix, answer.getValue());
    }
}
