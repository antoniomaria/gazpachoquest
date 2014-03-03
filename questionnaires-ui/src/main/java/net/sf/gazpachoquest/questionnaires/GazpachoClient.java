package net.sf.gazpachoquest.questionnaires;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import net.sf.gazpachoquest.api.Questionnairs;
import net.sf.gazpachoquest.dto.PageDTO;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.types.BrowsingAction;
import net.sf.gazpachoquest.types.RenderingMode;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.vaadin.cdi.UIScoped;

// @Stateless
@UIScoped
// SessionScoped
public class GazpachoClient {
    private static final Logger logger = LoggerFactory.getLogger(GazpachoClient.class);

    private final String baseURI = "http://gazpacho.antoniomaria.cloudbees.net/";

    public GazpachoClient() {
        super();
        logger.debug("New instance of class %s created", GazpachoClient.class.getSimpleName());
    }

    public String sayHello() {
        return "Hola holitas desde EJB";
    }

    public List<QuestionnairDTO> findQuestionnaires() {
        List<QuestionnairDTO> questionnairDTOs = null;

        /*-
        Response response = client.target(baseUri + "runtime/questionnairs").request()
                .accept(MediaType.APPLICATION_JSON).get();
        List<QuestionnairDTO> questionnairDTOs = response.readEntity(new GenericType<List<QuestionnairDTO>>() {
        });*/
        return questionnairDTOs;
    }

    @PostConstruct
    public void init() {
        logger.debug("Initializing instance of class %s", GazpachoClient.class.getSimpleName());
        Questionnairs proxy = JAXRSClientFactory.create(baseURI, Questionnairs.class,
                Collections.singletonList(new JacksonJsonProvider()), "respondent", "12345678", null);

        List<QuestionnairDTO> questionnairs = proxy.list();

        for (QuestionnairDTO questionnairDTO : questionnairs) {
            System.out.println(questionnairDTO);
        }
        Integer questionnairId = 63;
        PageDTO page = proxy.getPage(questionnairId, RenderingMode.GROUP_BY_GROUP, BrowsingAction.ENTERING);

        for (QuestionDTO questionDTO : page.getQuestions()) {
            System.out.println(questionDTO);
        }
        // HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("respondent", "12345678");
        // this.client = ClientBuilder.newClient(new ClientConfig().register(new JacksonFeature()).register(feature));
    }

    public static void main(String args[]) {
        new GazpachoClient().init();
        System.out.println("fin");
    }
}
