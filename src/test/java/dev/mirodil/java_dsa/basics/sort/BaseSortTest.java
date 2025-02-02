package dev.mirodil.java_dsa.basics.sort;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseSortTest {
    private static final int LARGE_INPUT_SIZE = 10_000;

    protected abstract void sort(String[] array);

    protected abstract void sort(String[] array, String direction);

    protected String[] createTestArray() {
        return new String[]{"apple", "banana", "cherry", "clementine", "date", "date"};
    }

    protected String[] getRandomNames() {
        String[] sortedArrExpected = new String[LARGE_INPUT_SIZE];
        Name name = new Faker().name();
        for (int i = 0; i < LARGE_INPUT_SIZE; i++) {
            sortedArrExpected[i] = name.firstName();
        }
        return sortedArrExpected;
    }

    /// Common sort tests
    @Test
    void testSort_ArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> sort(null));
    }

    @Test
    void testSort_ArrayIsEmpty() {
        String[] emptyArr = {""};
        String[] sortedArr = {""};
        sort(sortedArr);
        assertArrayEquals(sortedArr, emptyArr);
    }

    @Test
    void testSort_DirectionIsNull() {
        assertThrows(IllegalArgumentException.class, () -> sort(createTestArray(), null));
    }

    @Test
    void testSort_InvalidDirections() {
        assertThrows(IllegalArgumentException.class, () -> sort(createTestArray(), "Ascend"));
        assertThrows(IllegalArgumentException.class, () -> sort(createTestArray(), "Descending"));
    }

    @Test
    void testSort_ValidDirections() {
        assertDoesNotThrow(() -> sort(createTestArray(), "DeSc"));
        assertDoesNotThrow(() -> sort(createTestArray(), "aSc"));
    }

    @Test
    void testSort_SortAscCorrectly() {
        String[] sortedArrExpected = createTestArray();
        Arrays.sort(sortedArrExpected);
        String[] sortedArrActual = createTestArray();
        sort(sortedArrActual);
        assertArrayEquals(sortedArrExpected, sortedArrActual);
    }

    @Test
    void testSort_SortAscCorrectly_LargeInput() {
        String[] sortedArrExpected = getRandomNames();

        String[] sortedArrActual = sortedArrExpected.clone();
        Arrays.sort(sortedArrExpected);
        sort(sortedArrActual);
        assertArrayEquals(sortedArrExpected, sortedArrActual);
    }

    @Test
    void testSort_LargeInputPerformance() {
        String[] input = new String[LARGE_INPUT_SIZE];
        for (int i = 0; i < LARGE_INPUT_SIZE; i++) {
            input[i] = "Name" + i;
        }

        long startTime = System.nanoTime();
        sort(input);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        assertTrue(duration < 2000000000); // threshold of 2 seconds
    }

    @Test
    void testSort_SortDescCorrectly() {
        String[] sortedArrExpected = createTestArray();
        Arrays.sort(sortedArrExpected, Collections.reverseOrder());
        String[] sortedArrActual = createTestArray();
        sort(sortedArrActual, "desc");
        assertArrayEquals(sortedArrExpected, sortedArrActual);
    }
}
