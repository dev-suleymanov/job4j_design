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
        Map<Integer, String> map = new HashMap();
        for (User user : current) {
            map.put(user.getId(), user.getName());
        }
        for (User user : previous) {
            String name = map.get(user.getId());
            if (name == null) {
                deleted++;
            } else {
                if (!name.equals(user.getName())) {
                    changed++;
                }
            }
        }
        added = current.size() - previous.size() + deleted;
        return new Info(added, changed, deleted);
    }
}