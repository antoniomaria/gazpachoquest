package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class QuestionOptionLanguageSettingsDTO implements LanguageSettings {

    public static interface Builder {

        QuestionOptionLanguageSettingsDTO build();

        Builder title(String title);

    }

    public static class BuilderImpl implements Builder {

        private String title;

        @Override
        public QuestionOptionLanguageSettingsDTO build() {
            QuestionOptionLanguageSettingsDTO surveyLanguageSettingsDTO = new QuestionOptionLanguageSettingsDTO();
            surveyLanguageSettingsDTO.title = title;
            return surveyLanguageSettingsDTO;
        }

        @Override
        public BuilderImpl title(final String title) {
            this.title = title;
            return this;
        }
    }

    private static final long serialVersionUID = 8942148329254332833L;

    public static Builder with() {
        return new BuilderImpl();
    }

    private String title;

    public QuestionOptionLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }
}
