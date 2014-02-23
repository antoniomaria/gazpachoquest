package net.sf.gazpachoquest.dto.answers;

public abstract class AbstractAnswer implements Answer {

    private static final long serialVersionUID = -2678283968130774295L;

    protected AbstractAnswer() {
        super();
    }

    public abstract Object getValue();
}
