package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    private int size;
    private boolean nested;
    private boolean required;
    private Map<String, BaseSchema> schemas;

    public MapSchema sizeof(int mapSize) {
        this.size = mapSize;
        return this;
    }

    public MapSchema() {
        this.size = 0;
        this.nested = false;
    }

    public MapSchema shape(Map<String, BaseSchema> maps) {
        this.nested = true;
        this.schemas = maps;
        return this;
    }

    public MapSchema required() {
        this.required = true;
        return this;
    }

    @Override
    public <T> boolean isValid(T obj) {
        if (required && !(obj instanceof Map)) {
            return false;
        }
        if (size != 0 && obj instanceof Map && ((Map<?, ?>) obj).size() != size) {
            return false;
        }
        if (nested) {
            return schemas.entrySet().stream()
                    .map(schema -> schema.getValue().isValid(((Map<?, ?>) obj).get(schema.getKey())))
                    .allMatch(schema -> schema.equals(true));
        }
        return true;
    }
}
