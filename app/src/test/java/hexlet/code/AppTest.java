package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public final class AppTest {

    private static StringSchema stringSchema;
    private static NumberSchema numberSchema;
    private static MapSchema mapSchema;
    private static Map<String, BaseSchema> schemas;
    private static Validator v;

    @BeforeEach
    void init() {
        v = new Validator();
        schemas = new HashMap<>();
        stringSchema = v.string();
        numberSchema = v.number();
        mapSchema = v.map();
    }

    @AfterEach
    void destroy() {
        v = null;
        stringSchema = null;
        numberSchema = null;
        mapSchema = null;
    }

    @Test
    void testStringSchema() {
        stringSchema = v.string();
        assertTrue(stringSchema.isValid(""));
        assertTrue(stringSchema.isValid(null));
        stringSchema.required();
        assertFalse(stringSchema.isValid(""));
        assertFalse(stringSchema.isValid(null));
        assertTrue(stringSchema.isValid("what does the fox say"));
        assertTrue(stringSchema.isValid("hexlet"));
//        assertFalse(stringSchema.isValid(5));  validation is not required due to automatic type checking
        assertTrue(stringSchema.minLength(4).isValid("hexlet"));
        assertFalse(stringSchema.minLength(4).isValid("hex"));
        assertTrue(stringSchema.contains("what").isValid("what does the fox say"));
        assertFalse(stringSchema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(stringSchema.isValid("what does the fox say"));
    }

    @Test
    void testNumberSchema() {
        assertTrue(numberSchema.isValid(null));
        assertTrue(numberSchema.positive().isValid(null));
        assertFalse(numberSchema.positive().isValid(-5));
        numberSchema.required();
        assertFalse(numberSchema.isValid(null));
//        assertFalse(numberSchema.isValid("5"));  validation is not required due to automatic type checking
        assertTrue(numberSchema.isValid(10));
        assertFalse(numberSchema.isValid(-10));
        assertFalse(numberSchema.isValid(0));
        numberSchema.range(5, 10);

        assertTrue(numberSchema.isValid(5));
        assertTrue(numberSchema.isValid(10));
        assertFalse(numberSchema.isValid(4));
        assertFalse(numberSchema.isValid(11));
    }

    @Test
    void testMapSchema() {
        assertTrue(mapSchema.isValid(null));
        mapSchema.required();
        assertFalse(mapSchema.isValid(null));
        assertTrue(mapSchema.isValid(new HashMap()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(mapSchema.isValid(data));
        mapSchema.sizeof(2);
        assertFalse(mapSchema.isValid(data));
        data.put("key2", "value2");
        assertTrue(mapSchema.isValid(data));

        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        mapSchema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertTrue(mapSchema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertTrue(mapSchema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertFalse(mapSchema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertFalse(mapSchema.isValid(human4));
    }
}
