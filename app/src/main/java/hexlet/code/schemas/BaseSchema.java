package hexlet.code.schemas;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema {

    private final List<Predicate<Object>> validations = new ArrayList<>();

    private final Predicate<Object> checkRequired = Objects::nonNull;

    public final void setNewValidation(Predicate<Object> validation) {
        validations.add(validation);
    }

    /**
     * method to override.
     *
     * @return the current object
     */
    public BaseSchema required() {
        setNewValidation(checkRequired);
        return this;
    }

    public final boolean isValid(Object obj) {
        if (!(validations.contains(checkRequired)) && obj == null) {
            return true;
        } else if (validations.contains(checkRequired) && obj == null) {
            return false;
        } else {
            return validations.stream()
                    .allMatch(validation -> validation.test(obj));
        }
    }
}
