package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String[] filters = argsName.get("filter").split(",");
        int[] indexes = new int[filters.length];
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(argsName.get("path")));
             BufferedWriter writer = new BufferedWriter(new FileWriter(argsName.get("out")))) {
            Scanner scanner = new Scanner(reader)
                    .useDelimiter(",");
            while (scanner.hasNext()) {
                String[] lines = scanner.nextLine().split(argsName.get("delimiter"));
                for (int i = 0; i < lines.length; i++) {
                    for (int j = 0; j < filters.length; j++) {
                        if (lines[i].equals(filters[j])) {
                            indexes[j] = i;
                        }
                    }
                }
                StringJoiner joiner = new StringJoiner(argsName.get("delimiter"));
                for (int index : indexes) {
                    joiner.add(lines[index]);
                }
                list.add(joiner.toString());
                list.add(System.lineSeparator());
            }
            for (String line : list) {
                if (argsName.get("out").equals("stdout")) {
                    System.out.println(line);
                } else {
                    writer.write(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void validate(ArgsName argsName) {
        if (!Files.exists(Path.of(argsName.get("path")))) {
            throw new IllegalArgumentException("The file does not exist");
        }
        if (!argsName.get("path").contains(".csv")) {
            throw new IllegalArgumentException("Specified incorrect path");
        }
        if (!argsName.get("delimiter").contains(";") || argsName.get("delimiter").length() > 1) {
            throw new IllegalArgumentException("Specified incorrect delimiter");
        }
        if (!(argsName.get("out").contains("stdout") || argsName.get("out").contains(".csv"))) {
            throw new IllegalArgumentException("Specified incorrect path");
        }
        if (argsName.get("filter").split(",").length < 1) {
            throw new IllegalArgumentException("There must be at least one filter");
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            throw new IllegalArgumentException("The arguments count should be \"4\"");
        }
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        handle(argsName);
    }
}
