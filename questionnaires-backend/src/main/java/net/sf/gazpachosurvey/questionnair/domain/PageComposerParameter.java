package net.sf.gazpachosurvey.questionnair.domain;

import net.sf.gazpachosurvey.types.BrowsingAction;
import net.sf.gazpachosurvey.types.Language;

public class PageComposerParameter {
    public static class Builder {
        private BrowsingAction action;
        private Language language;

        public Builder action(final BrowsingAction action) {
            this.action = action;
            return this;
        }

        public PageComposerParameter build() {
            PageComposerParameter pageComposerParameter = new PageComposerParameter();
            pageComposerParameter.action = action;
            pageComposerParameter.language = language;
            return pageComposerParameter;
        }

        public Builder language(final Language language) {
            this.language = language;
            return this;
        }
    }

    private BrowsingAction action;

    private Language language;

    public PageComposerParameter() {
        super();
    }

    public BrowsingAction getAction() {
        return action;
    }

    public Language getLanguage() {
        return language;
    }

    public void setAction(final BrowsingAction action) {
        this.action = action;
    }

    public void setLanguage(final Language language) {
        this.language = language;
    }
}
