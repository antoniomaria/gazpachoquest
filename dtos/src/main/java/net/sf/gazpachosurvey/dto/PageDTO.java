package net.sf.gazpachosurvey.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageDTO implements Serializable {

    private static final long serialVersionUID = -4722536148236589317L;

    private List<QuestionDTO> questions;

    public PageDTO() {
        super();
    }

    public void addQuestion(QuestionDTO question) {
        getQuestions().add(question);
    }

    public List<QuestionDTO> getQuestions() {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

}
