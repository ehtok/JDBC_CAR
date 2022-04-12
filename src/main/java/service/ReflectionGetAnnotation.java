package service;

import annotation.MyColumn;
import annotation.MyTable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectionGetAnnotation {
    private static String tableName;
    private static List<String> column = new ArrayList<>();


    public static String getTable(Class entity) {
        Annotation annotation = entity.getAnnotation(MyTable.class);
        if (annotation != null) {
            tableName = ((MyTable) entity.getAnnotation(MyTable.class)).value();

        } else {
            System.out.println("Annotation doesn't found");
        }
        return tableName;
    }

    public static List<String> getFieldName(Class entity) {
        Field[] fields = entity.getDeclaredFields();
        for (Field field : fields
        ) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations
            ) {
                if (annotation.annotationType().equals(MyColumn.class)) {
                    column.add(field.getName());
                }

            }

        }

        return column;
    }

}



