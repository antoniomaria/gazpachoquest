package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

public class QuestionnairDefinitionLanguageSettingsDTO implements LanguageSettings {

    public static interface Builder {

        QuestionnairDefinitionLanguageSettingsDTO build();

        Builder description(String description);

        QuestionnairDefinitionDTO.Builder surveyLanguageSettingsEnd();

        Builder title(String title);

        Builder welcomeText(String welcomeText);

    }

    public static class BuilderImpl implements Builder {
        private final QuestionnairDefinitionDTO.Builder container;
        private String description;
        private String title;
        private String welcomeText;

        public BuilderImpl(final QuestionnairDefinitionDTO.Builder container) {
            this.container = container;
        }

        @Override
        public QuestionnairDefinitionLanguageSettingsDTO build() {
            QuestionnairDefinitionLanguageSettingsDTO questionnairDefinitionLanguageSettingsDTO = new QuestionnairDefinitionLanguageSettingsDTO();
            questionnairDefinitionLanguageSettingsDTO.title = title;
            questionnairDefinitionLanguageSettingsDTO.description = description;
            questionnairDefinitionLanguageSettingsDTO.welcomeText = welcomeText;
            return questionnairDefinitionLanguageSettingsDTO;
        }

        @Override
        public BuilderImpl description(final String description) {
            this.description = description;
            return this;
        }

        @Override
        public QuestionnairDefinitionDTO.Builder surveyLanguageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public BuilderImpl title(final String title) {
            this.title = title;
            return this;
        }

        @Override
        public BuilderImpl welcomeText(final String welcomeText) {
            this.welcomeText = welcomeText;
            return this;
        }
    }

    private static final long serialVersionUID = 3452734192681766764L;

    public static Builder surveyLanguageSettingsStart(final QuestionnairDefinitionDTO.Builder container) {
        return new QuestionnairDefinitionLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    private String description;

    private String title;

    private String welcomeText;

    public QuestionnairDefinitionLanguageSettingsDTO() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setWelcomeText(final String welcomeText) {
        this.welcomeText = welcomeText;
    }

    @Override
    public String toString() {
        return "QuestionnairDefinitionLanguageSettingsDTO [title=" + title + ", description=" + description + ", welcomeText="
                + welcomeText + "]";
    }

}
