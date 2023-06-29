package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AppTest {

    private static StringSchema stringSchema;
    private static NumberSchema numberSchema;
    private static BaseSchema schema;

    @BeforeAll
    static void init() {
        Validator v = new Validator();
        stringSchema = v.string();
        numberSchema = v.number();
    }

    @Test
    void testStringSchema() {
        assertTrue(stringSchema.isValid(""));
        assertTrue(stringSchema.isValid(null));
        stringSchema.required();
        assertFalse(stringSchema.isValid(""));
        assertFalse(stringSchema.isValid(null));
        assertFalse(stringSchema.isValid(5));
        assertTrue(stringSchema.isValid("what does the fox say"));
        assertTrue(stringSchema.isValid("hexlet"));
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
        numberSchema.required();
        assertFalse(numberSchema.isValid(null));
        assertFalse(numberSchema.isValid("5"));
        assertTrue(numberSchema.isValid(10));
        assertFalse(numberSchema.isValid(-10));
        assertFalse(numberSchema.isValid(0));
        numberSchema.range(5, 10);

        assertTrue(numberSchema.isValid(5));
        assertTrue(numberSchema.isValid(10));
        assertFalse(numberSchema.isValid(4));
        assertFalse(numberSchema.isValid(11));
    }
}
