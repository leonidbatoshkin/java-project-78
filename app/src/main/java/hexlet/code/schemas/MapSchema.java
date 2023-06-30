package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private int size;

    public MapSchema sizeof(int mapSize) {
        this.size = mapSize;
        return this;
    }

    public MapSchema(int size) {
        this.size = size;
    }

    public MapSchema() {
        this.size = 0;
    }

    @Override
    public <T> boolean isValid(T obj) {
        if (isRequired() && (!(obj instanceof Map))) {
            return false;
        }
        return size == 0 || obj instanceof Map && ((Map<?, ?>) obj).size() == size;
    }
}
