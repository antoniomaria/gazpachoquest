package net.sf.gazpachoquest.dto.error;

public class ErrorEntity {

    private String code;

    private String message;

    public ErrorEntity() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String code;
        private String message;

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorEntity build() {
            ErrorEntity errorEntity = new ErrorEntity();
            errorEntity.code = code;
            errorEntity.message = message;
            return errorEntity;
        }
    }

}
