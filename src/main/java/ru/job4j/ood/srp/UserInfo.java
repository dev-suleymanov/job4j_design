package ru.job4j.ood.srp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserInfo {
    private void parseInfo(File file) {
        Map<String, String> map = new HashMap<>();
        /*
            Логика парсинга файла
         */
        saveInfo(map);
    }

    private void saveInfo(Map<String, String> map) {
        /*
            Логика сохранения данных
         */
    }
}
