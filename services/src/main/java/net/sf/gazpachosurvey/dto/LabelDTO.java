package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.dto.support.AbstractIdentifiableDTO;
import net.sf.gazpachosurvey.types.Language;

public class LabelDTO extends AbstractIdentifiableDTO{

    private static final long serialVersionUID = 7715134426554617698L;

    private String title;

    private Language language;

    public LabelDTO() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        private Integer id;
        
        private String title;

        private Language language;
        
        public Builder id(Integer id) {
            this.id= id;
            return this;
        }
        
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public LabelDTO build() {
            LabelDTO labelDTO = new LabelDTO();
            labelDTO.title = title;
            labelDTO.language = language;
            labelDTO.setId(id);
            return labelDTO;
        }
    }
}
