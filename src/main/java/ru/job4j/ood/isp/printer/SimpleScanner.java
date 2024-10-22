package ru.job4j.ood.isp.printer;

public class SimpleScanner implements Printer {
    @Override
    public void printDocument(String document) {

    }

    @Override
    public void scanDocument(String document) {
        System.out.println("scanDocument");
    }

    @Override
    public void faxDocument(String document) {

    }
}
