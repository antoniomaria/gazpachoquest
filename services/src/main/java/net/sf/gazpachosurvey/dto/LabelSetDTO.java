package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.PageDTO.Builder;
import net.sf.gazpachosurvey.dto.PageDTO.BuilderImpl;
import net.sf.gazpachosurvey.types.Language;

public class LabelSetDTO extends AbstractSerializableDTO<Integer> {

    private static final long serialVersionUID = -7715245634090394574L;

    private String name;

    private Language language;

    public LabelSetDTO() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public static Builder with() {
        return new Builder();
    }
    
    public static class Builder {
        private String name;
        private Language language;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public LabelSetDTO build() {
            return new LabelSetDTO(this);
        }
    }

    private LabelSetDTO(Builder builder) {
        this.name = builder.name;
        this.language = builder.language;
    }
}
