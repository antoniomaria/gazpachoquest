package com.github.wolfie.history.tabledemo;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Table;

public class TableView extends CustomComponent implements View {

    public interface TableSelectionListener {
        /**
         * The selection in the table has changed.
         * 
         * @param selectedPojo
         *            The newly selected pojo
         */
        void tableSelectionChanged(MyPojo selectedPojo);
    }

    private final HorizontalSplitPanel splitpanel = new HorizontalSplitPanel();
    private final Table table = new Table();
    private final DetailsView detailsView = new DetailsView();

    private final TableSelectionListener listener;

    private final ValueChangeListener tableValueChangeListener = new ValueChangeListener() {
        @Override
        public void valueChange(final ValueChangeEvent event) {
            final MyPojo newSelection = (MyPojo) event.getProperty().getValue();
            detailsView.display(newSelection);

            listener.tableSelectionChanged(newSelection);
        }
    };

    public TableView(final TableSelectionListener listener) {
        this.listener = listener;

        setSizeFull();

        splitpanel.setSizeFull();
        splitpanel.setSplitPosition(400f, Unit.PIXELS, true);
        setCompositionRoot(splitpanel);

        table.setSizeFull();
        table.setSelectable(true);
        table.addValueChangeListener(tableValueChangeListener);
        table.setContainerDataSource(DemoData.generate());
        table.setImmediate(true);
        table.setColumnWidth("id", 20);
        table.setColumnWidth("name", 100);
        table.setVisibleColumns("id", "name", "description");
        splitpanel.setFirstComponent(table);

        splitpanel.setSecondComponent(detailsView);
    }

    /**
     * Searches through the Table's Container for a pojo with a given id.
     * 
     * @param id
     *            the id of pojo to return
     * @return a {@link MyPojo} with the given id, or <code>null</code> if no such pojo is found
     */
    private MyPojo findPojoById(final int id) {
        @SuppressWarnings("unchecked")
        final BeanItemContainer<MyPojo> container = ((BeanItemContainer<MyPojo>) table.getContainerDataSource());
        for (final MyPojo bean : container.getItemIds()) {
            if (bean.getId() == id) {
                return bean;
            }
        }
        return null;
    }

    /**
     * Returns the currently selected pojo in the table, or <code>null</code> if nothing is selected.
     */
    public MyPojo getSelected() {
        return (MyPojo) table.getValue();
    }

    /**
     * Selects the pojo with the given id from the table, or removes selection if no such id is found.
     */
    public void select(final int pojoId) {
        final MyPojo pojo = findPojoById(pojoId);
        table.select(pojo);
    }

    @Override
    public void enter(final ViewChangeEvent event) {
        System.out.println("Entering TableView");
    }
}
