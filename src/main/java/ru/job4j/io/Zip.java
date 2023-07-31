package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static ru.job4j.io.Search.search;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateArgs(String directory, String exclude, String output) {
        if (!new File(directory).isDirectory()) {
            throw new IllegalArgumentException(String.format("The \"%s\" directory does not exist", directory));
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException("The file extension must start with \".\"");
        }
        if (exclude.length() < 3) {
            throw new IllegalArgumentException("The length of the extension must be at least three characters");
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException("The archive name must have the \".zip\" extension");
        }
        if (output.split("\\.")[0].isEmpty()) {
            throw new IllegalArgumentException("The archive name should not be empty");
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("The number of arguments should be three");
        }
        ArgsName argsName = ArgsName.of(args);
        String directory = argsName.get("d");
        String exclude = argsName.get("e");
        String output = argsName.get("o");
        Zip zip = new Zip();
        zip.validateArgs(directory, exclude, output);
        zip.packFiles(search(Paths.get(directory), p -> p.endsWith(exclude)),
                new File(String.format(String.format("%s/%s", directory, output))));
    }
}