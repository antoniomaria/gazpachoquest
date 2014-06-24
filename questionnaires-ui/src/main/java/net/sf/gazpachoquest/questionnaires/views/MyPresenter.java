package net.sf.gazpachoquest.questionnaires.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter;
import org.vaadin.addon.cdimvp.AbstractMVPPresenter.ViewInterface;

@SuppressWarnings("serial")
@ViewInterface(MyView.class)
public class MyPresenter extends AbstractMVPPresenter<MyView> {

    private static Logger logger = LoggerFactory.getLogger(MyPresenter.class);

    @Override
    public void viewEntered() {
        logger.debug("viewEntered");

    }

}
