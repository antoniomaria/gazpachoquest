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
package net.sf.gazpachoquest.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.gazpachoquest.dto.support.AbstractAuditableDTO;
import net.sf.gazpachoquest.dto.support.IdentifiableLocalizable;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

public class QuestionnaireDefinitionDTO extends AbstractAuditableDTO implements
        IdentifiableLocalizable<QuestionnaireDefinitionLanguageSettingsDTO> {

    private static final long serialVersionUID = 4558625807621395019L;

    private Language language;

    private QuestionnaireDefinitionLanguageSettingsDTO languageSettings;

    private final List<QuestionGroupDTO> questionGroups = new ArrayList<>();

    private Boolean welcomeVisible;

    private Boolean progressVisible;

    private Boolean questionGroupInfoVisible;

    private RandomizationStrategy randomizationStrategy;

    private Integer questionsPerPage;

    private RenderingMode renderingMode;

    public QuestionnaireDefinitionDTO() {
        super();
    }

    public void addQuestionGroup(final QuestionGroupDTO questionGroup) {
        questionGroups.add(questionGroup);
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public QuestionnaireDefinitionLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public QuestionGroupDTO getLastQuestionGroupDTO() {
        int count = questionGroups.size();
        return count > 0 ? questionGroups.get(count - 1) : null;
    }

    public List<QuestionGroupDTO> getQuestionGroups() {
        return Collections.unmodifiableList(questionGroups);
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final QuestionnaireDefinitionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public Boolean getWelcomeVisible() {
        return welcomeVisible;
    }

    public void isWelcomeVisible(Boolean welcomeVisible) {
        this.welcomeVisible = welcomeVisible;
    }

    public Boolean isProgressVisible() {
        return progressVisible;
    }

    public void setProgressVisible(Boolean progressVisible) {
        this.progressVisible = progressVisible;
    }

    public Boolean isQuestionGroupInfoVisible() {
        return questionGroupInfoVisible;
    }

    public void isQuestionGroupInfoVisible(Boolean questionGroupInfoVisible) {
        this.questionGroupInfoVisible = questionGroupInfoVisible;
    }

    public RandomizationStrategy getRandomizationStrategy() {
        return randomizationStrategy;
    }

    public void setRandomizationStrategy(RandomizationStrategy randomizationStrategy) {
        this.randomizationStrategy = randomizationStrategy;
    }

    public Integer getQuestionsPerPage() {
        return questionsPerPage;
    }

    public void setQuestionsPerPage(Integer questionsPerPage) {
        this.questionsPerPage = questionsPerPage;
    }

    public RenderingMode getRenderingMode() {
        return renderingMode;
    }

    public void setRenderingMode(RenderingMode renderingMode) {
        this.renderingMode = renderingMode;
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static interface Builder {
        QuestionnaireDefinitionDTO build();

        Builder id(Integer id);

        Builder language(Language language);

        Builder welcomeVisible(Boolean welcomeVisible);

        Builder progressVisible(Boolean progressVisible);

        Builder questionGroupInfoVisible(Boolean questionGroupInfoVisible);

        Builder randomizationStrategy(RandomizationStrategy randomizationStrategy);

        Builder questionsPerPage(Integer questionsPerPage);

        Builder renderingMode(RenderingMode renderingMode);

        Builder languageSettings(QuestionnaireDefinitionLanguageSettingsDTO languageSettings);

        QuestionnaireDefinitionLanguageSettingsDTO.Builder questionnairLanguageSettingsStart();
    }

    public static class BuilderImpl implements Builder {
        private Integer id;

        private Language language;

        private QuestionnaireDefinitionLanguageSettingsDTO languageSettings;

        private Boolean welcomeVisible;

        private Boolean progressVisible;

        private Boolean questionGroupInfoVisible;

        private RandomizationStrategy randomizationStrategy;

        private Integer questionsPerPage;

        private RenderingMode renderingMode;

        @Override
        public QuestionnaireDefinitionDTO build() {
            QuestionnaireDefinitionDTO questionnaireDefinitionDTO = new QuestionnaireDefinitionDTO();
            questionnaireDefinitionDTO.setId(id);
            questionnaireDefinitionDTO.languageSettings = languageSettings;
            questionnaireDefinitionDTO.language = language;

            questionnaireDefinitionDTO.welcomeVisible = welcomeVisible;
            questionnaireDefinitionDTO.progressVisible = progressVisible;
            questionnaireDefinitionDTO.questionGroupInfoVisible = questionGroupInfoVisible;
            questionnaireDefinitionDTO.randomizationStrategy = randomizationStrategy;
            questionnaireDefinitionDTO.questionsPerPage = questionsPerPage;
            questionnaireDefinitionDTO.renderingMode = renderingMode;
            return questionnaireDefinitionDTO;
        }

        @Override
        public Builder id(final Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public BuilderImpl language(final Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(final QuestionnaireDefinitionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionnaireDefinitionLanguageSettingsDTO.Builder questionnairLanguageSettingsStart() {
            return QuestionnaireDefinitionLanguageSettingsDTO.surveyLanguageSettingsStart(this);
        }

        @Override
        public Builder welcomeVisible(Boolean welcomeVisible) {
            this.welcomeVisible = welcomeVisible;
            return this;
        }

        @Override
        public Builder progressVisible(Boolean progressVisible) {
            this.progressVisible = progressVisible;
            return this;
        }

        @Override
        public Builder questionGroupInfoVisible(Boolean questionGroupInfoVisible) {
            this.questionGroupInfoVisible = questionGroupInfoVisible;
            return this;
        }

        @Override
        public Builder randomizationStrategy(RandomizationStrategy randomizationStrategy) {
            this.randomizationStrategy = randomizationStrategy;
            return this;
        }

        @Override
        public Builder questionsPerPage(Integer questionsPerPage) {
            this.questionsPerPage = questionsPerPage;
            return this;
        }

        @Override
        public Builder renderingMode(RenderingMode renderingMode) {
            this.renderingMode = renderingMode;
            return this;
        }
    }

}
