package basics.search;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static basics.search.SimpleSearch.searchAllIndexes;
import static basics.search.SimpleSearch.searchFirstIndex;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSearchTest {
    private String[] createTestArray() {
        return new String[]{"apple", "banana", "cherry", "banana", "date"};
    }

    /// searchFirstIndex tests
    @Test
    void testSearchFirstIndex_TargetExists() {
        String[] array = createTestArray();
        Optional<Integer> result = searchFirstIndex(array, "banana");
        assertTrue(result.isPresent());
        assertEquals(1, result.get());
    }

    @Test
    void testSearchFirstIndex_TargetDoesNotExist() {
        String[] array = createTestArray();
        Optional<Integer> result = searchFirstIndex(array, "whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchFirstIndex_ArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> searchFirstIndex(null, "Whatever"));
    }

    @Test
    void testSearchFirstIndex_ArrayIsEmpty() {
        String[] array = {};
        Optional<Integer> result = searchFirstIndex(array, "whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchFirstIndex_TargetIsNull() {
        String[] array = createTestArray();
        assertThrows(IllegalArgumentException.class, () -> searchFirstIndex(array, null));
    }

    /// searchAllIndexes tests
    @Test
    void testSearchAllIndexes_OneTargetExists() {
        String[] array = createTestArray();
        List<Integer> result = searchAllIndexes(array, "date");
        assertEquals(List.of(4), result);
    }

    @Test
    void testSearchAllIndexes_MultipleTargetExists() {
        String[] array = createTestArray();
        List<Integer> result = searchAllIndexes(array, "banana");
        assertEquals(2, result.size());
        assertEquals(List.of(1, 3), result);
    }

    @Test
    void testSearchAllIndexes_TargetDoesNotExists() {
        String[] array = createTestArray();
        List<Integer> result = searchAllIndexes(array, "Whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchAllIndexes_ArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> searchAllIndexes(null, "Whatever"));
    }

    @Test
    void testSearchAllIndexes_ArrayIsEmpty() {
        String[] array = {};
        List<Integer> result = searchAllIndexes(array, "Whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchAllIndexes_TargetIsNull() {
        String[] array = createTestArray();
        assertThrows(IllegalArgumentException.class, () -> searchAllIndexes(array, null));
    }
}
