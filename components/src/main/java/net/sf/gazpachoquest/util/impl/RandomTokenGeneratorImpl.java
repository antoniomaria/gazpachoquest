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

import net.sf.gazpachoquest.util.RandomTokenGenerator;

import org.springframework.stereotype.Component;

@Component
public class RandomTokenGeneratorImpl implements RandomTokenGenerator {

    private static final int DEFAULT_TOKEN_LENGTH = 10;

    private final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };

    private final int ALPHABET_LENGTH = ALPHABET.length;

    @Override
    public String generate(int length) {
        StringBuilder token = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int pos = random.nextInt(ALPHABET_LENGTH);
            token.append(ALPHABET[pos]);
        }
        return token.toString();
    }

    @Override
    public String generate() {
        return generate(DEFAULT_TOKEN_LENGTH);
    }
}
