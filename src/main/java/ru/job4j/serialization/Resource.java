package ru.job4j.serialization;

import java.util.Map;

public class Resource {
    private final Map<String, String> map;

    public Resource(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Resource{"
                + "map=" + map
                + '}';
    }
}
