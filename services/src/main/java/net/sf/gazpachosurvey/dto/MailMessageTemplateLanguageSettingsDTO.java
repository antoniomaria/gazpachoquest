package net.sf.gazpachosurvey.dto;

public class MailMessageTemplateLanguageSettingsDTO extends AbstractIdentifiableDTO<Integer> {

    private static final long serialVersionUID = -4959980255392017094L;

    private String subject;

    private String body;

    public MailMessageTemplateLanguageSettingsDTO() {
        super();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static interface Builder {

        Builder subject(String subject);

        Builder body(String body);

        MailMessageTemplateDTO.Builder mailMessageTemplateLanguageSettingsEnd();

        MailMessageTemplateLanguageSettingsDTO build();

    }

    public static Builder mailMessageTemplateLanguageSettingsStart(MailMessageTemplateDTO.Builder container) {
        return new MailMessageTemplateLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    public static class BuilderImpl implements Builder {
        private String subject;
        private String body;
        private final MailMessageTemplateDTO.Builder container;

        public BuilderImpl(MailMessageTemplateDTO.Builder container) {
            this.container = container;
        }

        @Override
        public BuilderImpl subject(String subject) {
            this.subject = subject;
            return this;
        }

        @Override
        public BuilderImpl body(String body) {
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
    }
}
