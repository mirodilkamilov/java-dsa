package dev.mirodil.java_dsa.basics.sort;

import static dev.mirodil.java_dsa.basics.sort.SortUtil.validateInput;

public class SelectionSort {
    public static void sort(String[] array) {
        validateInput(array);
        sort(array, "ASC");
    }

    public static void sort(String[] array, String direction) {
        validateInput(array, direction);

        boolean isAscending = direction.equalsIgnoreCase("ASC");

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if ((isAscending && array[minIndex].compareTo(array[j]) > 0) ||
                        (!isAscending && array[minIndex].compareTo(array[j]) < 0)) {
                    minIndex = j;
                }
            }
            SortUtil.swap(array, i, minIndex);
        }
    }
}
