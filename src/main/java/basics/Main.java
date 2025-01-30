package basics;

import basics.search.BinarySearch;
import basics.search.SimpleSearch;
import com.github.javafaker.Faker;

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
        Optional<Integer> firstIndex = SimpleSearch.searchFirstIndex(names, searchValue);
        firstIndex.ifPresentOrElse(
                index -> System.out.println("SimpleSearch: First found at index: " + index),
                () -> System.out.println("SimpleSearch: Target not found.")
        );

        List<Integer> allIndexes = SimpleSearch.searchAllIndexes(names, searchValue);
        if (allIndexes.isEmpty()) {
            System.out.println("SimpleSearch: Target not found.");
        } else {
            System.out.println("SimpleSearch: All found at indexes: " + allIndexes);
        }

        Arrays.sort(names);
        System.out.println("Array of names is sorted");

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
