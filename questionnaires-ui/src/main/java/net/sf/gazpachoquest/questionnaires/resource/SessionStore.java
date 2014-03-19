package net.sf.gazpachoquest.questionnaires.resource;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.cdi.UIScoped;

@UIScoped
public class SessionStore {

    private static final Logger logger = LoggerFactory.getLogger(SessionStore.class);

    private final AtomicInteger COUNTER = new AtomicInteger(0);

    @PostConstruct
    public void setUp() {
        logger.debug("New SessionStore created with id = {}", COUNTER.get());
    }

    @PreDestroy
    public void tearUp() {
        logger.debug("New SessionStore deleted with id = {}", COUNTER.get());
    }

    public int next() {
        return COUNTER.incrementAndGet();
    }

    public int get() {
        return COUNTER.get();
    }

}
