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
package net.sf.gazpachoquest.dto.support;

import net.sf.gazpachoquest.types.Language;

@SuppressWarnings("serial")
public class TranslationDTO<L extends IdentifiableLocalizable<LSD>, LSD extends LanguageSettingsDTO> extends
        AbstractIdentifiableDTO implements IdentifiableLocalizable<LSD> {

    private Language language;

    private LSD languageSettings;

    private L translatedEntity;

    public TranslationDTO() {
        super();
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public LSD getLanguageSettings() {
        return languageSettings;
    }

    public L getTranslatedEntity() {
        return translatedEntity;
    }

    @Override
    public void setLanguage(final Language language) {
        this.language = language;
    }

    @Override
    public void setLanguageSettings(final LSD languageSettings) {
        this.languageSettings = languageSettings;
    }

    public void setTranslatedEntity(final L translatedEntity) {
        this.translatedEntity = translatedEntity;
    }

}
