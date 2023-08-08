package ru.job4j.serialization;

import java.util.Map;

public class UsersInfo {
    public static void main(String[] args) {
        Resource resource = new Resource(Map.of(
                "Lord of the rings", "https://www.articles.com/lotr",
                "Harry potter", "https://www.articles.com/potter",
                "Hobbit", "https://www.articles.com/hobbit"
        ));
        User user = new User("Nebraska",
                true,
                2592000,
                resource,
                new String[]{"Maurice", "Caesar", "Nebraska"});
        System.out.println(user);
    }
}
