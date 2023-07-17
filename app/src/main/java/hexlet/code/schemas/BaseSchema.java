package hexlet.code.schemas;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {

    List<Predicate<T>> validations = new ArrayList<>();

    Predicate<T> checkRequired = Objects::nonNull;

    public final void setNewValidation(Predicate<T> validation) {
        validations.add(validation);
    }

    public BaseSchema required() {
        setNewValidation(checkRequired);
        return this;
    }

    public boolean isValid(T obj) {
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
