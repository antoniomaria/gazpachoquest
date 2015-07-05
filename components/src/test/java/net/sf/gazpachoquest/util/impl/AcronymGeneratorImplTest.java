package net.sf.gazpachoquest.util.impl;

import static org.fest.assertions.api.Assertions.assertThat;
import net.sf.gazpachoquest.util.AcronymGenerator;

import org.junit.BeforeClass;
import org.junit.Test;

public class AcronymGeneratorImplTest {

    private static AcronymGenerator acronymGenerator;

    @BeforeClass
    public static void setUp() {
        acronymGenerator = new AcronymGeneratorImpl();
    }

    @Test
    public void generateTest() {
        String givenNames = "Eva";
        String surname = "Järvinen";
        String acronym = acronymGenerator.generate(givenNames, surname);
        assertThat(acronym).isEqualTo("EVAJÄRVI");
    }

}
