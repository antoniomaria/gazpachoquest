package net.sf.gazpachoquest.jaas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.junit.Ignore;
import org.junit.Test;

public class RespondentsLoginModuleNoDeptsTest {

    @Test
    @Ignore
    public void doLogin() throws IOException {
        String invitation = "PXLLBCJDX6";
        String query = String.format("invitation=%s", URLEncoder.encode(invitation, "UTF-8"));
        URL url = new URL("http://kellari:8080/gazpachoquest-rest-web/kapi/auth?" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try (InputStream is = connection.getInputStream(); JsonReader rdr = Json.createReader(is)) {
            JsonObject obj = rdr.readObject();
            
           String givenNames = obj.getString("givenNames");
           String surname = obj.getString("surname");
           String email = obj.getString("email");
           String apiKey = obj.getString("apiKey");
           String secret = obj.getString("secret");
           String preferredLanguage = obj.getString("preferredLanguage");
           JsonArray roles = obj.getJsonArray("roles");
           for (JsonObject role : roles.getValuesAs(JsonObject.class)) {
               String roleName = role.getString("name");
               System.out.println(roleName);
           }
           JsonArray grantedquestionnaireIds = obj.getJsonArray("grantedquestionnaireIds");
           for (JsonNumber grantedquestionnaireId : grantedquestionnaireIds.getValuesAs(JsonNumber.class)) {
               Integer questionnaireId = grantedquestionnaireId.intValue();
               System.out.println(questionnaireId);
           }
          
            
        }catch (ConnectException e) {
            // TODO: handle exception
            System.err.println("chungo");
        }
        catch (IOException e) {
            int statusCode = connection.getResponseCode();
            System.out.println(statusCode);
            e.printStackTrace();
            
            try (InputStream error = connection.getErrorStream();
            // System.out.println(toString(error));
                    JsonReader rdr = Json.createReader(error)) {
                JsonObject obj = rdr.readObject();
                String message = obj.getString("message");
                System.out.println(statusCode + " " + message);
                /*-
                JsonArray results = obj.getJsonArray("data");
                for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                    System.out.print(result.getJsonObject("from").getString("name"));
                    System.out.print(": ");
                   System.out.println(result.getString("message", ""));
                   System.out.println("-----------");
                }*/

            }
        }
        /*-
         try (InputStream is = url.openStream();
              JsonReader rdr = Json.createReader(is)) {
        
             JsonObject obj = rdr.readObject();
             JsonArray results = obj.getJsonArray("data");
             for (JsonObject result : results.getValuesAs(JsonObject.class)) {
                 System.out.print(result.getJsonObject("from").getString("name"));
                 System.out.print(": ");
                System.out.println(result.getString("message", ""));
                System.out.println("-----------");
            }
        }catch (IOException e) {
           InputStream error = ((HttpURLConnection) url).getErrorStream();
        System.out.println(e);
        }*/
        System.out.println("fin");
    }

    public static String toString(InputStream in) throws IOException {
        InputStreamReader is = new InputStreamReader(in);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(is);
        String read = br.readLine();

        while (read != null) {
            // System.out.println(read);
            sb.append(read);
            read = br.readLine();

        }

        return sb.toString();
    }
}
