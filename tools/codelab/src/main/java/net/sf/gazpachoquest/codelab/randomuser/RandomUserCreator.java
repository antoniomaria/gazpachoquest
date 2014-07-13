/*
 * This code has been copied from:
 * https://github.com/aliilyas/RandomUserApiClient
 */
package net.sf.gazpachoquest.codelab.randomuser;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.gazpachoquest.codelab.randomuser.support.RandomResponse;
import net.sf.gazpachoquest.codelab.randomuser.support.RandomUser;

/**
 * 
 * @author Ilyas
 */
public class RandomUserCreator {

    public static final String URL = "http://api.randomuser.me/";

    public static String getContent(String urlToRead) {
        String line;
        String result = "";
        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static RandomResponse getRandomResponse() {
        String s = RandomUserCreator.getContent(URL);
        Gson gson = new Gson();
        return gson.fromJson(s, RandomResponse.class);
    }

    public static RandomUser getRandomUser() {
        return getRandomResponse().getResults().get(0).getUser();
    }

}
