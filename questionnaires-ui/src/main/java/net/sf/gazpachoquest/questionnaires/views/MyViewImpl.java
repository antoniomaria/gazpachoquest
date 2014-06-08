package net.sf.gazpachoquest.questionnaires.views;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.vaadin.addon.cdimvp.AbstractMVPView;
import org.vaadin.addon.cdimvp.UIScopedStereotype;
import org.vaadin.addon.cdiproperties.annotation.LabelProperties;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@CDIView("myview")
@UIScopedStereotype
public class MyViewImpl extends AbstractMVPView implements MyView, View {
	
	@Inject
	@LabelProperties(caption = "Hello World!")
	private Label label;

	@PostConstruct
	protected void initView() {
		setSizeFull();

		final VerticalLayout mainLayout = new VerticalLayout();
		setCompositionRoot(mainLayout);
		mainLayout.setSizeFull();

		mainLayout.addComponent(label);

	}
	/*-
	 setSizeFull();

	 final VerticalLayout mainLayout = new VerticalLayout();
	 setCompositionRoot(mainLayout);
	 mainLayout.setSizeFull();

	 mainLayout.addComponent(toolbar.get());*/

	@Override
	public void enter(ViewChangeEvent event) {
		super.enter();
	}

}
