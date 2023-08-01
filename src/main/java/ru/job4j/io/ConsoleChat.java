package ru.job4j.io;

import java.awt.event.InputEvent;
import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        boolean disabled = false;
        boolean stop = false;
        while (!disabled) {
            System.out.print("Пожалуйста, введите любое слово или предложение: ");
            String line = in.nextLine();
            result.add(String.format("USER: %s", line));
            disabled = Objects.equals(line, OUT);
            if (Objects.equals(line, STOP)) {
                stop = true;
            }
            if (Objects.equals(line, CONTINUE)) {
                stop = false;
            }
            if (!disabled && !stop) {
                String temp = String.format("BOT: %s", readPhrases().
                        get(new Random().nextInt(readPhrases().size())));
                System.out.println(temp);
                result.add(temp);
            }
        }
        saveLog(result);
    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Path.of(botAnswers).toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path.of(path).toFile()))) {
            for (String line : log) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/console/log.txt", "data/console/console.txt");
        cc.run();
    }
}