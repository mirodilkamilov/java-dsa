package basics.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleSearch {
    public static Optional<Integer> searchFirst(String[] elements, String target) {
        validateInput(elements, target);

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

    public static List<Integer> searchAll(String[] elements, String target) {
        validateInput(elements, target);

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
            return List.of();
        }

        return foundIndexes;
    }

    private static void validateInput(String[] elements, String target) throws IllegalArgumentException {
        if (elements == null || target == null) {
            throw new IllegalArgumentException("Array of elements or search target cannot be null");
        }
    }
}
