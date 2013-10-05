package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.IdentifiableLocalizable;
import net.sf.gazpachosurvey.types.Language;

public class MailMessageTemplateDTO extends AbstractIdentifiableDTO implements IdentifiableLocalizable<MailMessageTemplateLanguageSettingsDTO>{

    private static final long serialVersionUID = -3689140734668685289L;

    private Language language;

    private String fromAddress;

    private String replyTo;

    private MailMessageTemplateLanguageSettingsDTO languageSettings;

    public MailMessageTemplateDTO() {
        super();
    }

    public Language getLanguage() {
        return language;
    }

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

    public MailMessageTemplateLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    public void setLanguageSettings(
            MailMessageTemplateLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static interface Builder {
        Builder id(Integer id);

        Builder languageSettings(
                MailMessageTemplateLanguageSettingsDTO languageSettings);

        Builder language(Language language);

        MailMessageTemplateLanguageSettingsDTO.Builder mailMessageTemplateLanguageSettingsStart();

        public Builder from(String from);

        public Builder replyTo(String replyTo);

        MailMessageTemplateDTO build();
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static class BuilderImpl implements Builder {
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

        public BuilderImpl from(String from) {
            this.from = from;
            return this;
        }

        public BuilderImpl replyTo(String replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        @Override
        public BuilderImpl languageSettings(
                MailMessageTemplateLanguageSettingsDTO languageSettings) {
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
            return mailMessageTemplateDTO;
        }

        @Override
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        @Override
        public MailMessageTemplateLanguageSettingsDTO.Builder mailMessageTemplateLanguageSettingsStart() {
            return MailMessageTemplateLanguageSettingsDTO
                    .mailMessageTemplateLanguageSettingsStart(this);
        }
    }

    @Override
    public String toString() {
        return "MailMessageTemplateDTO [language=" + language
                + ", fromAddress=" + fromAddress + ", replyTo=" + replyTo
                + ", languageSettings=" + languageSettings + "]";
    }

}
