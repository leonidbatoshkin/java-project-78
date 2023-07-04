package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private int minLength;
    private String substring;
    private boolean required;

    public StringSchema(int minLength, String piece) {
        this.minLength = minLength;
        this.substring = piece;
        this.required = false;
    }

    public StringSchema() {
        this.minLength = 0;
        this.substring = "";
        this.required = false;
    }

    public StringSchema minLength(int number) {
        this.minLength = number;
        return this;
    }

    public StringSchema contains(String piece) {
        this.substring = piece;
        return this;
    }

    public StringSchema string() {
        return this;
    }

    @Override
    public StringSchema required() {
        this.required = true;
        return this;
    }

    @Override
    public <T> boolean isValid(T obj) {
        if (required && (!(obj instanceof String) || obj.toString().equals(""))) {
            return false;
        }
        if (!substring.equals("") && !obj.toString().contains(substring)) {
            return false;
        }
        return minLength == 0 || obj.toString().length() >= minLength;
    }
}
