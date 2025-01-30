package basics.search;

public class SearchAlgorithmUtil {
    static void validateInput(String[] array, String target) throws IllegalArgumentException {
        if (array == null || target == null) {
            throw new IllegalArgumentException("Array or search target cannot be null");
        }
    }
}
