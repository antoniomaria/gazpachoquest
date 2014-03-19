package net.sf.gazpachoquest.questionnaires.resource;

import java.util.List;

import javax.inject.Inject;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.QuestionnairDTO;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;
import net.sf.gazpachoquest.questionnaires.resource.ResourceProducer;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.beans10.BeansDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @see https://community.jboss.org/message/729492a
 * @see http://java.dzone.com/articles/injecting-string-resource
 * @author antoniomaria
 * 
 */
@RunWith(Arquillian.class)
public class QuestionnairResourceTest {

    @Inject
    @GazpachoResource
    private QuestionnairResource questionnairResource;

    @Deployment
    public static Archive<?> createTestArchive() {
        String beansDescriptor = Descriptors.create(BeansDescriptor.class).exportAsString();
        JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "myarchive.jar")
                .addClasses(QuestionnairResource.class, ResourceProducer.class, GazpachoResource.class)
                .addAsResource("resources/messages.properties")
                .addAsManifestResource(new StringAsset(beansDescriptor), "beans.xml");
        return archive;
    }

    @Test
    public void listTest() {
        List<QuestionnairDTO> questionnairs = questionnairResource.list();
        for (QuestionnairDTO questionnairDTO : questionnairs) {
            System.out.println(questionnairDTO.getId() + " " + questionnairDTO.getLanguageSettings().getTitle());
        }

    }
}
