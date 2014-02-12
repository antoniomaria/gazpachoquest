package net.sf.gazpachosurvey.dto.answers;

public class NumericAnswer extends SimpleAnswer {

    private static final long serialVersionUID = 5386142096853793403L;

    private Integer value;

    public NumericAnswer() {
        super();
    }

    public NumericAnswer(Integer value) {
        super();
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static NumericAnswer fromValue(Integer value) {
        return new NumericAnswer(value);
    }

}
