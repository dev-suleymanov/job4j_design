package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            for (String line : text.toString().split(System.lineSeparator())) {
                int result = Integer.parseInt(line);
                if (result % 2 == 0) {
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}