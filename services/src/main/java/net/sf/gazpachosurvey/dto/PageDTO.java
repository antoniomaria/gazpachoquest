package net.sf.gazpachosurvey.dto;

import net.sf.gazpachosurvey.types.Language;

public class PageDTO extends AbstractSerializableDTO<Integer> {

    private String title;

    private Language language;

    public PageDTO() {
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
        return new BuilderImpl();
    }

    public static interface Builder {

        Builder language(Language language);

        Builder title(String title) ;
            
        PageDTO build();
    }
    
    public static class BuilderImpl implements Builder {
        private String title;
        private Language language;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public PageDTO build() {
            return new PageDTO(this);
        }
    }

    private PageDTO(BuilderImpl builder) {
        this.title = builder.title;
        this.language = builder.language;
    }
}
