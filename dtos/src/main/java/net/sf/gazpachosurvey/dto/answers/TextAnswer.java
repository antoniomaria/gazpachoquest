package net.sf.gazpachosurvey.dto.answers;

public class TextAnswer extends SimpleAnswer {

    private static final long serialVersionUID = 672728157327871902L;

    private String value;

    public TextAnswer() {
        super();
    }

    public TextAnswer(String value) {
        super();
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static TextAnswer fromValue(String value) {
        return new TextAnswer(value);
    }

    @Override
    public String toString() {
        return "TextAnswer [value=" + value + "]";
    }

}
