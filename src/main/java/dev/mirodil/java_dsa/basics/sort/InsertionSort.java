package dev.mirodil.java_dsa.basics.sort;

public class InsertionSort {
    public static void sort(String[] array) {
        validateInput(array);

        for (int i = 0; i < array.length - 1; i++) {
            int firstElementIndex = i;
            for (int j = firstElementIndex + 1; j > 0; j--) {
                String firstElement = array[firstElementIndex];
                String secondElement = array[j];
                if (firstElement == null || secondElement == null) {
                    throw new IllegalArgumentException("Array elements must not be null. " +
                            "Please check elements at the indexes: " + firstElementIndex + " and " + j);
                }

                boolean isAlreadySorted = firstElement.compareTo(secondElement) <= 0;
                if (isAlreadySorted) {
                    break;
                }

                swap(array, firstElementIndex, j);
                firstElementIndex--;
            }
        }
    }

    private static void swap(String[] array, int index1, int index2) {
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void validateInput(String[] array) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
    }
}
