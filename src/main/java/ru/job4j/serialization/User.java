package ru.job4j.serialization;

import java.util.Arrays;

public class User {
    private final String name;
    private final boolean status;
    private final int time;
    private final Resource resource;
    private final String[] names;

    public User(String name, boolean status, int time, Resource resource, String[] names) {
        this.name = name;
        this.status = status;
        this.time = time;
        this.resource = resource;
        this.names = names;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\''
                + ", status=" + status
                + ", time=" + time
                + ", resource=" + resource
                + ", names=" + Arrays.toString(names)
                + '}';
    }
}
