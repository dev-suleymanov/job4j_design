package ru.job4j.serialization;

import java.util.Arrays;

public class Player {
    private final String name;
    private final boolean steam;
    private final int time;
    private final Rank rank;
    private final String[] names;

    public Player(String name, boolean steam, int time, Rank rank, String[] names) {
        this.name = name;
        this.steam = steam;
        this.time = time;
        this.rank = rank;
        this.names = names;
    }

    public String getName() {
        return name;
    }

    public boolean isSteam() {
        return steam;
    }

    public int getTime() {
        return time;
    }

    public Rank getRank() {
        return rank;
    }

    public String[] getNames() {
        return names;
    }

    @Override
    public String toString() {
        return "Player{"
                + "name='" + name + '\''
                + ", steam=" + steam
                + ", time=" + time
                + ", rank=" + rank
                + ", names=" + Arrays.toString(names)
                + '}';
    }
}
