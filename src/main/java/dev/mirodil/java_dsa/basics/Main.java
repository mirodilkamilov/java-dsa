package dev.mirodil.java_dsa.basics;

import com.github.javafaker.Faker;
import dev.mirodil.java_dsa.basics.search.BinarySearch;
import dev.mirodil.java_dsa.basics.search.LinearSearch;
import dev.mirodil.java_dsa.basics.sort.SelectionSort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 10_000;
        Faker faker = new Faker();

        String[] names = new String[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            names[i] = faker.name().firstName();
        }
        String searchValue = "Alex";
        Optional<Integer> firstIndex = LinearSearch.searchFirstIndex(names, searchValue);
        firstIndex.ifPresentOrElse(
                index -> System.out.println("LinearSearch: First found at index: " + index),
                () -> System.out.println("LinearSearch: Target not found.")
        );

        List<Integer> allIndexes = LinearSearch.searchAllIndexes(names, searchValue);
        if (allIndexes.isEmpty()) {
            System.out.println("LinearSearch: Target not found.");
        } else {
            System.out.println("LinearSearch: All found at indexes: " + allIndexes);
        }

        SelectionSort.sort(names);
        System.out.println("Array of names is sorted. First 10 elements: " + Arrays.stream(names).limit(10).toList());

        firstIndex = BinarySearch.searchFirstIndex(names, searchValue);
        firstIndex.ifPresentOrElse(
                index -> {
                    System.out.println("BinarySearch: First found at index: " + index);
                    System.out.println("names[" + index + "] = " + names[index]);
                },
                () -> System.out.println("BinarySearch: Target not found.")
        );
    }
}
