package net.sf.gazpachoquest.dto.answers;

import org.apache.commons.lang.ArrayUtils;

public class LongTextAnswer extends SimpleAnswer {

    private static final long serialVersionUID = 2744636578258338449L;

    private String value;

    public LongTextAnswer() {
        super();
    }

    public LongTextAnswer(String value) {
        super();
        this.value = value;
    }

    @Override
    public Character[] getValue() {
        return ArrayUtils.toObject(value.toCharArray());
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static LongTextAnswer fromValue(String value) {
        return new LongTextAnswer(value);
    }
}
