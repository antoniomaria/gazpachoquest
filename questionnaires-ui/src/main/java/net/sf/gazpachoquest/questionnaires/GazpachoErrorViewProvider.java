package net.sf.gazpachoquest.questionnaires;

import net.sf.gazpachoquest.questionnaires.views.ErrorView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewProvider;

public class GazpachoErrorViewProvider implements ViewProvider {

    @Override
    public String getViewName(String viewAndParameters) {
        return viewAndParameters;
    }

    @Override
    public View getView(String viewName) {
        return new ErrorView();
    }

}
