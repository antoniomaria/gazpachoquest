package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class QuestionLanguageSettingsDTO implements LanguageSettings {

    public static interface Builder {

        QuestionLanguageSettingsDTO build();

        QuestionDTO.Builder languageSettingsEnd();

        Builder title(String title);

    }

    public static class BuilderImpl implements Builder {

        private final QuestionDTO.Builder container;

        private String title;

        public BuilderImpl(final QuestionDTO.Builder container) {
            this.container = container;
        }

        @Override
        public QuestionLanguageSettingsDTO build() {
            QuestionLanguageSettingsDTO questionLanguageSettingsDTO = new QuestionLanguageSettingsDTO();
            questionLanguageSettingsDTO.title = title;
            return questionLanguageSettingsDTO;
        }

        @Override
        public QuestionDTO.Builder languageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public Builder title(final String title) {
            this.title = title;
            return this;
        }
    }

    private static final long serialVersionUID = 7670525018631065390L;

    public static Builder languageSettingsStart(final QuestionDTO.Builder container) {
        return new QuestionLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    private String title;

    public QuestionLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
