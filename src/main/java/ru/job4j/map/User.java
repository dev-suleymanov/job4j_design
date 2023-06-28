package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>(16);
        User us1 = new User("Rustam", 0, new GregorianCalendar(1995, 5, 21));
        int hashcode1 = us1.hashCode();
        int hash1 = hashcode1 ^ (hashcode1 >>> 16);
        int bucket1 = hash1 & 15;
        User us2 = new User("Rauf", 0, new GregorianCalendar(1996, 11, 21));
        int hashcode2 = us2.hashCode();
        int hash2 = hashcode2 ^ (hashcode2 >>> 16);
        int bucket2 = hash2 & 15;
        map.put(us1, new Object());
        map.put(us2, new Object());
        System.out.printf("user1 - hashcode: %s, hash: %s, bucket: %s",
                hashcode1, hash1, bucket1);
        System.out.println();
        System.out.printf("user1 - hashcode: %s, hash: %s, bucket: %s",
                hashcode2, hash2, bucket2);
    }
}
