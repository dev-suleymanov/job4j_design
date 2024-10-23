package ru.job4j.ood.dip.parser;

import java.io.File;

public class ParserService {
    TXTParser txtParser;

    public ParserService(TXTParser txtParser) {
        this.txtParser = txtParser;
    }

    public void parse(File file) {
        txtParser.txtParse(file);
    }
}
