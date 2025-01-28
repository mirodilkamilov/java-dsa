package basics.search;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static basics.search.SimpleSearch.searchAll;
import static basics.search.SimpleSearch.searchFirst;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSearchTest {
    private String[] createTestArray() {
        return new String[]{"apple", "banana", "cherry", "banana", "date"};
    }

    /// searchFirst tests
    @Test
    void testSearchFirst_TargetExists() {
        String[] array = createTestArray();
        Optional<Integer> result = searchFirst(array, "banana");
        assertTrue(result.isPresent());
        assertEquals(1, result.get());
    }

    @Test
    void testSearchFirst_TargetDoesNotExist() {
        String[] array = createTestArray();
        Optional<Integer> result = searchFirst(array, "whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchFirst_ArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> searchFirst(null, "Whatever"));
    }

    @Test
    void testSearchFirst_ArrayIsEmpty() {
        String[] array = {};
        Optional<Integer> result = searchFirst(array, "whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchFirst_TargetIsNull() {
        String[] array = createTestArray();
        assertThrows(IllegalArgumentException.class, () -> searchFirst(array, null));
    }

    /// searchAll tests
    @Test
    void testSearchAll_OneTargetExists() {
        String[] array = createTestArray();
        Optional<List<Integer>> result = searchAll(array, "date");
        assertTrue(result.isPresent());
        assertEquals(List.of(4), result.get());
    }

    @Test
    void testSearchAll_MultipleTargetExists() {
        String[] array = createTestArray();
        Optional<List<Integer>> result = searchAll(array, "banana");
        assertTrue(result.isPresent());
        assertEquals(2, result.get().size());
        assertEquals(List.of(1, 3), result.get());
    }

    @Test
    void testSearchAll_TargetDoesNotExists() {
        String[] array = createTestArray();
        Optional<List<Integer>> result = searchAll(array, "Whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchAll_ArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> searchAll(null, "Whatever"));
    }

    @Test
    void testSearchAll_ArrayIsEmpty() {
        String[] array = {};
        Optional<List<Integer>> result = searchAll(array, "Whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchAll_TargetIsNull() {
        String[] array = createTestArray();
        assertThrows(IllegalArgumentException.class, () -> searchAll(array, null));
    }
}
