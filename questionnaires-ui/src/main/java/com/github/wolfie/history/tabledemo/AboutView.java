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

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;

public class AboutView extends CustomComponent implements View {
    private static final String HTML = "<div style='margin: 2em;'>"
            /*-*/
            + "<h1>About This Demo</h1>"
            /*-*/
            + "<p>This demo gives you an idea how pushState could be used in a Vaadin application, "
            + "with the help of the HistoryExtension.</p>"
            /*-*/
            + "<p>I've built a very simple application that might imitate how a Vaadin application "
            + "might look and behave like. It consists of two main views: Table view and this About "
            + "view. The Table view is further split up into a navigation table, and a Details view.</p>"
            /*-*/
            + "<p>As you navigate around, you notice the URL changing in your browser's address bar."
            + "This is achieved with the <a href=\"https://www.google.com/search?q=pushstate\">HTML5 pushState feature</a>."
            + "However, the entire page isn't reloaded, and navigation is performed as in a typical "
            + "Vaadin application, by modifying the components' state.</p>"
            /*-*/
            + "<p>To see what's going on, here's what you should do:</p>"
            + "<ol><li>Click through the application, navigating around a bit.</li>"
            + "<li>Then press \"back\" (and \"forward\") in your browser, and notice that it feels like natural navigation.</li>"
            + "<li>Finally, while you are in some particular page, refresh the page, and notice that you are not taken back to the beginning, but your navigation state is retained.</li>"
            + "<li>As a bonus step, you notice that even after refreshing the page, your browser still has history information, and it still works as expected</li></ol>"
            /*-*/
            + "<p>Lastly, you should take a look at the code in this demo, and see how all the "
            + "pieces interact with eachother. The most important parts in handling the "
            + "navigation are found in the "
            + "<code>com.github.wolfie.history.tabledemo.TableHistoryUI</code> class</p>"
            /*-*/
            + "<p>In case you're interested in what is serialized in the "
            + "history, open your browser's JavaScript console and type " + "\"<code>history.state</code>\" :)</p>"
            /*-*/
            + "</div>";

    private final CssLayout layout = new CssLayout();

    public AboutView() {
        setCompositionRoot(layout);

        final Label label = new Label(HTML, ContentMode.HTML);
        label.setWidth("40em");
        layout.addComponent(label);
    }

    @Override
    public void enter(final ViewChangeEvent event) {
        System.out.println("Entering AboutView");
    }
}
