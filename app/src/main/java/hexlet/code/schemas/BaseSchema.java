package hexlet.code.schemas;

public class BaseSchema {
    private boolean required;

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
