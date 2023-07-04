package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private int size;
    private boolean nested;
    private Map<String, BaseSchema> schemas;

    public MapSchema sizeof(int mapSize) {
        this.size = mapSize;
        return this;
    }

    public MapSchema(int size) {
        this.size = size;
        this.nested = false;
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

    @Override
    public <T> boolean isValid(T obj) {
        if (isRequired() && !(obj instanceof Map)) {
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
