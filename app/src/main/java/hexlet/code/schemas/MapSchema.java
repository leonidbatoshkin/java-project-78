package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    private int size;
    private Map<String, BaseSchema> schemas;

    public MapSchema() {
        setNewValidation(map -> map instanceof Map);
    }

    public MapSchema sizeof(int mapSize) {
        size = mapSize;
        setNewValidation(map -> ((Map<?, ?>) map).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> maps) {
        schemas = maps;
        setNewValidation(map -> schemas.entrySet().stream()
                .map(schema -> schema.getValue().isValid(((Map<?, ?>) map).get(schema.getKey())))
                .allMatch(schema -> schema.equals(true)));
        return this;
    }
}
