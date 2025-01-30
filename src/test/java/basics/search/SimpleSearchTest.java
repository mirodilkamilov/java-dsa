package basics.search;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static basics.search.SimpleSearch.searchAllIndexes;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSearchTest extends BaseSearchTest {
    @Override
    protected Optional<Integer> searchFirstIndex(String[] array, String target) {
        return SimpleSearch.searchFirstIndex(array, target);
    }

//    "apple", "banana", "cherry", "clementine", "date", "date"

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
        Optional<Integer> result = searchFirstIndex(array, "banana");
        assertTrue(result.isPresent());
        assertEquals(1, result.get());
    }

    /// searchAllIndexes tests
    @Test
    void testSearchAllIndexes_OneTargetExists() {
        String[] array = createTestArray();
        List<Integer> result = searchAllIndexes(array, "banana");
        assertEquals(List.of(1), result);
    }

    @Test
    void testSearchAllIndexes_MultipleTargetExists() {
        String[] array = createTestArray();
        List<Integer> result = searchAllIndexes(array, "date");
        assertEquals(2, result.size());
        assertEquals(List.of(4, 5), result);
    }

    @Test
    void testSearchAllIndexes_TargetDoesNotExists() {
        String[] array = createTestArray();
        List<Integer> result = searchAllIndexes(array, "whatever");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchAllIndexes_ArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> searchAllIndexes(null, "whatever"));
    }

    @Test
    void testSearchAllIndexes_ArrayIsEmpty() {
        String[] array = {};
        List<Integer> result = searchAllIndexes(array, "whatever");
        assertTrue(result.isEmpty());
    }
}
