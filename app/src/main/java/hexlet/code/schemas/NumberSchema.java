package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        setNewValidation(num -> num instanceof Integer);
    }

    public NumberSchema positive() {
        setNewValidation(num -> (int) num > 0);
        return this;
    }

    public NumberSchema range(int start, int end) {
        setNewValidation(num -> (int) num >= start && (int) num <= end);
        return this;
    }
}
