package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.
                toArray("first", "second", "three", "four", "five", "first");
        assertThat(array).isNotEmpty()
                .hasSize(6)
                .contains("first", "three")
                .containsOnly("second", "three", "five", "first", "four")
                .containsExactly("first", "second", "three", "four", "five", "first")
                .containsExactlyInAnyOrder("second", "three", "five", "first", "four", "first")
                .containsAnyOf("six", "zero", "first")
                .doesNotContain("ten", "nine", "eleven")
                .startsWith("first", "second")
                .endsWith("first")
                .containsSequence("three", "four", "five");
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.
                toList(new String[]{"first", "second", "three", "four", "five", "first"});
        assertThat(list).first()
                .isEqualTo("first");
        assertThat(list).element(2)
                .isEqualTo("three");
        assertThat(list).element(list.size() - 1)
                .isEqualTo("first");
        assertThat(list).last()
                .isEqualTo("first");
        assertThat(list).element(1)
                .isNotEqualTo("three");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.
                toSet(new String[]{"first", "second", "three", "four", "five", "first"});
        assertThat(set).isNotNull()
                .filteredOn(e -> e.length() == 4)
                .hasSize(2).first().isEqualTo("four");
        assertThat(set).filteredOn(el -> !el.contains("first"))
                .hasSize(4);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.
                toMap(new String[]{"first", "second", "three", "four", "five", "first"});
        assertThat(map).hasSize(5)
                .containsKey("second")
                .doesNotContainKey("ten")
                .containsEntry("first", 0);
    }
}