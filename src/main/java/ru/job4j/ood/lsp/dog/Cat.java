package ru.job4j.ood.lsp.dog;

public class Cat extends Dog {
    @Override
    public void gav() throws Exception {
        throw new Exception("Кошка не умеет лаять");
    }
}
