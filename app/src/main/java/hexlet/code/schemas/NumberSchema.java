package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {
    private int[] range;
    private static final int START_POSITION = 0;
    private static final int LAST_POSITION = 1;

    Predicate<Object> checkPositive = num -> num instanceof Integer && (int) num > 0;
    Predicate<Object> checkRange = num -> num instanceof Integer
            && (int) num >= range[START_POSITION] && (int) num <= range[LAST_POSITION];

    public NumberSchema positive() {
        setNewValidation(checkPositive);
        return this;
    }

    public NumberSchema range(int start, int end) {
        range = new int[]{start, end};
        setNewValidation(checkRange);
        return this;
    }
}
