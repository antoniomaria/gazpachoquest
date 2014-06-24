package net.sf.gazpachoquest.types;

public enum RandomizationStrategy {
    GROUPS_RANDOMIZATION("G"), QUESTIONS_RANDOMIZATION("Q"), NONE("N");

    private final String code;

    RandomizationStrategy(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static RandomizationStrategy fromCode(String code) {
        for (RandomizationStrategy strategy : RandomizationStrategy.values()) {
            if (strategy.code.equals(code)) {
                return strategy;
            }
        }
        throw new IllegalArgumentException(code.toString());
    }
}
