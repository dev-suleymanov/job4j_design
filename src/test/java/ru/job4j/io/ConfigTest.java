package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "data/config/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class")).
                isEqualTo("org.postgresql.Driver=17");
        assertThat(config.value("hibernate.connection.username")).
                isEqualTo("postgres");
        assertThat(config.value("hibernate.connection.password")).
                isEqualTo("1995=password");
    }

    @Test
    void whenPairWithCommentAndEmptyLines() {
        String path = "data/config/pair_with_comment.properties";
        Config config = new Config(path);
        assertThatThrownBy(() -> config.value("#hibernate.connection.driver_class"))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Don't impl this method yet!");
        assertThatThrownBy(() -> config.value("#hibernate.connection.username"))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Don't impl this method yet!");
        assertThatThrownBy(() -> config.value(""))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Don't impl this method yet!");
        assertThatThrownBy(() -> config.value("#hibernate.connection.password"))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Don't impl this method yet!");
    }

    @Test
    void whenWithoutKey() {
        String path = "data/config/without_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This config has an incorrect storage format key=value");
    }

    @Test
    void whenWithoutValue() {
        String path = "data/config/without_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This config has an incorrect storage format key=value");
    }

    @Test
    void whenWithoutKeyAndValue() {
        String path = "data/config/without_kv.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("This config has an incorrect storage format key=value");
    }
}