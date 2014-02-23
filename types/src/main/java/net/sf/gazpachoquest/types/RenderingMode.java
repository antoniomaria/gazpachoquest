package net.sf.gazpachoquest.types;

public enum RenderingMode {

    QUESTION_BY_QUESTION("QUESTION_BY_QUESTION"), GROUP_BY_GROUP("GROUP_BY_GROUP");

    private final String value;

    RenderingMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RenderingMode fromString(String value) {
        for (RenderingMode c : RenderingMode.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException(value.toString());
    }
}
