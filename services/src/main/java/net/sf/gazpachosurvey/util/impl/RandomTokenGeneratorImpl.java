package net.sf.gazpachosurvey.util.impl;

import java.security.SecureRandom;
import java.util.Random;

import net.sf.gazpachosurvey.util.RandomTokenGenerator;

import org.springframework.stereotype.Component;

@Component
public class RandomTokenGeneratorImpl implements RandomTokenGenerator {

    private int TOKEN_LENGTH = 10;

    private int TOKEN_NUM_OF_CHARACTERS = 36;

    @Override
    public String generate() {
        StringBuffer id = new StringBuffer();

        Random r = new SecureRandom();

        int index = 0;
        int x = 0;
        while (x < TOKEN_LENGTH) {
            index = r.nextInt(TOKEN_NUM_OF_CHARACTERS);
            if (index < 10) {
                id.append((char) (48 + index)); // Numbers
            } else if (10 <= index && index < 36) { // Capital letters 65 - 90
                index = index - 10;
                id.append((char) (65 + index));
            } else {
                index = index - 27;
                id.append((char) (97 + index)); // small letters
            }
            x++;
        }

        return id.toString();
    }
}
