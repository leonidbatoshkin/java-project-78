package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {
    private int length;
    private String substring;

    private final Predicate<Object> checkLength = str -> str instanceof String && str.toString().length() > length;
    private final Predicate<Object> checkRequired = str -> str instanceof String && !str.toString().isEmpty();
    private final Predicate<Object> checkContains = str -> str instanceof String && str.toString().contains(substring);

    @Override
    public StringSchema required() {
        super.required();
        setNewValidation(checkRequired);
        return this;
    }

    public StringSchema minLength(int number) {
        length = number;
        setNewValidation(checkLength);
        return this;
    }

    public StringSchema contains(String string) {
        substring = string;
        setNewValidation(checkContains);
        return this;
    }
}
