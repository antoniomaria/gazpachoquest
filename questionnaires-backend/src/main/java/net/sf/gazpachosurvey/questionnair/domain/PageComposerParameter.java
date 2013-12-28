package net.sf.gazpachosurvey.questionnair.domain;

import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.Language;

public class PageComposerParameter {
    private BrowsingAction action;
    private Language language;

    public PageComposerParameter() {
        super();
    }
    public BrowsingAction getAction() {
        return action;
    }

    public void setAction(BrowsingAction action) {
        this.action = action;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public static class Builder {
        private BrowsingAction action;
        private Language language;

        public Builder action(BrowsingAction action) {
            this.action = action;
            return this;
        }

        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        public PageComposerParameter build() {
            PageComposerParameter pageComposerParameter = new PageComposerParameter();
            pageComposerParameter.action = action;
            pageComposerParameter.language = language;
            return pageComposerParameter;
        }
    }
}
