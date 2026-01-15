package oop_advanced.annotations;

import java.lang.reflect.Field;
import java.util.*;

public class Validator {

    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    errors.add(field.getAnnotation(NotNull.class).message());
                }

                if (field.isAnnotationPresent(Validate.class)) {
                    Validate v = field.getAnnotation(Validate.class);
                    int val = (int) value;
                    if (val < v.min() || val > v.max()) {
                        errors.add(v.message());
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return errors;
    }
}
