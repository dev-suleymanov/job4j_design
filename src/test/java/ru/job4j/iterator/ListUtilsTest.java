package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.addBefore(input, 1, 5);
        assertThat(input).hasSize(3).containsSequence(1, 5, 3);
        ListUtils.removeIf(input, el -> el != 5);
        assertThat(input).containsSequence(5);
    }

    @Test
    void whenReplaceIf() {
        ListUtils.addAfter(input, 0, -1);
        assertThat(input).hasSize(3).containsSequence(1, -1, 3);
        ListUtils.replaceIf(input, el -> el < 0, 0);
        assertThat(input).containsSequence(1, 0, 3);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.removeAll(input, List.of(1, 3));
        assertThat(input).isEmpty();
    }
}