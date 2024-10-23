package ru.job4j.ood.lsp.football;

public class Swimming extends Football {
    @Override
    public void gol() throws Exception {
        throw new Exception("В плавании не существует голов");
    }
}
