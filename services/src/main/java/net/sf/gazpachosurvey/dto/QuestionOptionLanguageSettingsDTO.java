package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class QuestionOptionLanguageSettingsDTO implements LanguageSettings {

    private static final long serialVersionUID = 8942148329254332833L;

    private String title;

    public QuestionOptionLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static interface Builder {

        Builder title(String title);

        QuestionOptionLanguageSettingsDTO build();

    }

    public static class BuilderImpl implements Builder {

        private String title;

        @Override
        public BuilderImpl title(String title) {
            this.title = title;
            return this;
        }

        @Override
        public QuestionOptionLanguageSettingsDTO build() {
            QuestionOptionLanguageSettingsDTO surveyLanguageSettingsDTO = new QuestionOptionLanguageSettingsDTO();
            surveyLanguageSettingsDTO.title = title;
            return surveyLanguageSettingsDTO;
        }
    }
}
