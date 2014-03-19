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
