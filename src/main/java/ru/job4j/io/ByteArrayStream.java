package ru.job4j.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStream {
    public static void main(String[] args) {
        byte[] bytes = {'J', 'a', 'v', 'a'};
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        int data;
        while ((data = stream.read()) != -1) {
            System.out.println((char) data);
        }
        System.out.println();
        String test = "dev.suleymanov.rustam";
        byte[] bytes1 = test.getBytes();
        ByteArrayInputStream stream1 = new ByteArrayInputStream(bytes1, 4, 10);
        int data1;
        while ((data1 = stream1.read()) != -1) {
            System.out.println((char) data1);
        }
        System.out.println();
        ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
        byte[] bytes2 = "nebraska".getBytes();
        stream2.writeBytes(bytes2);
        System.out.println(stream2);
        try (FileOutputStream fileOutputStream = new FileOutputStream("data/message.txt")) {
            stream2.writeTo(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
