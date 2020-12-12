package day10;

import java.util.ArrayList;
import java.util.List;

public class AdapterArray {

    public static int calculateDifferences(List<Integer> entireList) {
        entireList.add(0);
        int differencesOfOne = 0;
        int differencesOfThree = 0;

        entireList.sort(Integer::compare);
        entireList.add(entireList.get(entireList.size()-1)+3);

        for (int i = 0; i < entireList.size(); i++) {

            if (i + 1 < entireList.size()) {

                int firstNumber = entireList.get(i);
                int secondNumber = entireList.get(i+1);
                int difference = secondNumber - firstNumber;
                if (difference == 1) {
                    differencesOfOne++;
                }
                if (difference == 3) {
                    differencesOfThree++;
                }
            }
        }

        return differencesOfOne * differencesOfThree;
    }

    public static void calculateArrangements(List<Integer> entireList, List<Sequence> sequences) {

        List<Integer> indexesToBeRemoved = new ArrayList<>();

        for (int i = 0; i < entireList.size()-2; i++) {

            if (i + 1 < entireList.size()) {

                int leftNumber = entireList.get(i);
                int middleNumber = entireList.get(i+1);
                int rightNumber = entireList.get(i+2);

                int difference = rightNumber - leftNumber;
                if (difference <= 3) {
                    indexesToBeRemoved.add(i+1);
                }
            }
        }

        for (Integer indexToBeRemoved : indexesToBeRemoved) {
            List<Integer> nextIteration = cloneListWithoutIndex(entireList, indexToBeRemoved);

            if (!wasSequenceAlreadyAddedToTheList(sequences, nextIteration)) {
                System.out.println(nextIteration);
                sequences.add(new Sequence(nextIteration));
                calculateArrangements(nextIteration, sequences);
            }
        }
    }

    private static boolean wasSequenceAlreadyAddedToTheList(List<Sequence> sequences, List<Integer> sequence) {

        for (int i = 0; i < sequences.size(); i++) {
            List<Integer> sequenceToBeChecked = sequences.get(i).getValues();
            if (areSequencesIdentical(sequenceToBeChecked, sequence)) {
                return true;
            }
        }
        return false;
    }

    private static boolean areSequencesIdentical(List<Integer> sequenceToBeChecked, List<Integer> sequence) {
        if (sequenceToBeChecked.size() != sequence.size()) {
            return false;
        }

        for (int i = 0; i < sequenceToBeChecked.size(); i++) {
            if (!sequenceToBeChecked.get(i).equals(sequence.get(i))) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> cloneListWithoutIndex(List<Integer> entireList, Integer indexToBeRemoved) {
        List<Integer> nextIteration = new ArrayList<>();

        for (int i = 0; i < entireList.size(); i++) {
            if (i != indexToBeRemoved) {
                nextIteration.add(entireList.get(i));
            }
        }
        return nextIteration;
    }
}
