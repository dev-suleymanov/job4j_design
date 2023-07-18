package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {
    @Test
    void unavailable(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter(source))) {
            writer.println("200 10:56:01");
            writer.println("500 10:57:01");
            writer.println("400 10:58:01");
            writer.println("300 10:59:01");
            writer.println("500 11:01:02");
            writer.println("200 11:02:02");
            writer.println("400 11:04:06");
            writer.println("200 11:05:11");
        }
        File target = tempDir.resolve("target.txt").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines()
                    .forEach(line -> builder.append(line + System.lineSeparator()));
        }
        String expected = "10:57:01;10:59:01" + System.lineSeparator()
                + "11:01:02;11:02:02" + System.lineSeparator()
                + "11:04:06;11:05:11" + System.lineSeparator();
        assertThat(expected).hasToString(builder.toString());
    }
}