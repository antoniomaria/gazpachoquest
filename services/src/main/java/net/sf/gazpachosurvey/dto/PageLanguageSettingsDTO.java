package net.sf.gazpachosurvey.dto;

public class PageLanguageSettingsDTO {

    private String title;

    public PageLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Builder pageLanguageSettingsStart(PageDTO.Builder container) {
        return new PageLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    public static interface Builder {

        Builder title(String title);

        PageDTO.Builder pageLanguageSettingsEnd();

        PageLanguageSettingsDTO build();

    }

    public static class BuilderImpl implements Builder {
        private String title;
        
        private final PageDTO.Builder container;

        public BuilderImpl(PageDTO.Builder container) {
            this.container = container;
        }

        @Override
        public BuilderImpl title(String title) {
            this.title = title;
            return this;
        }

        @Override
        public PageDTO.Builder pageLanguageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public PageLanguageSettingsDTO build() {
            PageLanguageSettingsDTO surveyLanguageSettingsDTO = new PageLanguageSettingsDTO();
            surveyLanguageSettingsDTO.title = title;
            return surveyLanguageSettingsDTO;
        }
    }
}
