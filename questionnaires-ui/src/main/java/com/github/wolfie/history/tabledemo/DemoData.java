package com.github.wolfie.history.tabledemo;

import java.util.Random;

import com.vaadin.data.util.BeanItemContainer;

public class DemoData {

    private final static String[] GIVEN_NAMES = { "Liam", "Hunter", "Connor",
            "Jack", "Cohen", "Jaxon", "John", "Landon", "Owen", "William",
            "Benjamin", "Caleb", "Henry", "Lucas", "Mason", "Noah" };
    private final static String[] SURNAMES = { "Smith", "Brown", "Lee",
            "Wilson", "Martin", "Patel", "Taylor", "Wong", "Campbell",
            "Williams", "Thompson", "Jones" };

    private final static String[] WORDS = { "Aenean", "volutpat", "elit",
            "quis", "nisi", "consequat", "sodales.", "Cras", "elementum",
            "blandit", "convallis.", "Fusce", "dapibus", "consectetur", "mi",
            "at", "pulvinar.", "Mauris", "placerat", "nunc", "vel", "bibendum",
            "rutrum.", "Nullam", "sit", "amet", "vestibulum", "nunc,",
            "interdum", "volutpat", "nisi.", "Pellentesque", "iaculis", "sed",
            "purus", "quis", "bibendum.", "Quisque", "sodales", "convallis",
            "dolor,", "sollicitudin", "hendrerit", "lorem", "volutpat", "in.",
            "In", "at", "quam", "ac", "nisl", "accumsan", "porttitor.",
            "Proin", "mattis", "libero", "vitae", "consectetur", "vestibulum.",
            "Sed", "placerat", "diam", "in", "cursus", "ullamcorper.",
            "Curabitur", "turpis", "metus,", "accumsan", "eget", "fermentum",
            "in,", "ornare", "vitae", "nisl.", "Cras", "malesuada", "dictum",
            "ante", "at", "aliquet.", "Donec", "ut", "ipsum", "id", "tellus",
            "luctus", "pellentesque.", "Maecenas", "tempus", "lorem", "quis",
            "metus", "laoreet", "scelerisque." };

    private final static Random RAND = new Random(42);

    public static BeanItemContainer<MyPojo> generate() {
        final BeanItemContainer<MyPojo> c = new BeanItemContainer<MyPojo>(
                MyPojo.class);

        for (int i = 0; i < 100; i++) {
            final MyPojo pojo = new MyPojo();
            pojo.setId(i);
            pojo.setName(generateName());
            pojo.setDescription(generateDescription());
            c.addBean(pojo);
        }

        return c;
    }

    private static String generateName() {
        String givenName = GIVEN_NAMES[RAND.nextInt(GIVEN_NAMES.length)];
        String surname = SURNAMES[RAND.nextInt(SURNAMES.length)];
        return givenName + " " + surname;
    }

    private static String generateDescription() {
        int descLength = RAND.nextInt(10) + 10;
        String desc = "";
        for (int i = 0; i < descLength; i++) {
            desc += WORDS[RAND.nextInt(WORDS.length)] + " ";
        }
        return desc;
    }
}
