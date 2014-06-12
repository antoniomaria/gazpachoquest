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

public class LabelDTO extends AbstractIdentifiableDTO implements IdentifiableLocalizable<LabelLanguageSettingsDTO> {

    private static final long serialVersionUID = 7715134426554617698L;

    private Language language;

    private LabelLanguageSettingsDTO languageSettings;

    public LabelDTO() {
        super();
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public LabelLanguageSettingsDTO getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final LabelLanguageSettingsDTO languageSettings) {
        this.languageSettings = languageSettings;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private Language language;
        private String title;

        public LabelDTO build() {
            LabelDTO labelDTO = new LabelDTO();
            labelDTO.language = language;
            labelDTO.languageSettings = new LabelLanguageSettingsDTO();
            labelDTO.languageSettings.setTitle(title);
            return labelDTO;
        }

        public Builder language(final Language language) {
            this.language = language;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }
    }
}
