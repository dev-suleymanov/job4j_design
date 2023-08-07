package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PlayersInfo {
    public static void main(String[] args) {
        final Player player = new Player("Nebraska",
                true, 2592000,
                new Rank(1693, 500, 350),
                new String[]{"Maurice", "John", "Nebraska"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(player));
        final String playerJson =
                "{"
                        + "\"name\":Nebraska,"
                        + "\"steam\":true,"
                        + "\"time\":2592000,"
                        + "\"rank\":"
                        + "{"
                        + "\"points\":1693,"
                        + "\"kills\":500,"
                        + "\"deaths\":350"
                        + "},"
                        + "\"names\":"
                        + "[\"Maurice\", \"John\", \"Nebraska\"]"
                        + "}";
        final Player playerMod = gson.fromJson(playerJson, Player.class);
        System.out.println(playerMod);
    }
}
