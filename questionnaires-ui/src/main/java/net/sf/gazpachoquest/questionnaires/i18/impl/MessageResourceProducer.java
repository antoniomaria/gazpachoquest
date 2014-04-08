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
package net.sf.gazpachoquest.questionnaires.i18.impl;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import net.sf.gazpachoquest.questionnaires.i18.MessageBundle;
import net.sf.gazpachoquest.questionnaires.i18.MessageResource;

public class MessageResourceProducer {

    @Inject
    private MessageBundleImpl messageBundleImpl;

    @Produces
    @MessageBundle
    public MessageResource createMessageBundle() {
        return messageBundleImpl;
    }
}
