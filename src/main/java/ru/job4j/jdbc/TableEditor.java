package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        if (connection == null) {
            try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
                properties.load(in);
                Class.forName(properties.getProperty("driver-class-name"));
                String url = properties.getProperty("url");
                String login = properties.getProperty("login");
                String password = properties.getProperty("password");
                connection = DriverManager.getConnection(url, login, password);
            }
        }
    }

    private void initStatement(String query) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }

    public void createTable(String tableName) throws Exception {
        String query = String.format("create table if not exists %s();", tableName);
        initStatement(query);
        getTableScheme(tableName);
    }

    public void dropTable(String tableName) throws Exception {
        String query = String.format("drop table %s;", tableName);
        initStatement(query);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        initStatement(String.format("alter table %s add column %s %s;",
                tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        initStatement(String.format("alter table %s drop column %s;",
                tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        initStatement(String.format("alter table %s rename column %s to %s;",
                tableName, columnName, newColumnName));
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor tableEditor = new TableEditor(new Properties());
        tableEditor.createTable("stats");
        tableEditor.addColumn("stats", "id", "serial primary key");
        tableEditor.addColumn("stats", "name", "varchar(32)");
        tableEditor.addColumn("stats", "steam", "varchar(32)");
        tableEditor.addColumn("stats", "time", "int");
        tableEditor.renameColumn("stats", "time", "last_time");
        tableEditor.dropColumn("stats", "last_time");
        tableEditor.dropTable("stats");
    }
}