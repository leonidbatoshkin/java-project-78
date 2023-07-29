package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    private int[] range;
    private static final int START_POSITION = 0;
    private static final int LAST_POSITION = 1;

    public NumberSchema() {
        setNewValidation(num -> num instanceof Integer);
    }

    public NumberSchema positive() {
        setNewValidation(num -> (int) num > 0);
        return this;
    }

    public NumberSchema range(int start, int end) {
        range = new int[]{start, end};
        setNewValidation(num -> (int) num >= range[START_POSITION] && (int) num <= range[LAST_POSITION]);
        return this;
    }
}
