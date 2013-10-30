package net.sf.gazpachosurvey.rest.auth;


import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.grizzly.http.servlet.ServletAdapter;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
//http://alkalinezoo.blogspot.fi/2013/05/rest-testing-with-embedded-grizzly.html
public class GrizzlyMain {
   
    private static int getPort(int defaultPort) {
        String port = System.getenv("JERSEY_HTTP_PORT");
        if (null != port) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException e) {
            }
        }
        return defaultPort;        
    }
   
    final static URI baseUri = UriBuilder.fromUri( "http://localhost/" ).port( 9998 ).build();
   
    public static void startServer() throws IOException{
        final ServletAdapter adapter =new ServletAdapter();
        adapter.addInitParameter( "com.sun.jersey.config.property.packages", "com.inphina.sample" );
        adapter.addInitParameter( "com.sun.jersey.api.json.POJOMappingFeature", "true" );
       // adapter.addContextParameter( "contextConfigLocation","classpath:applicationContext.xml"  );
       // adapter.addServletListener( "org.springframework.web.context.ContextLoaderListener" );
        adapter.setServletInstance( new SpringServlet() );
        adapter.setContextPath(baseUri.getPath());
        adapter.setProperty( "load-on-startup", 1 );

        System.out.println("********" + baseUri.getPath());
       // SelectorThread threadSelector = GrizzlyServerFactory.create(baseUri, adapter);
        return ;
    }
   
   
   
    public static void main(String[] args) throws IOException {
        System.out.println("Starting grizzly...");
    //    SelectorThread threadSelector = startServer();
        System.out.println(String.format(
                "Jersey app started with WADL available at %sapplication.wadl\n" +
                "Hit enter to stop it...", baseUri));
        System.in.read();
        //threadSelector.stopEndpoint();
    }    
}
