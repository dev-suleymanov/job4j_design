package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class LogFilter {
    public List<String> filter(String file) {
        List<String> result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            result = reader.lines()
                    .filter(line -> line.contains(" 404 "))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("data/log.txt");
        log.forEach(System.out::println);
        save(log, "data/404.txt");
    }
}