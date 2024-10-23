package ru.job4j.ood.dip.parser;

import java.io.File;

public class ParserService {
    TXTParser txtParser = new TXTParser();

    public void parse(File file) {
        txtParser.txtParse(file);
    }
}
