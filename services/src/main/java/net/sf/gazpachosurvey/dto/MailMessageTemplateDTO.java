package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;
import net.sf.gazpachosurvey.types.MailMessageTemplateType;

public class MailMessageTemplateDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<MailMessageTemplateLanguageSettingsDTO> {

    public static interface Builder {

        public Builder fromAddress(String from);

        public Builder replyTo(String replyTo);

        public Builder survey(SurveyDTO survey);

        public Builder type(MailMessageTemplateType type);

        MailMessageTemplateDTO build();

        Builder id(Integer id);

        Builder language(Language language);

        Builder languageSettings(MailMessageTemplateLanguageSettingsDTO languageSettings);

        MailMessageTemplateLanguageSettingsDTO.Builder mailMessageTemplateLanguageSettingsStart();
    }

    public static class BuilderImpl implements Builder {
        private String from;
        private Integer id;
        private Language language;
        private MailMessageTemplateLanguageSettingsDTO languageSettings;
        private String replyTo;
        private SurveyDTO survey;
        private MailMessageTemplateType type;

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
        public BuilderImpl fromAddress(final String from) {
            this.from = from;
            return this;
        }

        @Override
        public Builder id(final Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public BuilderImpl language(final Language language) {
            this.language = language;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(final MailMessageTemplateLanguageSettingsDTO languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public MailMessageTemplateLanguageSettingsDTO.Builder mailMessageTemplateLanguageSettingsStart() {
            return MailMessageTemplateLanguageSettingsDTO.mailMessageTemplateLanguageSettingsStart(this);
        }

        @Override
        public BuilderImpl replyTo(final String replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        @Override
        public Builder survey(final SurveyDTO survey) {
            this.survey = survey;
            return this;
        }

        @Override
        public Builder type(final MailMessageTemplateType type) {
            this.type = type;
            return this;
        }
    }

    private static final long serialVersionUID = -3689140734668685289L;

    public static Builder with() {
        return new BuilderImpl();
    }

    private String fromAddress;

    private Language language;

    private MailMessageTemplateLanguageSettingsDTO languageSettings;

    private String replyTo;

    private SurveyDTO survey;

    private MailMessageTemplateType type;

    public MailMessageTemplateDTO() {
        super();
    }

    public String getFromAddress() {
        return fromAddress;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public MailMessageTemplateLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public SurveyDTO getSurvey() {
        return survey;
    }

    public MailMessageTemplateType getType() {
        return type;
    }

    public void setFromAddress(final String from) {
        fromAddress = from;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final MailMessageTemplateLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setReplyTo(final String replyTo) {
        this.replyTo = replyTo;
    }

    public void setSurvey(final SurveyDTO survey) {
        this.survey = survey;
    }

    public void setType(final MailMessageTemplateType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MailMessageTemplateDTO [language=" + language + ", fromAddress=" + fromAddress + ", replyTo=" + replyTo
                + ", languageSettings=" + languageSettings + "]";
    }

}
