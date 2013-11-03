package net.sf.gazpachosurvey.rest.auth;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TokenStoreTest {

    private static TokenStore tokenStore;
    
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @BeforeClass
    public static void runOnce(){
        //tokenStore = new TokenStore(null, 0);
    }
    
    @Test
    public void test() throws IOException, InvalidKeyException, NoSuchAlgorithmException, IllegalStateException{
        File tokenFile = new File ("target/keys.txt");
        long sessionTimeout = System.currentTimeMillis() +  5 * 60 * 1000;
        TokenStore tokenStore = new TokenStore(tokenFile, sessionTimeout, false);

        String userId = "123@1234@11";
        long expires  = sessionTimeout;
        String token = null;
        for (int i = 0 ; i < 11; i++){
            token = tokenStore.encode(expires, userId);
                
        }
        System.out.println("token: " + token);
        boolean isValid = tokenStore.isValid(token);
        
        String[] user = TokenStore.split(token);
        System.out.println(isValid);
        for (String string : user) {
            System.out.println(string);
        }
    }
}
