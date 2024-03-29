package ru.job4j.serialization;

public class Rank {
    private final int points;
    private final int kills;
    private final int deaths;

    public int getPoints() {
        return points;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public Rank(int points, int kills, int deaths) {
        this.points = points;
        this.kills = kills;
        this.deaths = deaths;
    }

    @Override
    public String toString() {
        return "Rank{"
                + "points=" + points
                + ", kills=" + kills
                + ", deaths=" + deaths
                + '}';
    }
}
