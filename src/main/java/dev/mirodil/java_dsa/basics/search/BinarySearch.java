package dev.mirodil.java_dsa.basics.search;

import java.util.Optional;

import static dev.mirodil.java_dsa.basics.search.SearchAlgorithmUtil.validateInput;

public class BinarySearch {
    public static Optional<Integer> searchFirstIndex(String[] sortedArray, String target) {
        validateInput(sortedArray, target);

        int lowIndex = 0;
        int highIndex = sortedArray.length - 1;

        while (lowIndex <= highIndex) {
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            String guess = sortedArray[middleIndex];
            if (guess.equals(target)) {
                return Optional.of(middleIndex);
            } else if (guess.compareTo(target) < 0) {
                lowIndex = middleIndex + 1;
            } else {
                highIndex = middleIndex - 1;
            }
        }

        return Optional.empty();
    }
}
