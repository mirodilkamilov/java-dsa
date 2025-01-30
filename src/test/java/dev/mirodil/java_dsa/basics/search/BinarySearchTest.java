package dev.mirodil.java_dsa.basics.search;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTest extends BaseSearchTest {
    @Override
    protected Optional<Integer> searchFirstIndex(String[] array, String target) {
        return BinarySearch.searchFirstIndex(array, target);
    }

    @Test
    void testSearchFirstIndex_TargetExists() {
        String[] array = createTestArray();
        Optional<Integer> result = searchFirstIndex(array, "banana");
        assertTrue(result.isPresent());
        assertEquals(1, result.get());
    }

    @Test
    void testSearchFirstIndex_TargetExistsWithDuplicates() {
        String[] array = createTestArray();
        Optional<Integer> result = searchFirstIndex(array, "date");
        assertTrue(result.isPresent());
        assertEquals(4, result.get());
    }
}
