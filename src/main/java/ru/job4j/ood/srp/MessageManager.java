package ru.job4j.ood.srp;

public interface MessageManager {
    void printToEmail(String message);
    void printToMobile(String message);
    void printToTelegram(String message);
}
