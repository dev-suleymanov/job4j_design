package ru.job4j.ood.isp.printer;

public interface Printer {
    void printDocument(String document);
    void scanDocument(String document);
    void faxDocument(String document);
}