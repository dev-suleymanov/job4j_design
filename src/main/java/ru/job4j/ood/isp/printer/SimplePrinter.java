package ru.job4j.ood.isp.printer;

public class SimplePrinter implements Printer {
    @Override
    public void printDocument(String document) {
        System.out.println("printDocument");
    }

    @Override
    public void scanDocument(String document) {

    }

    @Override
    public void faxDocument(String document) {

    }
}
