package net.sf.gazpachoquest.util.impl;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.util.RandomTokenGenerator;

import org.junit.Before;
import org.junit.Test;

public class RandomTokenGeneratorTest {

    private RandomTokenGenerator randomTokenGenerator;

    @Before
    public void setUp() {
        randomTokenGenerator = new RandomTokenGeneratorImpl();
    }

    @Test
    public void generateTest() {
        String token = randomTokenGenerator.generate(16);
        assertThat(token).hasSize(16);
    }

}
