package net.sf.gazpachoquest.questionnaires.util;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @Stateless
// http://www.byteslounge.com/tutorials/java-ee-cdi-disposer-methods-example
public class ClientProducer {

    private static Logger logger = LoggerFactory.getLogger(ClientProducer.class);

    @Produces
    @GazpachoClient
    @Dependent
    public MyRestClient createRestClient() {
        int id = 123456;
        logger.info("Creating client with id = {}", id);
        return new MyRestClientImpl(id);
    }

    public void closeOrderSession(@Disposes
    @GazpachoClient
    MyRestClient client) {
        logger.info("Closing client with id = {}", client.getId());

    }

}
