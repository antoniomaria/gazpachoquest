package net.sf.gazpachosurvey.types;

public enum QuestionType {
    S("Single Text Box", false, false,  String.class),
    L("List Radio", false, false,  String.class),
    N("Numeric", false, false,  Integer.class), 
    T("Comment / Essay", false,  false,  Character[].class),
    F("Array Flexible", true, null, null), 
    M("List Checkbox. (Multiple_Choice)", false, false, Boolean.class);
    private String description;
    private Boolean hasSubquestions;
    private Boolean hasMultipleAnswers;
    private Class<?> answerType;

    private QuestionType(String description, Boolean hasSubquestions, Boolean hasMultipleAnswers,
            Class<?> answerType) {
        this.hasSubquestions = hasSubquestions;
        this.hasMultipleAnswers = hasMultipleAnswers;
        this.answerType = answerType;
        this.description = description;
    }

    public Boolean hasSubquestions() {
        return hasSubquestions;
    }

    public Boolean hasMultipleAnswers() {
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
