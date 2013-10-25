package net.sf.gazpachosurvey.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import net.sf.gazpachosurvey.aspects.ProfilingAdvise;
import net.sf.gazpachosurvey.dto.SurveyDTO;
import net.sf.gazpachosurvey.services.SurveyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.inject.Inject;

@Path("surveys")
@Component
public class SurveysResource {
    
    private static final Logger logger = LoggerFactory.getLogger(SurveysResource.class);
    
    AtomicInteger counter = new AtomicInteger();

    @InjectParam
    HelloService helloService;
    
    public SurveysResource(){
        logger.debug("New invitations resource created");
    }
    
/*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SurveyDTO> getSurveys() {
        return surveyService.findAll();
    }*/
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(@Context HttpHeaders headers, @QueryParam("p1") String p1) {
        if("foobar".equals(p1)) {
            throw new IllegalArgumentException("foobar is illegal");
        }
        return String.format("%d: %s", counter.incrementAndGet(), helloService.sayhello());
    }
    @PostConstruct
    public void after(){
        logger.debug("parece que funciona?" + helloService);
    }
    
}
