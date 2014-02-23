package net.sf.gazpachoquest.facades.impl;

import java.util.Set;

import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.dto.QuestionnairDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.answers.Answer;
import net.sf.gazpachoquest.dto.answers.SimpleAnswer;
import net.sf.gazpachoquest.facades.QuestionnairFacade;
import net.sf.gazpachoquest.questionnair.resolver.QuestionnairElementResolver;
import net.sf.gazpachoquest.questionnair.resolver.ResolverSelector;
import net.sf.gazpachoquest.questionnair.support.AnswersPopulator;
import net.sf.gazpachoquest.services.QuestionnairAnswersService;
import net.sf.gazpachoquest.services.QuestionnairDefinitionService;
import net.sf.gazpachoquest.services.QuestionnairService;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.RenderingMode;
import net.sf.gazpachosurvey.domain.core.Question;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Questionnair;
import net.sf.gazpachosurvey.domain.core.QuestionnairDefinition;
import net.sf.gazpachosurvey.domain.support.QuestionnairElement;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class QuestionnairFacadeImpl implements QuestionnairFacade {

    @Autowired
    private ResolverSelector resolverSelector;

    @Autowired
    private QuestionnairService questionnairService;

    @Autowired
    private QuestionnairDefinitionService questionnairDefinitionService;

    @Autowired
    private QuestionnairAnswersService questionnairAnswersService;

    @Autowired
    private AnswersPopulator answersPopulator;

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

    @Transactional
    @Override
    public PageDTO resolvePage(Integer questionnairId, RenderingMode mode, BrowsingAction action) {
        Questionnair questionnair = questionnairService.findOne(questionnairId);
        QuestionnairElementResolver resolver = resolverSelector.selectBy(mode);
        QuestionnairElement questionnairElement = resolver.resolveFor(questionnair, action);
        PageDTO page = new PageDTO();
        if (questionnairElement == null) { // TODO Handle exception
            return page;
        }
        if (questionnairElement instanceof QuestionGroup) {
            QuestionGroup questionGroup = (QuestionGroup) questionnairElement;

            for (Question question : questionGroup.getQuestions()) {
                QuestionDTO questionDTO = mapper.map(question, QuestionDTO.class);
                page.addQuestion(questionDTO);
            }
        } else {
            Question question = (Question) questionnairElement;
            QuestionDTO questionDTO = mapper.map(question, QuestionDTO.class);
            page.addQuestion(questionDTO);
        }
        answersPopulator.populate(questionnair, page.getQuestions());
        return page;
    }

    @Override
    public void saveAnswer(Integer questionnairId, String questionCode, Answer answer) {
        Questionnair questionnair = Questionnair.with().id(questionnairId).build();
        if (answer instanceof SimpleAnswer) {
            questionnairAnswersService.save(questionnair, questionCode, answer.getValue());
        }
    }
}
