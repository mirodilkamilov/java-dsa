package basics;

import basics.search.SimpleSearch;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 10000;
        Faker faker = new Faker();

        String[] names = new String[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            names[i] = faker.name().firstName();
        }
        String searchValue = "Alex";

        Optional<Integer> firstIndex = SimpleSearch.searchFirst(names, searchValue);
        firstIndex.ifPresentOrElse(
                index -> System.out.println("First found at index: " + index),
                () -> System.out.println("Target not found.")
        );

        List<Integer> allIndexes = SimpleSearch.searchAll(names, searchValue);
        if (allIndexes.isEmpty()) {
            System.out.println("Target not found.");
        } else {
            System.out.println("All found at indexes: " + allIndexes);
        }
    }
}
