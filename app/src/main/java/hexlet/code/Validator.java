package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class Validator {

    private final StringSchema schema;

    public Validator() {
        schema = new StringSchema();
    }

    public StringSchema string() {
        return schema;
    }
}
