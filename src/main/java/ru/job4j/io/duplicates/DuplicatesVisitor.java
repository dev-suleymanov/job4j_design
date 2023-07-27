package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        List<FileProperty> list = new ArrayList<>();
        list.add(new FileProperty(file.toFile().length(), file.getFileName().toString()));
        Set<FileProperty> set = new HashSet<>(list);
        set.forEach(System.out::println);
        return super.visitFile(file, attrs);
    }
}
