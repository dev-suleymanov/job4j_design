package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Disabled
class GeneratorTest {
    @Test
    void whenReturnIsValidResultString() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>(Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        ));
        String result = new GeneratorReal().produce(template, map);
        String expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenReturnExceptionIsNotFoundKey() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>(Map.of(
                "name", "Petr Arsentev"
        ));
        assertThatThrownBy(() -> new GeneratorReal().produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The map does not contain the required key");
    }

    @Test
    void whenReturnExceptionIsContainsExtraKeys() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>(Map.of(
                "name", "Petr Arsentev",
                "subject", "you",
                "test", "test"
        ));
        assertThatThrownBy(() -> new GeneratorReal().produce(template, map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The map contains extra keys");
    }
}