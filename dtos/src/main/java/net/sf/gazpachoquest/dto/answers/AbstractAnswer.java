package net.sf.gazpachoquest.dto.answers;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = TextAnswer.class, name = "T"),
        @JsonSubTypes.Type(value = NumericAnswer.class, name = "N"),
        @JsonSubTypes.Type(value = BooleanAnswer.class, name = "B"),
        @JsonSubTypes.Type(value = MultipleAnswer.class, name = "M"),
        @JsonSubTypes.Type(value = LongTextAnswer.class, name = "L") })
public abstract class AbstractAnswer implements Answer {

    private static final long serialVersionUID = -2678283968130774295L;

    protected AbstractAnswer() {
        super();
    }

    @Override
    public abstract Object getValue();
}
