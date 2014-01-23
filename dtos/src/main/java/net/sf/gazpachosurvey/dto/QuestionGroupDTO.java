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

    public void addQuestion(final QuestionDTO question) {
        if (!getQuestions().contains(question)) {
            questions.add(question);
        }
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public QuestionGroupLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public QuestionDTO getLastQuestionDTO() {
        int count = getQuestions().size();
        return count > 0 ? getQuestions().get(count - 1) : null;
    }

    public List<QuestionDTO> getQuestions() {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        return questions;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final QuestionGroupLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static interface Builder {

        QuestionGroupDTO build();

        Builder language(Language language);

        Builder languageSettings(QuestionGroupLanguageSettingsDTO languageSettings);

        QuestionGroupLanguageSettingsDTO.Builder pageLanguageSettingsStart();
    }

    public static class BuilderImpl implements Builder {
        private Language language;

        private QuestionGroupLanguageSettingsDTO languageSettings;

        @Override
        public QuestionGroupDTO build() {
            QuestionGroupDTO questionGroupDTO = new QuestionGroupDTO();
            questionGroupDTO.languageSettings = languageSettings;
            questionGroupDTO.language = language;
            return questionGroupDTO;
        }

        @Override
        public BuilderImpl language(final Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(final QuestionGroupLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public QuestionGroupLanguageSettingsDTO.Builder pageLanguageSettingsStart() {
            return QuestionGroupLanguageSettingsDTO.pageLanguageSettingsStart(this);
        }
    }

    public static Builder with() {
        return new BuilderImpl();
    }

}
