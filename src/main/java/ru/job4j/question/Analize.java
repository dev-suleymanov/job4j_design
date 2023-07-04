package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        Map map = new HashMap();
        for (User user : current) {
            map.put(user.getId(), user.getName());
        }
        for (User user : previous) {
            var value = map.get(user.getId());
            if (value == null) {
                deleted++;
            } else {
                if (!value.equals(user.getName())) {
                    changed++;
                }
            }
        }
        added = current.size() - previous.size() + deleted;
        return new Info(added, changed, deleted);
    }

    public static void main(String[] args) {
        Set<User> previous = new HashSet<>();
        previous.add(new User(1, "a"));
        previous.add(new User(2, "b"));
        previous.add(new User(3, "c"));
        Set<User> current = new HashSet<>();
        current.add(new User(1, "a"));
        current.add(new User(2, "b"));
        current.add(new User(4, "e"));
        Info result = diff(previous, current);
        System.out.println(result);
    }
}