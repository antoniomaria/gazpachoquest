package net.sf.gazpachoquest.types;

public enum QuestionType {
    S("Single Text Box", false, false, String.class), L("List Radio", false, false, String.class), N("Numeric", false,
            false, Integer.class), T("Comment / Essay", false, false, Character[].class), F("Array Flexible", true,
            true, null), M("List Checkbox. (Multiple_Choice)", false, true, Boolean.class);
    private String description;
    private boolean hasSubquestions;
    private boolean hasMultipleAnswers;
    private Class<?> answerType;

    private QuestionType(String description, boolean hasSubquestions, boolean hasMultipleAnswers, Class<?> answerType) {
        this.hasSubquestions = hasSubquestions;
        this.hasMultipleAnswers = hasMultipleAnswers;
        this.answerType = answerType;
        this.description = description;
    }

    public boolean hasSubquestions() {
        return hasSubquestions;
    }

    public boolean hasMultipleAnswers() {
        return hasMultipleAnswers;
    }

    public Class<?> getAnswerType() {
        return answerType;
    }

    @Override
    public String toString() {
        return description;
    }

}
