package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();

        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));

        schema.required();

        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));
        System.out.println(schema.isValid(5));

        System.out.println(schema.isValid("what does the fox say"));
        System.out.println(schema.isValid("hexlet"));

        System.out.println(schema.contains("wh").isValid("what does the fox say"));
        System.out.println(schema.contains("what").isValid("what does the fox say"));
        System.out.println(schema.contains("whatthe").isValid("what does the fox say"));
    }
}
