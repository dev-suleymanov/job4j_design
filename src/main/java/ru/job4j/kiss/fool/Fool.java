package ru.job4j.kiss.fool;

import java.util.Objects;
import java.util.Scanner;

public class Fool {

    public static String printResult(int start) {
        String result = Integer.toString(start);
        if (start % 3 == 0 && start % 5 == 0) {
            result = "FizzBuzz";
        } else if (start % 3 == 0) {
            result = "Fizz";
        } else if (start % 5 == 0) {
            result = "Buzz";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var io = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(printResult(startAt));
            startAt++;
            var answer = io.nextLine();
            if (!Objects.equals(printResult(startAt), answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }
}