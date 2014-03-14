package com.github.wolfie.history.tabledemo;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;

public class DetailsView extends CustomComponent {

    private final VerticalLayout layout = new VerticalLayout();

    private final Label idLabel = new Label(" ");
    private final Label nameLabel = new Label(" ");
    private final Label descLabel = new Label(" ");

    public DetailsView() {
        layout.setSpacing(true);
        layout.setMargin(true);
        setCompositionRoot(layout);

        Label label = new Label("Details View");
        label.setStyleName(Reindeer.LABEL_H1);
        layout.addComponent(label);

        Panel idPanel = new Panel("ID");
        idPanel.setWidth("100%");
        idPanel.setContent(idLabel);
        layout.addComponent(idPanel);

        Panel namePanel = new Panel("Name");
        namePanel.setWidth("100%");
        namePanel.setContent(nameLabel);
        layout.addComponent(namePanel);

        Panel descPanel = new Panel("Description");
        descPanel.setWidth("100%");
        descPanel.setContent(descLabel);
        layout.addComponent(descPanel);
    }

    public void display(MyPojo pojo) {
        if (pojo != null) {
            idLabel.setValue(String.valueOf(pojo.getId()));
            nameLabel.setValue(pojo.getName());
            descLabel.setValue(pojo.getDescription());
        } else {
            idLabel.setValue(" ");
            nameLabel.setValue(" ");
            descLabel.setValue(" ");
        }
    }
}
