package org.example.utils;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class MigrationUtil {

    public void startMigration() {
        Properties properties = loadProperties();

        String url = properties.getProperty("hibernate.connection.url");
        String name = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");

        Flyway flyway = Flyway.configure().dataSource(url, name, password).load();
        flyway.migrate();
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("hibernate.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}