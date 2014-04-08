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
package net.sf.gazpachoquest.questionnair.domain;

import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.Language;

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
