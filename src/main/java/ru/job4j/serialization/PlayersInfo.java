package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println();
        /* JSONObject из json-строки строки */
        JSONObject jsonRank = new JSONObject("{\"points\":1693, "
                + "\"kills\":500, "
                + "\"deaths\":350}");
        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Maurice");
        list.add("John");
        list.add("Nebraska");
        JSONArray jsonNames = new JSONArray(list);
        /* JSONObject напрямую методом put */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", player.getName());
        jsonObject.put("steam", player.isSteam());
        jsonObject.put("time", player.getTime());
        jsonObject.put("rank", jsonRank);
        jsonObject.put("names", jsonNames);
        /* Выведем результат в консоль */
        System.out.println(jsonObject);
        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(player));
    }
}
