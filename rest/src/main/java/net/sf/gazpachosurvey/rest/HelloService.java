package net.sf.gazpachosurvey.rest;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);
    
    
    public HelloService(){
        logger.debug("New HelloService component created");
    }
    
    public String sayhello(){
        return "hello";
    }
    
    @PostConstruct
    public void loaded(){
        logger.debug("New HelloService loaded");
         }
}
