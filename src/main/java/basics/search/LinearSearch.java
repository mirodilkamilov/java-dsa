package basics.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static basics.search.SearchAlgorithmUtil.validateInput;

public class LinearSearch {
    public static Optional<Integer> searchFirstIndex(String[] array, String target) {
        validateInput(array, target);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }

            if (array[i].equals(target)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public static List<Integer> searchAllIndexes(String[] array, String target) {
        validateInput(array, target);

        List<Integer> foundIndexes = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }

            if (array[i].equals(target)) {
                foundIndexes.add(i);
            }
        }

        if (foundIndexes.isEmpty()) {
            return List.of();
        }

        return foundIndexes;
    }
}
