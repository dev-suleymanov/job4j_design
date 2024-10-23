package ru.job4j.ood.dip.db;

class DataService {
    private MySQLDatabase database;

    public DataService(MySQLDatabase database) {
        this.database = database;
    }

    public void save(String data) {
        database.saveData(data);
    }
}