import java.util.Locale;

import org.jvnet.inflector.Noun;

public class PluralOf {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Noun.pluralOf("car", Locale.ENGLISH));
        System.out.println(Noun.pluralOf("bambino", Locale.ITALIAN));

    }

}
