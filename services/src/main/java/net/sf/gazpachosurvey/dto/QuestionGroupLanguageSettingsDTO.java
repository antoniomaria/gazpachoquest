package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class QuestionGroupLanguageSettingsDTO implements LanguageSettings {

    private static final long serialVersionUID = 8942148329254332833L;

    private String title;

    public QuestionGroupLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Builder pageLanguageSettingsStart(QuestionGroupDTO.Builder container) {
        return new QuestionGroupLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    public static interface Builder {

        Builder title(String title);

        QuestionGroupDTO.Builder pageLanguageSettingsEnd();

        QuestionGroupLanguageSettingsDTO build();

    }

    public static class BuilderImpl implements Builder {
        private String title;

        private final QuestionGroupDTO.Builder container;

        public BuilderImpl(QuestionGroupDTO.Builder container) {
            this.container = container;
        }

        @Override
        public BuilderImpl title(String title) {
            this.title = title;
            return this;
        }

        @Override
        public QuestionGroupDTO.Builder pageLanguageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public QuestionGroupLanguageSettingsDTO build() {
            QuestionGroupLanguageSettingsDTO surveyLanguageSettingsDTO = new QuestionGroupLanguageSettingsDTO();
            surveyLanguageSettingsDTO.title = title;
            return surveyLanguageSettingsDTO;
        }
    }
}
