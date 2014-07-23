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

import java.util.List;
import java.util.Set;

import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.Questionnair;
import net.sf.gazpachoquest.domain.core.QuestionnairDefinition;
import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.PageMetadataDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.BooleanAnswer;
import net.sf.gazpachoquest.dto.answers.SimpleAnswer;
import net.sf.gazpachoquest.facades.QuestionnairFacade;
import net.sf.gazpachoquest.questionnair.resolver.PageResolver;
import net.sf.gazpachoquest.questionnair.resolver.ResolverSelector;
import net.sf.gazpachoquest.questionnair.support.AnswersPopulator;
import net.sf.gazpachoquest.questionnair.support.PageMetadataCreator;
import net.sf.gazpachoquest.questionnair.support.PageMetadataStructure;
import net.sf.gazpachoquest.questionnair.support.PageStructure;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnairAnswersService;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;
import net.sf.gazpachoquest.services.QuestionnairService;
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
public class QuestionnairFacadeImpl implements QuestionnairFacade {

    private static Logger logger = LoggerFactory.getLogger(QuestionnairFacadeImpl.class);

    @Autowired
    private ResolverSelector resolverSelector;

    @Autowired
    private QuestionnairService questionnairService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Autowired
    private QuestionnairAnswersService questionnairAnswersService;

    @Autowired
    private AnswersPopulator answersPopulator;

    @Autowired
    private PageMetadataCreator metadataCreator;

    @Autowired
    private Mapper mapper;

    public QuestionnairFacadeImpl() {
        super();
    }

    @Transactional(readOnly = true)
    @Override
    public QuestionnairDTO findOne(Integer questionnairId) {
        QuestionnairDTO questionnairDTO = new QuestionnairDTO();

        Questionnair questionnair = questionnairService.findOne(questionnairId);
        QuestionnairDefinition definition = questionnair.getQuestionnairDefinition();
        Set<Language> translations = questionnairDefinitionService.translationsSupported(definition.getId());
        for (Language language : translations) {
            questionnairDTO.addSupportedLanguage(language);
        }
        questionnairDTO.addSupportedLanguage(definition.getLanguage());
        questionnairDTO.setLanguage(definition.getLanguage());
        QuestionnairDefinitionLanguageSettingsDTO languageSettings = mapper.map(definition.getLanguageSettings(),
                QuestionnairDefinitionLanguageSettingsDTO.class);
        questionnairDTO.setLanguageSettings(languageSettings);
        questionnairDTO.setId(questionnairId);
        return questionnairDTO;
    }

    @Override
    public PageDTO resolvePage(Integer questionnairId, RenderingMode mode, Language preferredLanguage,
            NavigationAction action) {
        Questionnair questionnair = Questionnair.with().id(questionnairId).build();
        PageResolver resolver = resolverSelector.selectBy(mode);
        PageStructure pageStructure = resolver.resolveNextPage(questionnair, action);
        PageDTO page = new PageDTO();
        if (pageStructure == null) { // TODO Handle exception
            return page;
        }
        List<Integer> questionIds = pageStructure.getQuestionsId();

        // List<Question> questions = questionService.findInList(questionIds);
        List<Question> questions = questionService.findInList(questionIds, preferredLanguage);
        for (Question question : questions) {
            QuestionDTO questionDTO = mapper.map(question, QuestionDTO.class);
            page.addQuestion(questionDTO);
        }

        answersPopulator.populate(questionnair, page.getQuestions());
        PageMetadataStructure metadata = pageStructure.getMetadata();
        logger.info("Returning page {} of {} for questionnairId = {}", metadata.getNumber(), metadata.getCount(),
                questionnairId);
        page.setMetadata(mapper.map(metadata, PageMetadataDTO.class));
        return page;
    }

    @Override
    public void saveAnswer(Integer questionnairId, String questionCode, Answer answer) {
        Questionnair questionnair = Questionnair.with().id(questionnairId).build();
        if (!(answer instanceof SimpleAnswer)) {
            logger.warn("Answer {} not supported", answer);
            return;
        }
        String sufix = "";
        if (answer instanceof BooleanAnswer) {
            sufix = "_" + ((BooleanAnswer) answer).getOption();
        }
        questionnairAnswersService.save(questionnair, questionCode + sufix, answer.getValue());
    }
}
