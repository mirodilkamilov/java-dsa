package dev.mirodil.java_dsa.basics.sort;

public class SelectionSortTest extends BaseSortTest {

    @Override
    protected void sort(String[] array) {
        SelectionSort.sort(array);
    }

    @Override
    protected void sort(String[] array, String direction) {
        SelectionSort.sort(array, direction);
    }
}
