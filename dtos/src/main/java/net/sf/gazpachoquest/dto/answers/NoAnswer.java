package net.sf.gazpachoquest.dto.answers;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
public class NoAnswer extends SimpleAnswer {

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
