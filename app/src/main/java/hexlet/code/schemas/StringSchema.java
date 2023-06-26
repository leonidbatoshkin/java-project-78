package hexlet.code.schemas;

public class StringSchema {
    private boolean required;
    private int minLength;
    private String substring;

    public StringSchema(boolean required, int minLength, String substring) {
        this.required = required;
        this.minLength = minLength;
        this.substring = substring;
    }

    public StringSchema() {
        this.required = false;
        this.minLength = 0;
        this.substring = "";
    }

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int number) {
        this.minLength = number;
        return this;
    }

    public StringSchema contains(String substring) {
        this.substring = substring;
        return this;
    }

    public <T> boolean isValid(T obj) {
        if (required && (!(obj instanceof String) || obj.toString().equals(""))) {
            return false;
        }
        if (!substring.equals("") && !obj.toString().contains(substring)) {
            return false;
        }
        return minLength == 0 || obj.toString().length() <= minLength;
    }
}
