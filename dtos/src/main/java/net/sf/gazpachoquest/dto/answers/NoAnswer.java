package net.sf.gazpachoquest.dto.answers;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NoAnswer extends SimpleAnswer {

    private static final long serialVersionUID = 8164989374494030339L;

    public NoAnswer() {
        super();
    }

    @Override
    @JsonIgnore
    public Object getValue() {
        return null;
    }

    public static NoAnswer create() {
        return new NoAnswer();
    }

    @Override
    public String toString() {
        return "NoAnswer [value=null]";
    }

}
