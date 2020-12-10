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

    public static Long findEncryptionWeakness(List<Long> entireList, Long firstNumber) {

        int indexOfFirstElement = 0;
        int indexOfSecondElement = 1;
        boolean foundSequenceOfNumbers = false;
        Long sum = entireList.get(indexOfFirstElement);
        while (!foundSequenceOfNumbers && indexOfFirstElement < entireList.size()-1) {

            Long secondElement = entireList.get(indexOfSecondElement);
            sum = sum + secondElement;
            if (sum.equals(firstNumber)) {
                foundSequenceOfNumbers = true;
            } else {
                indexOfSecondElement++;
                if (indexOfSecondElement == entireList.size() || sum > firstNumber) {
                    indexOfFirstElement++;
                    indexOfSecondElement = indexOfFirstElement+1;
                    sum = entireList.get(indexOfFirstElement);
                }
            }
        }

        List<Long> contiguousSet = entireList.subList(indexOfFirstElement, indexOfSecondElement + 1);

        Long smallest = smallest(contiguousSet);
        Long largest = largest(contiguousSet);

        return smallest + largest;
    }

    private static Long largest(List<Long> contiguousSet) {
        Long largest = contiguousSet.get(0);

        for (int i = 1; i < contiguousSet.size(); i++) {
            Long numberToEvaluate = contiguousSet.get(i);
            if (numberToEvaluate > largest) {
                largest = numberToEvaluate;
            }
        }

        return largest;
    }

    private static Long smallest(List<Long> contiguousSet) {
        Long smallest = contiguousSet.get(0);

        for (int i = 1; i < contiguousSet.size(); i++) {
            Long numberToEvaluate = contiguousSet.get(i);
            if (numberToEvaluate < smallest) {
                smallest = numberToEvaluate;
            }
        }

        return smallest;
    }
}
