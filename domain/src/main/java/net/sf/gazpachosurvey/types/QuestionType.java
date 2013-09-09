package net.sf.gazpachosurvey.types;

public enum QuestionType {
    S("Single Text Box", false, false, false, String.class),
    L("Multiple Choice (Only One Answer)",true,false, false, Integer.class),
    N("Numeric",false, false, false, Integer.class),
    T("Comment / Essay",false, false, false, Character[].class),
    F("Rating Scale (Agree-Disagree)",false, false, false, String.class),
    M("Multiple_Choice_Multiple_Answers", false, false, true, String.class);
    
    /*Multiple_Choice_One_Answer(false, false, true), 
    Multiple_Choice_Multiple_Answers(false, false, true),
    Comment(false, false, false),
    Rating_Scale(false, false, false), Ranking(false, false, false), Matrix_of_Choices_One_Answer(
            false, false, false), Matrix_of_Choices_Multiple_Answers(false,
            false, false), Matrix_of_Dropdown_Menus(false, false, false), Single_Textbox(
            false, false, false), Multiple_Textboxe(false, false, true), Multiple_Numerical_Textboxes(
            false, false, true), Data_and_time(false, false, false), ;
            
    */
    private String description;
    private boolean hasChoices;
    private boolean hasSubquestions;
    private boolean hasMultipleAnswers;
    private Class<?> answerType;

    private QuestionType(String description, boolean hasSubquestions, boolean hasChoices,
            boolean hasMultipleAnswers, Class<?> answerType) {
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
    
    public String toString(){
        return description;
    }
    

}
