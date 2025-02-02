package dev.mirodil.java_dsa.basics.sort;

public class SortUtil {
    public static <T> void swap(T[] array, int index1, int index2) {
        if (index1 == index2) {
            return;
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void validateInput(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
    }

    public static void validateInput(String[] array, String direction) {
        if (array == null || direction == null) {
            throw new IllegalArgumentException("Array or sort direction cannot be null");
        }

        validateDirection(direction);
    }

    private static void validateDirection(String direction) throws IllegalArgumentException {
        direction = direction.toUpperCase();
        if (!direction.equals("ASC") && !direction.equals("DESC")) {
            throw new IllegalArgumentException("Direction must be either ASC or DESC");
        }
    }
}
