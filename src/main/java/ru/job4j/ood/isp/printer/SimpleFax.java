package ru.job4j.ood.isp.printer;

public class SimpleFax implements Printer {
    @Override
    public void printDocument(String document) {

    }

    @Override
    public void scanDocument(String document) {

    }

    @Override
    public void faxDocument(String document) {
        System.out.println("faxDocument");
    }
}
