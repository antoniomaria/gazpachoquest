package net.sf.gazpachosurvey.rest;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import net.sf.gazpachosurvey.aspects.ProfilingAdvise;
//import net.sf.gazpachosurvey.dto.SurveyDTO;
//import net.sf.gazpachosurvey.services.SurveyService;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

@Path("surveys")
// @Component
public class SurveysResource {

    private static final Logger logger = LoggerFactory            .getLogger(SurveysResource.class);

    AtomicInteger counter = new AtomicInteger();

    // @Autowired
    // @Inject
    HelloService helloService;

    public SurveysResource() {
        logger.debug("New invitations resource created");
        System.out.println("SurveysResource created ");
        
    }

    /*
     * @GET
     * 
     * @Produces(MediaType.APPLICATION_JSON) public List<SurveyDTO> getSurveys()
     * { return surveyService.findAll(); }
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getHello() {
        System.out.println("hello desde sruveyresource.java ");
        String response = String.format("%d: %s", counter.incrementAndGet(),
                "hola holitas!");
                //helloService.sayhello());
        return Response.ok(response).build();
    }

    @PostConstruct
    public void after() {
        //logger.debug("parece que funciona?" + helloService);
    }

}
