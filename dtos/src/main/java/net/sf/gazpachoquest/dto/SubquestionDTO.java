package net.sf.gazpachoquest.dto;

import java.util.List;

import net.sf.gazpachoquest.dto.support.AbstractQuestionDTO;
import net.sf.gazpachoquest.dto.support.LanguageSettingsContainerBuilder;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.QuestionType;

public class SubquestionDTO extends AbstractQuestionDTO {
    private static final long serialVersionUID = 2663159055152157679L;

    public SubquestionDTO() {
        super();
    }

    public static class BuilderImpl implements LanguageSettingsContainerBuilder<BuilderImpl> {
        private String code;
        private List<QuestionOptionDTO> answers;
        private Integer id;
        private boolean required;
        private Language language;
        private QuestionLanguageSettingsDTO languageSettings;
        private QuestionType type;

        public BuilderImpl answers(final List<QuestionOptionDTO> answers) {
            this.answers = answers;
            return this;
        }

        public SubquestionDTO build() {
            SubquestionDTO questionDTO = new SubquestionDTO();
            questionDTO.setId(id);
            questionDTO.code = code;
            questionDTO.required = required;
            questionDTO.type = type;
            questionDTO.language = language;
            questionDTO.questionOptions = answers;
            questionDTO.languageSettings = languageSettings;
            return questionDTO;
        }

        public BuilderImpl id(final Integer id) {
            this.id = id;
            return this;
        }

        public BuilderImpl required(final boolean required) {
            this.required = required;
            return this;
        }

        public BuilderImpl language(final Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(final QuestionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        public QuestionLanguageSettingsDTO.BuilderImpl<BuilderImpl> languageSettingsStart() {
            return new QuestionLanguageSettingsDTO.BuilderImpl<BuilderImpl>(this);
        }

        public BuilderImpl type(final QuestionType type) {
            this.type = type;
            return this;
        }

        public BuilderImpl code(String code) {
            this.code = code;
            return this;
        }
    }

    public static BuilderImpl with() {
        return new BuilderImpl();
    }

}
