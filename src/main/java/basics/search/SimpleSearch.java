package basics.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleSearch {
    public static Optional<Integer> searchFirst(String[] elements, String target) {
        if (elements == null || target == null) {
            throw new IllegalArgumentException("Array of elements or search target cannot be null");
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                continue;
            }

            if (elements[i].equals(target)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static Optional<List<Integer>> searchAll(String[] elements, String target) {
        if (elements == null || target == null) {
            throw new IllegalArgumentException("Array of elements or search target cannot be null");
        }

        List<Integer> foundIndexes = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                continue;
            }

            if (elements[i].equals(target)) {
                foundIndexes.add(i);
            }
        }

        if (foundIndexes.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(foundIndexes);
    }
}
