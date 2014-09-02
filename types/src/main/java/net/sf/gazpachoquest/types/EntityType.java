package net.sf.gazpachoquest.types;

public enum EntityType {

    QUESTIONNAIRE("Q", "questionnaire"), QUESTONNAIRE_DEFINITION("QD", "QuestionnaireDefinition"), RESEARCH("R",
            "research"), USER("U", "user");

    private String code;
    private String label;

    EntityType(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static EntityType fromCode(String code) {
        for (EntityType status : EntityType.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Type " + code.toString() + " not supported");
    }

}
