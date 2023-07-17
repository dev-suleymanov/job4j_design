package ru.job4j.io;

import java.io.*;
import java.util.Objects;

public class Analysis {
    public void unavailable(String source, String target) {
        String[] result = new String[2];
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            reader.lines()
                    .forEach(line -> {
                        String[] temp = line.split(" ");
                        String status = temp[0];
                        String data = temp[1];
                        if (Objects.equals(status, "400") || Objects.equals(status, "500")) {
                            if (Objects.isNull(result[0])) {
                                result[0] = data;
                            }
                        } else {
                            if (Objects.nonNull(result[0])) {
                                result[1] = data;
                                writer.println(String.format("%s;%s", result[0], result[1]));
                                result[0] = null;
                            }
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/analysis/server.log", "data/analysis/target.csv");
    }
}