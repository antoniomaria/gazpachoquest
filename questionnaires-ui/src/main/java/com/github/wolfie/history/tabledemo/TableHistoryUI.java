/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package com.github.wolfie.history.tabledemo;

import org.json.JSONException;
import org.json.JSONObject;

import com.github.wolfie.history.HistoryExtension;
import com.github.wolfie.history.HistoryExtension.PopStateEvent;
import com.github.wolfie.history.HistoryExtension.PopStateListener;
import com.github.wolfie.history.tabledemo.TableView.TableSelectionListener;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Title("Table HTML5 History Demo")
public class TableHistoryUI extends UI {

    private static final String APP_URL = "/TableDemo";

    // @WebServlet(urlPatterns = { APP_URL + "/*" }, asyncSupported = true)
    // @VaadinServletConfiguration(productionMode = false, ui = TableHistoryUI.class)
    public static class Servlet extends VaadinServlet {
        // default implementation is fine.
    }

    protected static final String POJO_ID_KEY = "id";
    protected static final String VIEW_KEY = "view";

    private static final int TABLE_VIEW_STATE_VALUE = 1;
    private static final int ABOUT_VIEW_STATE_VALUE = 2;

    private final HistoryExtension.ErrorListener historyErrorListener = new HistoryExtension.ErrorListener() {
        @Override
        public void onError(final HistoryExtension.ErrorEvent event) {
            Notification.show("Your browser doesn't seem to support pushState properly: " + event.getErrorName(),
                    Notification.Type.ERROR_MESSAGE);
            event.cancel();
        }
    };

    private final PopStateListener popStateListener = new PopStateListener() {
        @Override
        public void popState(final PopStateEvent event) {
            /*
             * We could've used event.getStateAsMap as well, to get an Map<String, String> instead.
             */
            applySerializedState(event.getStateAsJson());
        }
    };

    private final SelectedTabChangeListener tabChangeListener = new SelectedTabChangeListener() {
        @Override
        public void selectedTabChange(final SelectedTabChangeEvent event) {
            if (applyingSerializedState) {
                return;
            }

            final Component selectedTab = event.getTabSheet().getSelectedTab();

            String selection;
            if (selectedTab == tableView) {
                selection = "table";

                final MyPojo selectedPojo = tableView.getSelected();
                if (selectedPojo != null) {
                    selection += "/" + selectedPojo.getId();
                }
                selection += "/";
            }

            else if (selectedTab == aboutView) {
                selection = "about/";
            }

            else {
                Notification.show("Unknown tab was selected", Notification.Type.ERROR_MESSAGE);
                throw new IllegalStateException("Unknown tab was selected");
            }

            pushStateHelper(selection);
        }
    };

    private final TableSelectionListener tableSelectionListener = new TableSelectionListener() {
        @Override
        public void tableSelectionChanged(final MyPojo selectedPojo) {
            if (applyingSerializedState) {
                return;
            }

            if (selectedPojo != null) {
                pushStateHelper("table/" + selectedPojo.getId() + "/");
            } else {
                pushStateHelper("table/");
            }
        }
    };

    private HistoryExtension history;

    private final AboutView aboutView = new AboutView();
    private final TableView tableView = new TableView(tableSelectionListener);
    private final TabSheet tabsheet = new TabSheet();

    /**
     * A flag that prevents event feedback loops when modifying internal state via
     * {@link #applySerializedState(JSONObject)}
     */
    private boolean applyingSerializedState = false;

    private String contextPath = "";

    @Override
    protected void init(final VaadinRequest request) {
        tabsheet.setSizeFull();
        tabsheet.addTab(tableView, "Table View");
        tabsheet.addTab(aboutView, "About this Demo");
        tabsheet.addSelectedTabChangeListener(tabChangeListener);
        setContent(tabsheet);

        history = HistoryExtension.extend(this, popStateListener);
        history.addErrorListener(historyErrorListener);

        contextPath = VaadinServlet.getCurrent().getServletContext().getContextPath();

        // initialize a starting state from URL
        initStateFromStartingUrl();
    }

    private void initStateFromStartingUrl() {
        boolean wasRedirected = false;

        String[] urlParams = getPage().getLocation().getPath().substring((contextPath + APP_URL).length() + 1)
                .split("/");

        if (urlParams.length == 1 && urlParams[0].equals("")) {
            // initial starting page, do nothing
        } else if (urlParams.length == 1 && urlParams[0].equals("about")) {
            tabsheet.setSelectedTab(aboutView);
        } else if (urlParams.length == 1 && urlParams[0].equals("table")) {
            // table page without a parameter.
        } else if (urlParams.length == 2 && urlParams[0].equals("table")) {
            try {
                int pojoId = Integer.parseInt(urlParams[1]);
                tableView.select(pojoId);
            } catch (NumberFormatException e) {
                getPage().setLocation(contextPath + APP_URL + "/");
                wasRedirected = true;
            }
        } else {
            getPage().setLocation(contextPath + APP_URL + "/");
            wasRedirected = true;
        }

        if (!wasRedirected) {
            history.replaceState(serializeState(), null);
        }
    }

    private void pushStateHelper(final String nextUrl) {
        String targetUrl = contextPath + APP_URL + "/" + nextUrl;

        final String query = getPage().getLocation().getQuery();
        if (query != null) {
            targetUrl += "?" + query;
        }

        final JSONObject state = serializeState();
        history.pushState(state, targetUrl);
    }

    private JSONObject serializeState() {
        try {
            final int view;
            if (tabsheet.getSelectedTab() == tableView) {
                view = TABLE_VIEW_STATE_VALUE;
            } else if (tabsheet.getSelectedTab() == aboutView) {
                view = ABOUT_VIEW_STATE_VALUE;
            } else {
                throw new IllegalStateException("unknown tab selected");
            }

            final MyPojo selectedPojo = tableView.getSelected();
            final int tableValueId;
            if (selectedPojo != null) {
                tableValueId = selectedPojo.getId();
            } else {
                // no pojo has this id, so it'll return null when deserializing.
                tableValueId = -1;
            }

            final JSONObject state = new JSONObject();
            state.put(VIEW_KEY, view);
            state.put(POJO_ID_KEY, tableValueId);
            return state;

        } catch (final JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Modifies the application's according to the given state object.
     * 
     * @param state
     *            the state object that contains the information needed to modify the application's state
     */
    private void applySerializedState(final JSONObject state) {
        if (state == null) {
            return;
        }

        try {
            applyingSerializedState = true;

            final int view = state.getInt(VIEW_KEY);
            final int pojoId = state.getInt(POJO_ID_KEY);

            switch (view) {
            case TABLE_VIEW_STATE_VALUE:
                tabsheet.setSelectedTab(tableView);
                break;
            case ABOUT_VIEW_STATE_VALUE:
                tabsheet.setSelectedTab(aboutView);
                break;
            default:
                throw new UnsupportedOperationException("Unknown tab type: " + view);
            }

            tableView.select(pojoId);

        } catch (final JSONException e) {
            throw new RuntimeException(e);
        } finally {
            applyingSerializedState = false;
        }
    }
}
