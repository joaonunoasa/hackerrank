package day10;

import java.util.List;

public class AdapterArray {

    public static int calculateDifferences(List<Integer> entireList) {
        entireList.add(0);
        int differencesOfOne = 0;
        int differencesOfThree = 0;

        entireList.sort(Integer::compare);

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
            } else {
                differencesOfThree++;
            }
        }

        return differencesOfOne * differencesOfThree;
    }
}
