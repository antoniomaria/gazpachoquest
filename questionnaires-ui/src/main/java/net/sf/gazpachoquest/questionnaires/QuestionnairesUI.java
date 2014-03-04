package net.sf.gazpachoquest.questionnaires;

import java.util.List;

import javax.inject.Inject;

import net.sf.gazpachoquest.dto.QuestionnairDTO;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("gazpacho")
@Title("Gazpacho Questionnaires")
@CDIUI
// @SessionScoped
// @SessionScoped
public class QuestionnairesUI extends UI {

    private static final long serialVersionUID = 1265851857862002747L;

    @Inject
    private QuestionnairsClient client;

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        // layout.setStyleName(Reindeer.LAYOUT_BLUE);
        layout.setMargin(true);
        setContent(layout);
        List<QuestionnairDTO> questionnaires = client.list();

        String message = questionnaires.get(0).getLanguageSettings().getTitle();
        Label label = new Label(message);
        Button button = new Button("Click Me Again!");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(label);
        layout.addComponent(button);

    }

}
