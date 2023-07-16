package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines()
                    .filter(line -> !line.isEmpty()
                            && line.charAt(0) != '#'
                            && line.contains("="))
                    .forEach(line -> {
                        String[] temp = line.split("=", 2);
                        String key = temp[0];
                        String value = temp[1];
                        if (key.isEmpty() || value.isEmpty()) {
                            throw new IllegalArgumentException("This config has an incorrect storage format key=value");
                        }
                        values.put(temp[0], temp[1]);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    public Map<String, String> getMap() {
        return values;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("data/notvalid.properties");
        config.load();
    }
}