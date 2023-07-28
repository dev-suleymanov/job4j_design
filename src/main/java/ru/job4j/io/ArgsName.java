package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String result = values.get(key);
        if (result == null) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return result;
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        Arrays.stream(args)
                .forEach(line -> {
                    notStartWithDash(line);
                    notFindEqualSign(line);
                    String[] temp = line.substring(1).
                            split("=", 2);
                    String key = temp[0];
                    String value = temp[1];
                    notValidateLine(line, key, value);
                    values.put(key, value);
                });
    }

    private void notStartWithDash(String line) {
        if (!line.startsWith("-")) {
            throw new IllegalArgumentException(String.
                    format("Error: This argument '%s' does not start with a '-' character", line));
        }
    }

    private void notFindEqualSign(String line) {
        if (!line.contains("=")) {
            throw new IllegalArgumentException(String.
                    format("Error: This argument '%s' does not contain an equal sign", line));
        }
    }

    private void notValidateLine(String line, String key, String value) {
        if (key.isEmpty()) {
            throw new
                    IllegalArgumentException(String.
                    format("Error: This argument '%s' does not contain a key", line));
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException(String.
                    format("Error: This argument '%s' does not contain a value", line));
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}