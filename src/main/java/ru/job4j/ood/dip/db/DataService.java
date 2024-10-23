package ru.job4j.ood.dip.db;

class DataService {
    private MySQLDatabase database = new MySQLDatabase();

    public void save(String data) {
        database.saveData(data);
    }
}