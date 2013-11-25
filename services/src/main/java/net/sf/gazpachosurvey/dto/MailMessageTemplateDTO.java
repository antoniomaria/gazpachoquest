package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.MailMessageTemplateType;

public class MailMessageTemplateDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<MailMessageTemplateLanguageSettingsDTO> {

    private static final long serialVersionUID = -3689140734668685289L;

    private SurveyDTO survey;

    private MailMessageTemplateType type;

    private Language language;

    private String fromAddress;

    private String replyTo;

    private MailMessageTemplateLanguageSettingsDTO languageSettings;

    public MailMessageTemplateDTO() {
        super();
    }

    public SurveyDTO getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyDTO survey) {
        this.survey = survey;
    }

    public MailMessageTemplateType getType() {
        return type;
    }

    public void setType(MailMessageTemplateType type) {
        this.type = type;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String from) {
        fromAddress = from;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    @Override
    public MailMessageTemplateLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(MailMessageTemplateLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static interface Builder {

        Builder id(Integer id);

        Builder languageSettings(MailMessageTemplateLanguageSettingsDTO languageSettings);

        Builder language(Language language);

        MailMessageTemplateLanguageSettingsDTO.Builder mailMessageTemplateLanguageSettingsStart();

        public Builder from(String from);

        public Builder replyTo(String replyTo);

        public Builder survey(SurveyDTO survey);

        public Builder type(MailMessageTemplateType type);

        MailMessageTemplateDTO build();
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static class BuilderImpl implements Builder {
        private SurveyDTO survey;
        private MailMessageTemplateType type;
        private Integer id;
        private Language language;
        private String from;
        private String replyTo;
        private MailMessageTemplateLanguageSettingsDTO languageSettings;

        @Override
        public BuilderImpl language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl from(String from) {
            this.from = from;
            return this;
        }

        @Override
        public BuilderImpl replyTo(String replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(MailMessageTemplateLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public MailMessageTemplateDTO build() {
            MailMessageTemplateDTO mailMessageTemplateDTO = new MailMessageTemplateDTO();
            mailMessageTemplateDTO.setId(id);
            mailMessageTemplateDTO.language = language;
            mailMessageTemplateDTO.fromAddress = from;
            mailMessageTemplateDTO.replyTo = replyTo;
            mailMessageTemplateDTO.languageSettings = languageSettings;
            mailMessageTemplateDTO.type = type;
            mailMessageTemplateDTO.survey = survey;
            return mailMessageTemplateDTO;
        }

        @Override
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public MailMessageTemplateLanguageSettingsDTO.Builder mailMessageTemplateLanguageSettingsStart() {
            return MailMessageTemplateLanguageSettingsDTO.mailMessageTemplateLanguageSettingsStart(this);
        }

        @Override
        public Builder survey(SurveyDTO survey) {
            this.survey = survey;
            return this;
        }

        @Override
        public Builder type(MailMessageTemplateType type) {
            this.type = type;
            return this;
        }
    }

    @Override
    public String toString() {
        return "MailMessageTemplateDTO [language=" + language + ", fromAddress=" + fromAddress + ", replyTo=" + replyTo
                + ", languageSettings=" + languageSettings + "]";
    }

}
