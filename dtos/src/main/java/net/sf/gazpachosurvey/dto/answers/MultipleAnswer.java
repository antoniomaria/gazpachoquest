package net.sf.gazpachosurvey.dto.answers;

import java.util.ArrayList;
import java.util.List;

public class MultipleAnswer extends AbstractAnswer {

    private static final long serialVersionUID = -2399910856085158733L;

    private List<Answer> answers;

    public MultipleAnswer() {
        super();
        answers = new ArrayList<>();
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    @Override
    public String toString() {
        return "MultipleAnswer [answers=" + answers + "]";
    }

    @Override
    public Object getValue() {
        throw new UnsupportedOperationException();
    }

}
