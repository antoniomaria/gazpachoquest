package net.sf.gazpachosurvey.rest.auth;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Path("login")
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginService {
  //  private static final Logger logger = LoggerFactory
      //      .getLogger(LoginService.class);

    //@Autowired
    //private InvitationRepository repo;
    
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    @Path("respondents")
    public String doRespondentLogin(@QueryParam("key") String key) {
     //   logger.info("Respondent login attempt: {}, {}",key, repo);
        return "asdf23";
    }
}
