package basics.search;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public abstract class BaseSearchTest {
    protected abstract Optional<Integer> searchFirstIndex(String[] array, String target);

    protected String[] createTestArray() {
        return new String[]{"apple", "banana", "cherry", "clementine", "date", "date"};
    }

    /// Common searchFirstIndex tests
    @Test
    void testSearchFirstIndex_TargetDoesNotExist() {
        String[] array = createTestArray();
        Optional<Integer> result = searchFirstIndex(array, "whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchFirstIndex_ArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> searchFirstIndex(null, "whatever"));
    }

    @Test
    void testSearchFirstIndex_ArrayIsEmpty() {
        String[] array = {};
        Optional<Integer> result = searchFirstIndex(array, "whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchFirstIndex_SingleElementArray_TargetExist() {
        String[] array = {"apple"};
        Optional<Integer> result = searchFirstIndex(array, "apple");
        assertTrue(result.isPresent());
        assertEquals(0, (int) result.get());
    }

    @Test
    void testSearchFirstIndex_SingleElementArray_TargetDoesNotExist() {
        String[] array = {"apple"};
        Optional<Integer> result = searchFirstIndex(array, "whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchFirstIndex_TargetIsNull() {
        String[] array = createTestArray();
        assertThrows(IllegalArgumentException.class, () -> searchFirstIndex(array, null));
    }
}
