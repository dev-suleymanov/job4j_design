package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void whenThisSphereThenVerticesIs0() {
        Box box = new Box(0, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void whenThisTetrahedronThenVerticesIs4() {
        Box box = new Box(4, 4);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(4);
    }

    @Test
    void whenEdgeIs0ThenExistIsFalse() {
        Box box = new Box(5, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void whenEdgeIs4ThenExistIsTrue() {
        Box box = new Box(4, 4);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void whenVerticesIs1ThenAreaIs0() {
        Box box = new Box(1, 0);
        double result = box.getArea();
        assertThat(result).isEqualTo(0.0);
    }

    @Test
    void whenVerticesIs4AndEdgeIs1ThenAreaIs1to73() {
        Box box = new Box(4, 1);
        double result = box.getArea();
        assertThat(result).isCloseTo(1.73, withPrecision(0.001));
    }
}