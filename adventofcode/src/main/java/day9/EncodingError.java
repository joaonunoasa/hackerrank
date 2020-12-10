package day9;

import java.util.List;

public class EncodingError {

    public static Long findFirstNumberForPreambleOf(List<Long> entireList, int preamble) {

        int startIndex = 0;
        int indexToCheck = preamble;

        while (indexToCheck < entireList.size()) {

            List<Long> window = entireList.subList(startIndex, indexToCheck);

            Long numberToCheck = entireList.get(indexToCheck);

            if (thereAreTwoNumberThatSumTheNumber(window, numberToCheck)) {
                startIndex++;
                indexToCheck++;
            } else {
                return numberToCheck;
            }
        }

        throw new RuntimeException("Could not find number");
    }

    private static boolean thereAreTwoNumberThatSumTheNumber(List<Long> window, Long numberToCheck) {
        int indexOfFirstElement = 0;
        int indexOfSecondElement = 1;
        boolean foundTwoNumbers = false;
        while (!foundTwoNumbers && indexOfFirstElement < window.size()-1) {
            Long firstElement = window.get(indexOfFirstElement);
            Long secondElement = window.get(indexOfSecondElement);
            if (firstElement + secondElement == numberToCheck) {
                foundTwoNumbers = true;
            } else {
                indexOfSecondElement++;
                if (indexOfSecondElement == window.size()) {
                    indexOfFirstElement++;
                    indexOfSecondElement = indexOfFirstElement+1;
                }
            }
        }
        return foundTwoNumbers;
    }
}
