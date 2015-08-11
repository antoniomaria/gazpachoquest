package net.sf.gazpachoquest.util.impl;

import net.sf.gazpachoquest.util.AcronymGenerator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AcronymGeneratorImpl implements AcronymGenerator {

    private int DEFAULT_SIZE = 8;

    @Override
    public String generate(String givenNames, String surname) {

        Assert.hasText(givenNames, "Given name is required");
        Assert.hasText(surname, "Surname is required");

        int wordsSize = 0;
        wordsSize += givenNames.length();
        wordsSize += surname.length();
        if (wordsSize < DEFAULT_SIZE) {
            return StringUtils.upperCase(new StringBuilder().append(givenNames).append(surname).toString());
        }

        // Character number to take from given names
        int fromGivenNames = 4;
        int fromSurname = 4;
        if (givenNames.length() < 4) {
            fromGivenNames = givenNames.length();
            fromSurname += (4 - givenNames.length());
        }
        if (surname.length() < 4) {
            fromSurname = surname.length();
            fromGivenNames += (4 - surname.length());
        }
        StringBuilder builder = new StringBuilder();
        builder.append(givenNames.substring(0, fromGivenNames));
        builder.append(surname.substring(0, fromSurname));
        return StringUtils.upperCase(builder.toString());
    }
}
