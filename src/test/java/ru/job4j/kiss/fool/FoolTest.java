package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {
    @Test
    void isReturnIntegerToString() {
        assertThat(Fool.printResult(1)).isEqualTo(Integer.toString(1));
    }

    @Test
    void isReturnFizz() {
        assertThat(Fool.printResult(9)).isEqualTo("Fizz");
    }

    @Test
    void isReturnBuzz() {
        assertThat(Fool.printResult(10)).isEqualTo("Buzz");
    }

    @Test
    void isReturnFizzBuzz() {
        assertThat(Fool.printResult(15)).isEqualTo("FizzBuzz");
    }
}