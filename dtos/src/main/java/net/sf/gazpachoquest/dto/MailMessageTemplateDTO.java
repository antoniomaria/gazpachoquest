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
import net.sf.gazpachoquest.dto.support.IdentifiableLocalizable;
import net.sf.gazpachoquest.types.Language;
import net.sf.gazpachoquest.types.MailMessageTemplateType;

public class MailMessageTemplateDTO extends AbstractIdentifiableDTO implements
        IdentifiableLocalizable<MailMessageTemplateLanguageSettingsDTO> {

    private static final long serialVersionUID = -3689140734668685289L;

    private String fromAddress;

    private Language language;

    private MailMessageTemplateLanguageSettingsDTO languageSettings;

    private String replyTo;

    private QuestionnairDefinitionDTO questionnairDefinition;

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

    public QuestionnairDefinitionDTO getQuestionnairDefinition() {
        return questionnairDefinition;
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

    public void setQuestionnairDefinition(final QuestionnairDefinitionDTO survey) {
        this.questionnairDefinition = survey;
    }

    public void setType(final MailMessageTemplateType type) {
        this.type = type;
    }

    public static Builder with() {
        return new BuilderImpl();
    }

    public static interface Builder {

        public Builder fromAddress(String from);

        public Builder replyTo(String replyTo);

        public Builder questionnairDefinition(QuestionnairDefinitionDTO survey);

        public Builder type(MailMessageTemplateType type);

        MailMessageTemplateDTO build();

        Builder id(Integer id);

        Builder language(Language language);

        Builder languageSettings(MailMessageTemplateLanguageSettingsDTO languageSettings);

        MailMessageTemplateLanguageSettingsDTO.Builder mailMessageTemplateLanguageSettingsStart();
    }

    @Override
    public String toString() {
        return "MailMessageTemplateDTO [language=" + language + ", fromAddress=" + fromAddress + ", replyTo=" + replyTo
                + ", languageSettings=" + languageSettings + "]";
    }

    public static class BuilderImpl implements Builder {
        private String from;
        private Integer id;
        private Language language;
        private MailMessageTemplateLanguageSettingsDTO languageSettings;
        private String replyTo;
        private QuestionnairDefinitionDTO questionnairDefinition;
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
            mailMessageTemplateDTO.questionnairDefinition = questionnairDefinition;
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
        public Builder questionnairDefinition(final QuestionnairDefinitionDTO survey) {
            this.questionnairDefinition = survey;
            return this;
        }

        @Override
        public Builder type(final MailMessageTemplateType type) {
            this.type = type;
            return this;
        }
    }

}
