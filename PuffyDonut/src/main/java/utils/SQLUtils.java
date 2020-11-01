package utils;

import java.lang.reflect.Field;

public class SQLUtils {
    public static String recognizeConstraints(Field field) {
//        StringBuilder sql = new StringBuilder();
//        Constraint constraint = field.getAnnotation(Constraint.class);
//        if (constraint != null) {
//            if (constraint.pk()) sql.append(" PRIMARY KEY ");
//            if (constraint.uniq()) sql.append(" UNIQUE ");
//            if (constraint.notNull()) sql.append(" NOT NULL ");
//        }
//        return sql.toString();
        return null;
    }

    public static String recognizeForeignKey(Field field) {
        StringBuilder sql = new StringBuilder();

        return " REFERENCES " + recognizeTableName(field.getType()) + "(id)";
    }

    public static String recognizeTableName(Class<?> table) {
//        String tableName;
//        Table annotation = table.getAnnotation(Table.class);
//        if (annotation.name().isEmpty()) {
//            tableName = table.getSimpleName();
//        } else {
//            tableName = annotation.name();
//        }
//        return tableName;
        return null;
    }

    public static String recognizeFieldDefinition(Class tClass, Field field) {
        return SQLUtils.recognizeTableName(tClass) +
                "." +
                field.getName() +
                " as " +
                SQLUtils.recognizeTableName(tClass) +
                "_" +
                field.getName();
    }
}
