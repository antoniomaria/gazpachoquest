/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.gazpachoquest.util.impl;

import java.security.SecureRandom;
import java.util.Random;

import net.sf.gazpachoquest.util.RandomTokenGenerator;

import org.springframework.stereotype.Component;

@Component
public class RandomTokenGeneratorImpl implements RandomTokenGenerator {

    private final int DEFAULT_TOKEN_LENGTH = 10;

    private final int DEFAULT_TOKEN_NUM_OF_CHARACTERS = 36;

    @Override
    public String generate(int length) {
        StringBuffer id = new StringBuffer();

        Random r = new SecureRandom();

        int index = 0;
        int x = 0;
        while (x < length) {
            index = r.nextInt(DEFAULT_TOKEN_NUM_OF_CHARACTERS);
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

    @Override
    public String generate() {
        return generate(DEFAULT_TOKEN_LENGTH);
    }
}
