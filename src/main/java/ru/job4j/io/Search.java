package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searchFiles = new SearchFiles(condition);
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getPaths();
    }

    public static void validate(String start, String extension) {
        if (start.length() == 0) {
            throw new IllegalArgumentException("The length start parameter don't be empty");
        }
        if (extension.length() == 0) {
            throw new IllegalArgumentException("The length extension parameter don't be empty");
        }
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("There should be two arguments");
        }
        Path start = Paths.get(args[0]);
        String extension = args[1];
        validate(start.toString(), extension);
        search(start, p -> p.toFile().getName().endsWith(extension)).forEach(System.out::println);
    }
}