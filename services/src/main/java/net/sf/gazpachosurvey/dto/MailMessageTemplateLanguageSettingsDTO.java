package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;
import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;

public class MailMessageTemplateLanguageSettingsDTO extends AbstractIdentifiableDTO implements LanguageSettings {

    public static interface Builder {

        Builder body(String body);

        MailMessageTemplateLanguageSettingsDTO build();

        MailMessageTemplateDTO.Builder mailMessageTemplateLanguageSettingsEnd();

        Builder subject(String subject);

    }

    public static class BuilderImpl implements Builder {
        private String subject;
        private String body;
        private final MailMessageTemplateDTO.Builder container;

        public BuilderImpl(final MailMessageTemplateDTO.Builder container) {
            this.container = container;
        }

        @Override
        public BuilderImpl body(final String body) {
            this.body = body;
            return this;
        }

        @Override
        public MailMessageTemplateLanguageSettingsDTO build() {
            MailMessageTemplateLanguageSettingsDTO mailMessageTemplateLanguageSettingsDTO = new MailMessageTemplateLanguageSettingsDTO();
            mailMessageTemplateLanguageSettingsDTO.subject = subject;
            mailMessageTemplateLanguageSettingsDTO.body = body;
            return mailMessageTemplateLanguageSettingsDTO;
        }

        @Override
        public MailMessageTemplateDTO.Builder mailMessageTemplateLanguageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public BuilderImpl subject(final String subject) {
            this.subject = subject;
            return this;
        }
    }

    private static final long serialVersionUID = -4959980255392017094L;

    public static Builder mailMessageTemplateLanguageSettingsStart(final MailMessageTemplateDTO.Builder container) {
        return new MailMessageTemplateLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    private String subject;

    private String body;

    public MailMessageTemplateLanguageSettingsDTO() {
        super();
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "MailMessageTemplateLanguageSettingsDTO [subject=" + subject + ", body=" + body + "]";
    }

}
