package net.sf.gazpachoquest.questionnaires;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import net.sf.gazpachoquest.api.Questionnairs;
import net.sf.gazpachoquest.dto.PageDTO;
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
// @SessionScoped
public class QuestionnairsClient implements Questionnairs {

    private static final long serialVersionUID = -3540740377335442445L;

    private static final Logger logger = LoggerFactory.getLogger(QuestionnairsClient.class);

    private final String baseURI = "http://gazpacho.antoniomaria.cloudbees.net/";

    private Questionnairs proxy;

    public QuestionnairsClient() {
        super();
        logger.debug("New instance of class %s created", QuestionnairsClient.class.getSimpleName());
    }

    @PostConstruct
    public void init() {
        logger.debug("Initializing instance of class %s", QuestionnairsClient.class.getSimpleName());
        proxy = JAXRSClientFactory.create(baseURI, Questionnairs.class,
                Collections.singletonList(new JacksonJsonProvider()), "respondent", "12345678", null);
    }

    @Override
    public List<QuestionnairDTO> list() {
        return proxy.list();
    }

    @Override
    public PageDTO getPage(Integer questionnairId, RenderingMode mode, BrowsingAction action) {
        return proxy.getPage(questionnairId, mode, action);
    }
}
