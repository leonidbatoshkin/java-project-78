package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    private final NumberSchema numSchema;
    private final StringSchema stringSchema;

    public Validator() {
        BaseSchema schema = new BaseSchema();
        stringSchema = new StringSchema();
        numSchema = new NumberSchema();
    }

    public StringSchema string() {
        return stringSchema;
    }

    public NumberSchema number() {
        return numSchema;
    }
}
