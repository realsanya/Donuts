package services;

import caster.Castable;
import caster.IntegerCaster;


import java.beans.Transient;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;

public class DBCreator {
    private ArrayList<Castable> castables = new ArrayList<Castable>() {
        {
            add(new IntegerCaster());
        }

        {
            add(new StringCaster());
        }

        {
            add(new ManyToOneCaster());
        }
    };

    public void create() {
        Reflections reflections = new Reflections(
                "ru.kpfu.itis.orm.entity",
                new TypeAnnotationsScanner(),
                new SubTypesScanner()
        );

        Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Table.class);
        entities.forEach(aClass -> {
            StringBuilder sql = new StringBuilder();

            sql.append("CREATE TABLE IF NOT EXISTS " + SqlUtils.recognizeTableName(aClass) + " (");

            Stream.of(aClass.getDeclaredFields())
                    .forEach(field -> {
                        sql.append(castables.stream()
                                .filter(castable -> castable.isSupport(field))
                                .map(castable -> castable.cast(field))
                                .findFirst()
                                .orElse("")).append(", ")
                        ;

                    });

            String finalSql = sql.substring(0, sql.length() - 2) + ");";
            System.out.println(finalSql);
            try {
                execute(finalSql);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    private void execute(String finalSql) throws ClassNotFoundException {
        //Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        try (Connection connection = DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.username"),
                properties.getProperty("db.password"))) {

            connection.prepareCall(finalSql).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}