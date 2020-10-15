package caster;

import annotations.ManyToOne;
import utils.SQLUtils;

import java.lang.reflect.Field;

public class ManyToOneCaster implements Castable {
    @Override
    public String cast(Field field) {
        return field.getName() + " INT " + SQLUtils.recognizeConstraints(field) + " " + SQLUtils.recognizeForeignKey(field);
    }

    @Override
    public boolean isSupport(Field field) {
        return field.getAnnotation(ManyToOne.class) != null;
    }
}
