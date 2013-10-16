package net.sf.gazpachosurvey.questionnaires;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldComponent {

    public String getMessage(){
        return "Hello world from spring component";
    }
}
