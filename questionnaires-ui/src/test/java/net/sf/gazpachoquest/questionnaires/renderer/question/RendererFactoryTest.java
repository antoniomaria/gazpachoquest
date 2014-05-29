package net.sf.gazpachoquest.questionnaires.renderer.question;

import javax.inject.Inject;

import net.sf.gazpachoquest.api.QuestionnairResource;
import net.sf.gazpachoquest.dto.QuestionDTO;
import net.sf.gazpachoquest.questionnaires.renderer.question.types.shorttext.RendererImpl;
import net.sf.gazpachoquest.questionnaires.resource.GazpachoResource;
import net.sf.gazpachoquest.questionnaires.resource.ResourceProducer;
import net.sf.gazpachoquest.types.QuestionType;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.beans10.BeansDescriptor;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.vaadin.ui.Panel;

@RunWith(Arquillian.class)
@Ignore
public class RendererFactoryTest {

	@Inject
	RendererFactory rendererFactory;

	@Deployment
	public static Archive<?> createTestArchive() {
		String beansDescriptor = Descriptors.create(BeansDescriptor.class)
				.exportAsString();
		JavaArchive archive = ShrinkWrap
				.create(JavaArchive.class, "myarchive.jar")
				.addClasses(RendererFactory.class, Renderers.class,
						Renderer.class, QuestionType.class, RendererImpl.class,
						QuestionDTO.class, Panel.class)
				.addAsManifestResource(new StringAsset(beansDescriptor),
						"beans.xml");
		return archive;
	}

	@Test
	public void f() {
		System.out.println("the winner is: " + rendererFactory.createRenderer(QuestionType.S));
	}

}
