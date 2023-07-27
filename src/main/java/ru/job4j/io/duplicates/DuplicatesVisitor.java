package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty key = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(file);
        return super.visitFile(file, attrs);
    }

    public void printConsoleFileInfo() {
        map.keySet()
                .forEach(key -> {
                    List<Path> value = map.get(key);
                    if (value.size() > 1) {
                        System.out.printf("%s - %s.Mb", key.getName(), key.getSize());
                        System.out.println();
                        value.forEach(System.out::println);
                    }
                });
    }
}
