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
package net.sf.gazpachoquest.questionnaires;

import net.sf.gazpachoquest.questionnaires.views.ErrorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;

public class GazpachoErrorViewProvider implements ViewProvider {

    private static final long serialVersionUID = -816047369725821704L;

    private static final Logger logger = LoggerFactory.getLogger(GazpachoErrorViewProvider.class);

    @Override
    public String getViewName(String viewAndParameters) {
        return viewAndParameters;
    }

    @Override
    public View getView(String viewName) {
        logger.info("View name '{}' not found. Redirecting to errorView", viewName);
        return new ErrorView();
    }

}
