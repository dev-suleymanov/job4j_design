package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            String line;
            StringBuilder builder = new StringBuilder();
            boolean disabled = false;
            while ((line = reader.readLine()) != null) {
                if (!disabled && (line.startsWith("400") || line.startsWith("500"))
                        || disabled && (line.startsWith("200") || line.startsWith("300"))) {
                    disabled = !disabled;
                    builder.append(line.substring(4)).append(disabled ? ";" : System.lineSeparator());
                }
            }
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/analysis/server.log", "data/analysis/target.csv");
    }
}