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

import net.sf.gazpachoquest.dto.support.LanguageSettingsDTO;

public class SectionLanguageSettingsDTO implements LanguageSettingsDTO {

    private static final long serialVersionUID = 8942148329254332833L;

    private String title;

    private String description;

    public SectionLanguageSettingsDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Builder pageLanguageSettingsStart(final SectionDTO.Builder container) {
        return new SectionLanguageSettingsDTO.BuilderImpl(container);
    }

    public static Builder with() {
        return new BuilderImpl(null);
    }

    public static interface Builder {

        SectionLanguageSettingsDTO build();

        SectionDTO.Builder pageLanguageSettingsEnd();

        Builder title(String title);

        Builder description(String description);
    }

    public static class BuilderImpl implements Builder {
        private final SectionDTO.Builder container;

        private String title;

        private String description;

        public BuilderImpl(final SectionDTO.Builder container) {
            this.container = container;
        }

        @Override
        public SectionLanguageSettingsDTO build() {
            SectionLanguageSettingsDTO sectionLanguageSettingsDTO = new SectionLanguageSettingsDTO();
            sectionLanguageSettingsDTO.title = title;
            sectionLanguageSettingsDTO.description = description;
            return sectionLanguageSettingsDTO;
        }

        @Override
        public SectionDTO.Builder pageLanguageSettingsEnd() {
            return container.languageSettings(build());
        }

        @Override
        public BuilderImpl description(final String description) {
            this.description = description;
            return this;
        }

        @Override
        public BuilderImpl title(final String title) {
            this.title = title;
            return this;
        }
    }

}
