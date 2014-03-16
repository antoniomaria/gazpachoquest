package net.sf.gazpachoquest.questionnaires.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.ui.UI;

@Named
public class MessageResource {

    private static final Logger logger = LoggerFactory.getLogger(MessageResource.class);

    private static final String BUNDLE_NAME = "messages";

    public MessageResource() {
        super();
    }

    public static String getString(String key) {
        // .properties does not like space
        key = key.replaceAll(" ", ""); //$NON-NLS-1$
        Locale locale = UI.getCurrent().getLocale();
        // Get the bundle for our current locale
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            logger.warn("[MISSING TRANSLATION] Locale: {}  Key: {}", locale, key);
            return '!' + key + '!';
        }
    }
}
