/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.dto.support.LanguageSettingsDTO;

public class MailMessageTemplateLanguageSettingsDTO extends AbstractIdentifiableDTO implements LanguageSettingsDTO {

    public static interface Builder {

        Builder body(String body);

        MailMessageTemplateLanguageSettingsDTO build();

        MailMessageTemplateDTO.Builder mailMessageTemplateLanguageSettingsEnd();

        Builder subject(String subject);

    }

    public static class BuilderImpl implements Builder {
        private String body;
        private final MailMessageTemplateDTO.Builder container;
        private String subject;

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

    private String body;

    private String subject;

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
