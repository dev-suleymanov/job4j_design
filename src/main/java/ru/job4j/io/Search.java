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

    public static void validate(String[] args) {
        if (!Files.isDirectory(Paths.get(args[0]))) {
            throw new IllegalArgumentException("Set the initial path");
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("The file extension must start with \".\"");
        }
        if (args[1].length() < 3) {
            throw new IllegalArgumentException("The length of the extension must be at least three characters");
        }
    }
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("There should be two arguments");
        }
        validate(args);
        search(Paths.get(args[0]), p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }
}