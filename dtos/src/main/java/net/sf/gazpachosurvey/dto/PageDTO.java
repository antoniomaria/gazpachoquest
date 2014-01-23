package net.sf.gazpachosurvey.dto;

import java.io.Serializable;
import java.util.List;

public class PageDTO implements Serializable {

    private static final long serialVersionUID = -4722536148236589317L;

    private List<QuestionDTO> questions;

    public PageDTO() {
        super();
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

}
