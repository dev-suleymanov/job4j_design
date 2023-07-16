package ru.job4j.io;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {
    @Test
    void whenLoadValidConfig() {
        String path = "data/valid.properties";
        Config config = new Config(path);
        config.load();
        Map<String, String> actual = config.getMap();
        Map<String, String> expected = Map.of(
                "рустам", "rustam=28",
                "алан", "27=alan",
                "вадим", "vadim=",
                "елена", "elena"
        );
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void whenLoadNotValidConfig() {
        String path = "data/notvalid.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.load())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenGetValue() {
        String path = "data/valid.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("рустам")).isEqualTo("rustam=28");
        assertThat(config.value("алан")).isEqualTo("27=alan");
        assertThat(config.value("олег")).isEqualTo(null);
        assertThat(config.value("#олег")).isEqualTo(null);
        assertThat(config.value("")).isEqualTo(null);
        assertThat(config.value("елена")).isEqualTo("elena");
        assertThat(config.value("вадим")).isEqualTo("vadim=");
    }
}