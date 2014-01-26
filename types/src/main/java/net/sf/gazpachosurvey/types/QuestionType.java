package net.sf.gazpachosurvey.types;

public enum QuestionType {
    S("Single Text Box", false, false, false, String.class), L("Multiple Choice (Only One QuestionOption)", true,
            false, false, String.class), N("Numeric", false, false, false, Integer.class), T("Comment / Essay", false,
            false, false, Character[].class), F("Rating Scale (Agree-Disagree)", false, false, false, String.class), M(
            "Multiple_Choice_Multiple_Answers", false, false, true, String.class);
    private String description;
    private boolean hasChoices;
    private boolean hasSubquestions;
    private boolean hasMultipleAnswers;
    private Class<?> answerType;

    private QuestionType(String description, boolean hasSubquestions, boolean hasChoices, boolean hasMultipleAnswers,
            Class<?> answerType) {
        this.hasChoices = hasChoices;
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

    public boolean hasChoices() {
        return hasChoices;
    }

    public Class<?> getAnswerType() {
        return answerType;
    }

    @Override
    public String toString() {
        return description;
    }

}
