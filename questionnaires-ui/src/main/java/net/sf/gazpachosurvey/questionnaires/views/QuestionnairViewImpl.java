package net.sf.gazpachosurvey.questionnaires.views;

import javax.annotation.PostConstruct;

import net.sf.gazpachosurvey.questionnaires.presenters.QuestionnairPresenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

@Component
@Scope("prototype")
@VaadinView(QuestionnairViewImpl.NAME)
public class QuestionnairViewImpl extends Panel implements QuestionnairView{

    private static final long serialVersionUID = -967273881368219867L;

    private static final Logger logger = LoggerFactory.getLogger(QuestionnairViewImpl.class);

    public static final String NAME = "";
    
    private QuestionnairPresenter presenter;
    
    public QuestionnairViewImpl(){
        logger.debug("New instance of class {} has been created with id = {} ",
                QuestionnairViewImpl.class.toString(), this.hashCode());
        this.presenter = new QuestionnairPresenter();
        presenter.setView(this);
    }

    @PostConstruct
    public void PostConstruct()
    {
        setSizeFull();
        setStyleName(Reindeer.PANEL_LIGHT);
        
        final VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);
        
        Button button = new Button("Click Me Again!");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);
    
        super.setContent(layout);
    }
    @Override
    public void enter(ViewChangeEvent event) {
        logger.debug("Entering the view {} with parameters: {}",event.getViewName(), event.getParameters());
    }
}
