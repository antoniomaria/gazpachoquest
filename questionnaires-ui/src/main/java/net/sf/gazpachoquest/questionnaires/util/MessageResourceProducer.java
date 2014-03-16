package net.sf.gazpachoquest.questionnaires.util;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class MessageResourceProducer {

    @Inject
    private MessageBundleImpl messageBundleImpl;

    @Produces
    @MessageBundle
    public MessageResource createMessageBundle() {
        return messageBundleImpl;
    }
}
