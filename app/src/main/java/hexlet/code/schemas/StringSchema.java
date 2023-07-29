package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {
    private int length;
    private String substring;

    public StringSchema() {
        setNewValidation(str -> str instanceof String);
    }

    @Override
    public StringSchema required() {
        super.required();
        setNewValidation(str -> !str.toString().isEmpty());
        return this;
    }

    public StringSchema minLength(int number) {
        length = number;
        setNewValidation(str -> str.toString().length() > length);
        return this;
    }

    public StringSchema contains(String string) {
        substring = string;
        setNewValidation(str -> str.toString().contains(substring));
        return this;
    }
}
