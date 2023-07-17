package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    private int[] range;

    private static final int START_POSITION = 0;
    private static final int LAST_POSITION = 1;

    Predicate<Integer> checkPositive = num -> num > 0;
    Predicate<Integer> checkRange = num -> num >= range[START_POSITION] && num <= range[LAST_POSITION];

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
