package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties cfg;
    private String dump;
    private Connection connection;
    public ImportDB(Properties cfg, String dump) throws Exception {
        this.cfg = cfg;
        this.dump = dump;
        init();
        create();
    }
    public void init() throws Exception {
        if (connection == null) {
            Class.forName(cfg.getProperty("jdbc.driver"));
            String url = cfg.getProperty("jdbc.url");
            String username = cfg.getProperty("jdbc.username");
            String password = cfg.getProperty("jdbc.password");
            connection = DriverManager.getConnection(url, username, password);
        }
    }

    public void create() throws Exception {
        String query = "create table if not exists users("
                + "id serial primary key,"
                + "name varchar(64),"
                + "email varchar(64));";
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void save(List<User> users) throws Exception {
        String query = "insert into users(name, email)"
                + "values(?, ?)";
        for (User user : users) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, user.name);
                statement.setString(2, user.email);
                statement.execute();
            }
        }
    }
    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines()
                    .forEach(line -> {
                        String[] temp = line.split(";", 3);
                        String name = temp[0];
                        String email = temp[1];
                        isValidLine(name, email);
                        users.add(new User(name, email));
                    });
        }
        return users;
    }
    private void isValidLine(String name, String email) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name was not found in the line");
        }
        if (email.isEmpty()) {
            throw new IllegalArgumentException("The email was not found in the line");
        }
    }
    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "data/spammer/dump.txt");
        db.save(db.load());
    }
}