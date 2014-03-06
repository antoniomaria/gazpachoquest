package net.sf.gazpachoquest.questionnaires;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
public class SessionStore implements Serializable {
    private static final long serialVersionUID = 278656595950351992L;

    private static final Logger logger = LoggerFactory.getLogger(SessionStore.class);

    public static AtomicLong INSTANCE_COUNT = new AtomicLong(0);

    private String payload;

    @PostConstruct
    public void onNewSession() {
        long id = INSTANCE_COUNT.incrementAndGet();
        logger.info("New SessionStore created with id = {}", id);
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @PreDestroy
    public void onSessionDestruction() {
        INSTANCE_COUNT.decrementAndGet();
    }

}
