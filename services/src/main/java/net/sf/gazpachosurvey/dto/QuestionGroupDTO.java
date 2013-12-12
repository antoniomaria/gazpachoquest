package net.sf.gazpachosurvey.dto;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.dto.support.AbstractAuditableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class QuestionGroupDTO extends AbstractAuditableDTO implements
        IdentifiableLocalizable<QuestionGroupLanguageSettingsDTO> {

    private static final long serialVersionUID = 4668205160387380803L;

    private Language language;

    private QuestionGroupLanguageSettingsDTO languageSettings;

    private List<QuestionDTO> questions;

    public QuestionGroupDTO() {
        super();
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public QuestionGroupLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(QuestionGroupLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public List<QuestionDTO> getQuestions() {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        return questions;
    }

    public void addQuestion(QuestionDTO question) {
        if (!getQuestions().contains(question)) {
            questions.add(question);
        }
    }

    public QuestionDTO getLastQuestionDTO() {
        int count = getQuestions().size();
        return count > 0 ? getQuestions().get(count - 1) : null;
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static interface Builder {

        Builder languageSettings(QuestionGroupLanguageSettingsDTO languageSettings);

        Builder language(Language language);

        QuestionGroupLanguageSettingsDTO.Builder pageLanguageSettingsStart();

        QuestionGroupDTO build();
    }

    public static class BuilderImpl implements Builder {
        private Language language;

        private QuestionGroupLanguageSettingsDTO languageSettings;

        @Override
        public BuilderImpl language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(QuestionGroupLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionGroupLanguageSettingsDTO.Builder pageLanguageSettingsStart() {
            return QuestionGroupLanguageSettingsDTO.pageLanguageSettingsStart(this);
        }

        @Override
        public QuestionGroupDTO build() {
            QuestionGroupDTO questionGroupDTO = new QuestionGroupDTO();
            questionGroupDTO.languageSettings = languageSettings;
            questionGroupDTO.language = language;
            return questionGroupDTO;
        }
    }
}
