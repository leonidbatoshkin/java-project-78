package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean positive;
    private int[] range;

    private static final int START_POSITION = 0;
    private static final int LAST_POSITION = 1;

    public NumberSchema(boolean positive, int[] range) {
        this.positive = positive;
        this.range = range;
    }

    public NumberSchema() {
        this.positive = false;
        this.range = null;
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int start, int end) {
        this.range = new int[]{start, end};
        return this;
    }

    @Override
    public <T> boolean isValid(T obj) {
        var required = super.isRequired();
        if ((obj == null) && required) {
            return false;
        }
        if (positive && required && Integer.parseInt(obj.toString()) < 1) {
            return false;
        }
        if (range != null && obj instanceof Integer
                && ((Integer) obj < range[START_POSITION] || (Integer) obj > range[LAST_POSITION])) {
            return false;
        }
        return obj instanceof Integer || !required;
    }
}
