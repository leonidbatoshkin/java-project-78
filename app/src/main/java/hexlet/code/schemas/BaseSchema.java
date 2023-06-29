package hexlet.code.schemas;

public class BaseSchema {

    private boolean required;

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public BaseSchema(boolean required) {
        this.required = required;
    }

    public BaseSchema() {
        this.required = false;
    }

    public BaseSchema required() {
        this.required = true;
        return this;
    }

    public <T> boolean isValid(T obj) {
        return true;
    }
}
