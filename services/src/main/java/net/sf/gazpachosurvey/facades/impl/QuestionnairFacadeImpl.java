package net.sf.gazpachosurvey.facades.impl;

import java.util.Set;

import net.sf.gazpachosurvey.domain.core.BrowsedElement;
import net.sf.gazpachosurvey.domain.core.BrowsedQuestionGroup;
import net.sf.gazpachosurvey.domain.core.QuestionGroup;
import net.sf.gazpachosurvey.domain.core.Respondent;
import net.sf.gazpachosurvey.domain.core.Survey;
import net.sf.gazpachosurvey.dto.QuestionGroupDTO;
import net.sf.gazpachosurvey.dto.QuestionnairDefinitionDTO;
import net.sf.gazpachosurvey.dto.QuestionnairPageDTO;
import net.sf.gazpachosurvey.dto.SurveyLanguageSettingsDTO;
import net.sf.gazpachosurvey.facades.QuestionnairFacade;
import net.sf.gazpachosurvey.services.BrowsedElementService;
import net.sf.gazpachosurvey.services.QuestionGroupService;
import net.sf.gazpachosurvey.services.SurveyService;
import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.RenderingMode;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionnairFacadeImpl implements QuestionnairFacade {

    private static final Integer INITIAL_POSITION = 0;

    private static final Logger logger = LoggerFactory.getLogger(QuestionnairFacadeImpl.class);

    @Autowired
    private BrowsedElementService browsedElementService;

    @Autowired
    private Mapper mapper;

    @Autowired
    private QuestionGroupService questionGroupService;

    @Autowired
    private SurveyService surveyService;

    @Override
    public QuestionnairPageDTO composeQuestionnairPage(final Respondent respondent, final RenderingMode mode,
            final BrowsingAction action, final Language language) {
        Survey survey = respondent.getSurveyInstance().getSurvey();
        int surveyId = survey.getId();
        int respondentId = respondent.getId();
        logger.debug("Composing ViewModel for respondent {} and surveyId = {}", respondentId, surveyId);
        BrowsedElement lastBrowsedElement = browsedElementService.findLast(respondentId);
        QuestionGroup questionGroup = null;
        if (RenderingMode.GROUP_BY_GROUP.equals(mode)) {
            if (lastBrowsedElement == null) { // First time entering the survey
                questionGroup = questionGroupService.findOneByPositionInSurvey(surveyId, INITIAL_POSITION);
                lastBrowsedElement = BrowsedQuestionGroup.with().respondent(respondent).questionGroup(questionGroup)
                        .last(Boolean.TRUE).build();
                browsedElementService.save(lastBrowsedElement);
            } else {
                switch (action) {
                case FORWARD:
                    BrowsedQuestionGroup next = (BrowsedQuestionGroup) browsedElementService.findNext(respondentId,
                            lastBrowsedElement.getCreatedDate());
                    if (next == null) {
                        Integer position = questionGroupService
                                .findPositionInSurvey(((BrowsedQuestionGroup) lastBrowsedElement).getQuestionGroup()
                                        .getId());
                        questionGroup = questionGroupService.findOneByPositionInSurvey(surveyId, position + 1);

                        lastBrowsedElement.setLast(Boolean.FALSE);
                        browsedElementService.save(lastBrowsedElement);

                        lastBrowsedElement = BrowsedQuestionGroup.with().respondent(respondent)
                                .questionGroup(questionGroup).last(Boolean.TRUE).build();
                        browsedElementService.save(lastBrowsedElement);
                    } else {
                        lastBrowsedElement.setLast(Boolean.FALSE);
                        browsedElementService.save(lastBrowsedElement);

                        next.setLast(Boolean.TRUE);
                        browsedElementService.save(next);
                        questionGroup = next.getQuestionGroup();
                    }
                    break;
                case BACKWARD:
                    BrowsedQuestionGroup previous = (BrowsedQuestionGroup) browsedElementService.findPrevious(
                            respondentId, lastBrowsedElement.getCreatedDate());

                    lastBrowsedElement.setLast(Boolean.FALSE);
                    browsedElementService.save(lastBrowsedElement);

                    previous.setLast(Boolean.TRUE);
                    browsedElementService.save(previous);

                    questionGroup = previous.getQuestionGroup();
                    break;
                default:
                    break;
                }
            }
        }
        QuestionGroupDTO questionGroupDTO = mapper.map(questionGroup, QuestionGroupDTO.class);
        return QuestionnairPageDTO.with().questionGroup(questionGroupDTO).build();
    }

    @Override
    public QuestionnairDefinitionDTO findQuestionnairDefinitionFor(final Respondent respondent) {
        Survey survey = respondent.getSurveyInstance().getSurvey();
        int surveyId = survey.getId();
        logger.debug("Respondent {} retriving QuestionnairDefinition for surveyId = {}", respondent.getId(), surveyId);

        Set<Language> translationsSupported = surveyService.translationsSupported(surveyId);

        SurveyLanguageSettingsDTO languageSettingsDTO = mapper.map(survey.getLanguageSettings(),
                SurveyLanguageSettingsDTO.class);
        QuestionnairDefinitionDTO definition = QuestionnairDefinitionDTO.with().languageSettings(languageSettingsDTO)
                .language(survey.getLanguage()).translationsSupported(translationsSupported).build();
        return definition;
    }

}
