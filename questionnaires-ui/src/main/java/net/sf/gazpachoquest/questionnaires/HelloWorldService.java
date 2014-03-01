package net.sf.gazpachoquest.questionnaires;

import javax.ejb.Stateless;

@Stateless
// @UIScoped
public class HelloWorldService {

    public String sayHello() {
        return "Hola holitas desde EJB";
    }
}
