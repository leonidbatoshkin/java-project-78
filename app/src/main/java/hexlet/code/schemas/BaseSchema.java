package hexlet.code.schemas;

public class BaseSchema {
    /**
     * method to override.
     *
     * @param <T> the type of the input object
     * @param obj the object to validate
     * @return the result of the schema's validation
     */
    public <T> boolean isValid(T obj) {
        return true;
    }
}
