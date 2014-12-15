/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0 which accompanies this distribution, and is
 * available at http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.gazpachoquest.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachoquest.types.Language;

/**
 * @composed - has 1..n LabelDTO
 */
@SuppressWarnings("serial")
public class LabelSetDTO extends AbstractIdentifiableDTO {

    private final List<LabelDTO> labels = new ArrayList<>();

    private Language language;

    private String name;

    public LabelSetDTO() {
        super();
    }

    private LabelSetDTO(final Builder builder) {
        name = builder.name;
        language = builder.language;
    }

    public void addLabel(final LabelDTO label) {
        labels.add(label);
    }

    public List<LabelDTO> getLabels() {
        return Collections.unmodifiableList(labels);
    }

    public Language getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static class Builder {
        private Language language;
        private String name;

        public LabelSetDTO build() {
            return new LabelSetDTO(this);
        }

        public Builder language(final Language language) {
            this.language = language;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }
    }

    public static Builder with() {
        return new Builder();
    }

}
