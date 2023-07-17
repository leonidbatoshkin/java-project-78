package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    private int length;
    private String substring;

    Predicate<String> checkLength = str -> str.length() > length;
    Predicate<String> checkRequired = str -> !str.isEmpty();
    Predicate<String> checkContains = str -> str.contains(substring);

    @Override
    public BaseSchema<String> required() {
        super.required();
        setNewValidation(checkRequired);
        return this;
    }

    public StringSchema minLength(int number) {
        length = number;
        setNewValidation(checkLength);
        return this;
    }

    public StringSchema contains(String str) {
        substring = str;
        setNewValidation(checkContains);
        return this;
    }
}
