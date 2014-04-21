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

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;

public class GazpachoViewDisplay extends Panel implements ViewDisplay {

	private static final long serialVersionUID = 6287152165941299841L;

	public GazpachoViewDisplay() {
		setSizeFull();
	}

	@Override
	public void showView(View view) {
		if (view instanceof CustomComponent) {
			setContent((CustomComponent) view);
		} else if (view instanceof ComponentContainer) {
			setContent((ComponentContainer) view);
		} else {
			throw new IllegalStateException("View not supported! ");
		}
	}

}
