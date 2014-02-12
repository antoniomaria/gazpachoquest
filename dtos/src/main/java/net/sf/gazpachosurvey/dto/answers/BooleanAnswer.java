package net.sf.gazpachosurvey.dto.answers;

import org.apache.commons.lang.BooleanUtils;

public class BooleanAnswer extends SimpleAnswer {

    private static final long serialVersionUID = -6283418338635814499L;

    private String option;

    private Boolean value;

    public BooleanAnswer() {
        super();
    }

    public BooleanAnswer(String option, boolean value) {
        this();
        this.option = option;
        this.value = value;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    public static BooleanAnswer valueOf(String option, boolean value) {
        return new BooleanAnswer(option, BooleanUtils.toBoolean(value));
    }
}
