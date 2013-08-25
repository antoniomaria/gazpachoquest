package net.sf.gazpachosurvey.types;


public enum QuestionType {
    S(false),
    
    Multiple_Choice_One_Answer(true),
    Multiple_Choice_Multiple_Answers(true), 
    Comment(false), 
    Rating_Scale(false),
    Ranking(false),
    Matrix_of_Choices_One_Answer(false), 
    Matrix_of_Choices_Multiple_Answers(false),
    Matrix_of_Dropdown_Menus(false),
    Single_Textbox(false),
    Multiple_Textboxe(true),
    Multiple_Numerical_Textboxes(true),
    Data_and_time(false), L(false), N(false), T(false);
    private boolean hasChoices;
    
    QuestionType(boolean hasChoices){
        this.hasChoices = hasChoices;
    }

    public boolean hasChoices() {
        return hasChoices;
    }

    public void setHasChoices(boolean hasChoices) {
        this.hasChoices = hasChoices;
    }
    
    
}
