package net.sf.gazpachoquest.types;

public enum BrowsingAction {
    FORWARD("FORWARD"), BACKWARD("BACKWARD"), ENTERING("ENTERING");

    private final String value;

    BrowsingAction(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static BrowsingAction fromString(String value) {
        for (BrowsingAction c : BrowsingAction.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        throw new IllegalArgumentException(value.toString());
    }
}
