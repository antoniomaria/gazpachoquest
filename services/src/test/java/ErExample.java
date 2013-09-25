import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.gazpachosurvey.types.Language;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

public class ErExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String input = "eng/11";

        //Pattern pattern = Pattern.compile("^(?<language>eng)/(?<templateId>\\d*)$");

        Pattern pattern = Pattern.compile("^(?<language>eng)/(?<templateId>\\d*)$");

        
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.matches()){
            System.out.println( "templateId: " + matcher.group("templateId"));
            System.out.println( "language: " + matcher.group("language"));
        }
        boolean match = false;
        System.out.println("matcher.groupCount" +  matcher.groupCount());
        int i = 0;
        if (matcher.matches()){
            while ( i  <= matcher.groupCount()){
                System.out.println(i  + " " +matcher.group(i));
            i++;
            }   
        }
        /*
        matcher = pattern.matcher(input);
        String language = matcher.group("language");
        String templateId = matcher.group("templateId");
        System.out.println(language + " ->" + templateId);
        
        if (match) {
            System.out.println( "iujuu!");
        } else {
            System.out.println("chungo");
        }
*/    }

}
