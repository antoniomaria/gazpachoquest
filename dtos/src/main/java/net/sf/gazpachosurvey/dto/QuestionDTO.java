package net.sf.gazpachosurvey.dto;

import java.util.ArrayList;
import java.util.List;

import net.sf.gazpachosurvey.dto.support.AbstractQuestionDTO;
import net.sf.gazpachosurvey.dto.support.LanguageSettingsContainerBuilder;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.QuestionType;

public class QuestionDTO extends AbstractQuestionDTO {
    private static final long serialVersionUID = 2663159055152157679L;

    private List<SubquestionDTO> subquestions;

    public QuestionDTO() {
        super();
    }

    public void addSubquestion(final SubquestionDTO subQuestion) {
        if (!getSubquestions().contains(subQuestion)) {
            subquestions.add(subQuestion);
        }
    }

    public List<SubquestionDTO> getSubquestions() {
        if (subquestions == null) {
            subquestions = new ArrayList<SubquestionDTO>();
        }
        return subquestions;
    }

    public static class BuilderImpl implements LanguageSettingsContainerBuilder<BuilderImpl> {
        private String code;
        private List<QuestionOptionDTO> answers;
        private Integer id;
        private boolean isRequired;
        private Language language;
        private QuestionLanguageSettingsDTO languageSettings;
        private QuestionType type;

        public BuilderImpl answers(final List<QuestionOptionDTO> answers) {
            this.answers = answers;
            return this;
        }

        public QuestionDTO build() {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(id);
            questionDTO.code = code;
            questionDTO.isRequired = isRequired;
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

        public BuilderImpl isRequired(final boolean isRequired) {
            this.isRequired = isRequired;
            return this;
        }

        public BuilderImpl language(final Language language) {
            this.language = language;
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

        @Override
        public BuilderImpl languageSettings(QuestionLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

    }

    public static BuilderImpl with() {
        return new BuilderImpl();
    }

}
