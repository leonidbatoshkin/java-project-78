package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    private boolean required;
    private boolean positive;
    private int[] range;

    private static final int START_POSITION = 0;
    private static final int LAST_POSITION = 1;

    public NumberSchema() {
        this.positive = false;
        this.range = null;
        this.required = false;
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int start, int end) {
        this.range = new int[]{start, end};
        return this;
    }

    public NumberSchema required() {
        this.required = true;
        return this;
    }

    @Override
    public <T> boolean isValid(T obj) {
        if ((obj == null) && required) {
            return false;
        }
        if (positive && (required || obj instanceof Integer) && Integer.parseInt(obj.toString()) < 1) {
            return false;
        }
        if (range != null && obj instanceof Integer
                && ((Integer) obj < range[START_POSITION] || (Integer) obj > range[LAST_POSITION])) {
            return false;
        }
        return obj instanceof Integer || !required;
    }
}
