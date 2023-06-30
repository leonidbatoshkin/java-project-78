package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {

    private final NumberSchema numSchema;
    private final StringSchema stringSchema;
    private final MapSchema mapSchema;

    public Validator() {
        stringSchema = new StringSchema();
        numSchema = new NumberSchema();
        mapSchema = new MapSchema();
    }

    public StringSchema string() {
        return stringSchema;
    }

    public NumberSchema number() {
        return numSchema;
    }

    public MapSchema map() {
        return mapSchema;
    }
}
