package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map> {
    private int size;
    private Map<String, BaseSchema> schemas;

    Predicate<Map> checkSize = map -> map.size() == size;
    Predicate<Map> checkNested = map -> schemas.entrySet().stream()
            .map(schema -> schema.getValue().isValid(map.get(schema.getKey())))
            .allMatch(schema -> schema.equals(true));

    public MapSchema sizeof(int mapSize) {
        size = mapSize;
        setNewValidation(checkSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> maps) {
        this.schemas = maps;
        setNewValidation(checkNested);
        return this;
    }
}
