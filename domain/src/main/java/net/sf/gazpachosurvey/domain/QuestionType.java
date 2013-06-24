package net.sf.gazpachosurvey.domain;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

public class QuestionType extends AbstractPersistable<Integer> {

    private String code;

    private String name;

    private boolean hasChoices;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasChoices() {
        return hasChoices;
    }

    public void setHasChoices(boolean hasChoices) {
        this.hasChoices = hasChoices;
    }

    public enum QuestionTypeEnum {
        Multiple_Choice_One_Answer, Multiple_Choice_Multiple_Answers, Comment, Rating_Scale, Ranking, Matrix_of_Choices_One_Answer, // (Only
                                                                                                                                    // One
                                                                                                                                    // Answer
                                                                                                                                    // Per
                                                                                                                                    // Row)
        Matrix_of_Choices_Multiple_Answers, Matrix_of_Dropdown_Menus, Single_Textbox, Multiple_Textboxes, Multiple_Numerical_Textboxes, Data_and_time
    }

}
