package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private int minLength;
    private String substring;

    public StringSchema(int minLength, String piece) {
        this.minLength = minLength;
        this.substring = piece;
    }

    public StringSchema() {
        this.minLength = 0;
        this.substring = "";
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
    public <T> boolean isValid(T obj) {
        if (isRequired() && (!(obj instanceof String) || obj.toString().equals(""))) {
            return false;
        }
        if (!substring.equals("") && !obj.toString().contains(substring)) {
            return false;
        }
        return minLength == 0 || obj.toString().length() >= minLength;
    }
}
