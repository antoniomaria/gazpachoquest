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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.gazpachoquest.dto.embeddables.QuestionnaireDefinitionLanguageSettingsDTO;
import net.sf.gazpachoquest.dto.support.AbstractAuditableDTO;
import net.sf.gazpachoquest.dto.support.IdentifiableLocalizable;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class QuestionnaireDefinitionDTO extends AbstractAuditableDTO implements
        IdentifiableLocalizable<QuestionnaireDefinitionLanguageSettingsDTO> {

    private static final long serialVersionUID = 4558625807621395019L;

    @ApiModelProperty(value = "Default language", required = true)
    private Language language;

    @ApiModelProperty(value = "Others languages supported", required = false)
    private final Set<Language> supportedLanguages = new HashSet<Language>();

    private QuestionnaireDefinitionLanguageSettingsDTO languageSettings;

    private final List<SectionDTO> sections = new ArrayList<>();

    private Boolean welcomeVisible;

    private Boolean progressVisible;

    private Boolean sectionInfoVisible;

    private Boolean questionNumberVisible;
    
    private RandomizationStrategy randomizationStrategy;

    private Integer questionsPerPage;

    private RenderingMode renderingMode;

    
    public QuestionnaireDefinitionDTO() {
        super();
    }

    public Set<Language> getSupportedLanguages() {
        return Collections.unmodifiableSet(supportedLanguages);
    }

    public void addSupportedLanguage(Language language) {
        supportedLanguages.add(language);
    }

    public void addSection(final SectionDTO section) {
        sections.add(section);
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public QuestionnaireDefinitionLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    @JsonIgnore
    public SectionDTO getLastSectionDTO() {
        int count = sections.size();
        return count > 0 ? sections.get(count - 1) : null;
    }

    public List<SectionDTO> getSections() {
        return Collections.unmodifiableList(sections);
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final QuestionnaireDefinitionLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setWelcomeVisible(Boolean welcomeVisible) {
        this.welcomeVisible = welcomeVisible;
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

    public Boolean isSectionInfoVisible() {
        return sectionInfoVisible;
    }

    public void setSectionInfoVisible(Boolean sectionInfoVisible) {
        this.sectionInfoVisible = sectionInfoVisible;
    }

    public Boolean isQuestionNumberVisible() {
        return questionNumberVisible;
    }

    public void setQuestionNumberVisible(Boolean questionNumberVisible) {
        this.questionNumberVisible = questionNumberVisible;
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

        Builder sectionInfoVisible(Boolean sectionInfoVisible);

        Builder questionNumberVisible(Boolean questionNumberVisible);
        
        Builder randomizationStrategy(RandomizationStrategy randomizationStrategy);
        
        Builder questionsPerPage(Integer questionsPerPage);

        Builder renderingMode(RenderingMode renderingMode);

        Builder languageSettings(QuestionnaireDefinitionLanguageSettingsDTO languageSettings);

        QuestionnaireDefinitionLanguageSettingsDTO.Builder questionnairLanguageSettingsStart();

    }

    public static class BuilderImpl implements Builder {
        private static final int DEFAULT_QUESTIONS_PER_PAGE = 1;

        private Integer id;

        private Language language;

        private QuestionnaireDefinitionLanguageSettingsDTO languageSettings;

        private Boolean welcomeVisible = Boolean.TRUE;

        private Boolean progressVisible = Boolean.TRUE;

        private Boolean sectionInfoVisible = Boolean.TRUE;

        private RandomizationStrategy randomizationStrategy = RandomizationStrategy.NONE;

        private Integer questionsPerPage;

        private RenderingMode renderingMode = RenderingMode.SECTION_BY_SECTION;
        
        private Boolean questionNumberVisible = Boolean.TRUE;

        @Override
        public QuestionnaireDefinitionDTO build() {
            QuestionnaireDefinitionDTO questionnaireDefinitionDTO = new QuestionnaireDefinitionDTO();
            questionnaireDefinitionDTO.setId(id);
            questionnaireDefinitionDTO.languageSettings = languageSettings;
            questionnaireDefinitionDTO.language = language;

            questionnaireDefinitionDTO.welcomeVisible = welcomeVisible;
            questionnaireDefinitionDTO.progressVisible = progressVisible;
            questionnaireDefinitionDTO.questionNumberVisible = questionNumberVisible;
            questionnaireDefinitionDTO.sectionInfoVisible = sectionInfoVisible;
            questionnaireDefinitionDTO.randomizationStrategy = randomizationStrategy;

            if (randomizationStrategy.equals(RandomizationStrategy.QUESTIONS_RANDOMIZATION) && questionsPerPage == null) {
                questionsPerPage = DEFAULT_QUESTIONS_PER_PAGE;
            }
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
        public Builder sectionInfoVisible(Boolean sectionInfoVisible) {
            this.sectionInfoVisible = sectionInfoVisible;
            return this;
        }
        
        @Override
        public Builder questionNumberVisible(Boolean questionNumberVisible) {
            this.questionNumberVisible = questionNumberVisible;
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

