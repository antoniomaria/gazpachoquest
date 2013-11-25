package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class QuestionLanguageSettingsDTO implements LanguageSettings {

    private static final long serialVersionUID = 7670525018631065390L;

    private String title;

    public QuestionLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Builder languageSettingsStart(QuestionDTO.Builder container) {
        return new QuestionLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    public static interface Builder {

        Builder title(String title);

        QuestionDTO.Builder languageSettingsEnd();

        QuestionLanguageSettingsDTO build();

    }

    public static class BuilderImpl implements Builder {

        private String title;

        private final QuestionDTO.Builder container;

        public BuilderImpl(QuestionDTO.Builder container) {
            this.container = container;
        }

        @Override
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        @Override
        public QuestionDTO.Builder languageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public QuestionLanguageSettingsDTO build() {
            QuestionLanguageSettingsDTO questionLanguageSettingsDTO = new QuestionLanguageSettingsDTO();
            questionLanguageSettingsDTO.title = title;
            return questionLanguageSettingsDTO;
        }
    }
}
