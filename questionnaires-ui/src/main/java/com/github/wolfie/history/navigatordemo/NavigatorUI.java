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
package com.github.wolfie.history.navigatordemo;

import javax.inject.Inject;

import com.github.wolfie.history.HistoryExtension;
import com.github.wolfie.history.tabledemo.AboutView;
import com.github.wolfie.history.tabledemo.MyPojo;
import com.github.wolfie.history.tabledemo.TableView;
import com.github.wolfie.history.tabledemo.TableView.TableSelectionListener;
import com.vaadin.annotations.Title;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.NavigationStateManager;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Title("Navigator Integration Example")
// @CDIUI
public class NavigatorUI extends UI implements ViewDisplay {

    private static final String APP_URL = "/NavDemo";

    // @WebServlet(urlPatterns = { APP_URL + "/*" }, asyncSupported = true)
    // @VaadinServletConfiguration(productionMode = false, ui = NavigatorUI.class)
    public static class Servlet extends VaadinServlet {
        // default implementation is fine.
    }

    @Inject
    private CDIViewProvider viewProvider;

    private Navigator navigator;
    private HistoryExtension history;
    private TabSheet tabSheet;

    @Inject
    TableView tableView;

    /*-
    private final TableView tableView = new TableView(new TableSelectionListener() {
        @Override
        public void tableSelectionChanged(final MyPojo selectedPojo) {
            if (selectedPojo != null) {
                navigator.navigateTo("/table/" + selectedPojo.getId());
            } else {
                navigator.navigateTo("");
            }
        }
    });
     */
    private class MyTableSelectionListener implements TableSelectionListener {
        @Override
        public void tableSelectionChanged(final MyPojo selectedPojo) {
            if (selectedPojo != null) {
                navigator.navigateTo("/table/" + selectedPojo.getId());
            } else {
                navigator.navigateTo("");
            }
        }
    }

    private final AboutView aboutView = new AboutView();
    private String contextPath;

    @Override
    protected void init(final VaadinRequest request) {
        contextPath = VaadinServlet.getCurrent().getServletContext().getContextPath();
        tableView.setListener(new MyTableSelectionListener());
        history = new HistoryExtension();
        history.extend(this);

        final NavigationStateManager pushStateManager = history.createNavigationStateManager(contextPath + APP_URL);
        navigator = new Navigator(this, pushStateManager, this);

        navigator.addProvider(viewProvider);

        navigator.addView("", tableView);
        navigator.addView("/table", tableView);
        navigator.addView("/about", aboutView);

        tabSheet = new TabSheet();
        setContent(tabSheet);
        tabSheet.addTab(tableView, "Table View");
        tabSheet.addTab(aboutView, "About this Demo");
        tabSheet.setSizeFull();
        tabSheet.addSelectedTabChangeListener(new SelectedTabChangeListener() {
            @Override
            public void selectedTabChange(final SelectedTabChangeEvent event) {
                if (tabSheet.getSelectedTab() == tableView) {
                    final MyPojo selected = tableView.getSelected();
                    if (selected != null) {
                        navigator.navigateTo("/table/" + selected.getId());
                    } else {
                        navigator.navigateTo("/table");
                    }
                } else {
                    navigator.navigateTo("/about");
                }
            }
        });
    }

    @Override
    public void showView(final View view) {
        tabSheet.setSelectedTab((Component) view);

        if (view == tableView) {
            final String[] args = navigator.getState().split("/");
            if (args.length > 2) {
                final String id = args[2];
                try {
                    tableView.select(Integer.parseInt(id));
                } catch (final NumberFormatException e) {
                    e.printStackTrace();
                }
            } else {
                tableView.select(-1);
            }
        }
    }
}
