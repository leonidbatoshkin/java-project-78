package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {
    private int size;
    private Map<String, BaseSchema> schemas;

    Predicate<Object> checkSize = map -> map instanceof Map && ((Map<?, ?>) map).size() == size;
    Predicate<Object> checkNested = map -> map instanceof Map && schemas.entrySet().stream()
            .map(schema -> schema.getValue().isValid(((Map<?, ?>) map).get(schema.getKey())))
            .allMatch(schema -> schema.equals(true));

    public MapSchema sizeof(int mapSize) {
        size = mapSize;
        setNewValidation(checkSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> maps) {
        schemas = maps;
        setNewValidation(checkNested);
        return this;
    }
}
