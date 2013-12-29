package net.sf.gazpachosurvey.dto;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.dto.support.AbstractAuditableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

import org.springframework.util.Assert;

public class SurveyDTO extends AbstractAuditableDTO implements IdentifiableLocalizable<SurveyLanguageSettingsDTO> {

    public static interface Builder {
        SurveyDTO build();

        Builder id(Integer id);

        Builder language(Language language);

        Builder languageSettings(SurveyLanguageSettingsDTO languageSettings);

        SurveyLanguageSettingsDTO.Builder surveyLanguageSettingsStart();
    }

    public static class BuilderImpl implements Builder {
        private Integer id;

        private Language language;

        private SurveyLanguageSettingsDTO languageSettings;

        @Override
        public SurveyDTO build() {
            SurveyDTO surveyDTO = new SurveyDTO();
            surveyDTO.languageSettings = languageSettings;
            surveyDTO.language = language;
            surveyDTO.setId(id);
            return surveyDTO;
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
        public BuilderImpl languageSettings(final SurveyLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public SurveyLanguageSettingsDTO.Builder surveyLanguageSettingsStart() {
            return SurveyLanguageSettingsDTO.surveyLanguageSettingsStart(this);
        }
    }

    private static final long serialVersionUID = 4558625807621395019L;

    public static Builder with() {
        return new BuilderImpl();
    }

    private Language language;

    private SurveyLanguageSettingsDTO languageSettings;

    private List<QuestionGroupDTO> questionGroups;

    public SurveyDTO() {
        super();
    }

    public void addQuestionGroup(final QuestionGroupDTO questionGroup) {
        Assert.notNull(questionGroup, "Question Group must be not null");
        getQuestionGroups().add(questionGroup);
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public SurveyLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public QuestionGroupDTO getLastQuestionGroupDTO() {
        int count = getQuestionGroups().size();
        return count > 0 ? questionGroups.get(count - 1) : null;
    }

    public List<QuestionGroupDTO> getQuestionGroups() {
        if (questionGroups == null) {
            questionGroups = new ArrayList<>();
        }
        return questionGroups;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final SurveyLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setQuestionGroups(final List<QuestionGroupDTO> questionGroups) {
        this.questionGroups = questionGroups;
    }
}
