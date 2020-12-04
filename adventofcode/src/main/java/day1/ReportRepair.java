package day1;

import java.util.List;

public class ReportRepair {

    public static int fixExpenseReportForTwoEntries(List<Integer> lines) {

        int size = lines.size();

        for (int i = 0; i < (size - 1); i++) {
            for (int y = i + 1; y < size; y++) {
                Integer first = lines.get(i);
                Integer second = lines.get(y);
                if (first + second == 2020) {
                    return first * second;
                }
            }
        }

        return 0;
    }

    public static int fixExpenseReportForThreeEntries(List<Integer> lines) {

        int size = lines.size();

        for (int i = 0; i < (size - 2); i++) {
            for (int y = i + 1; y < (size - 1); y++) {
                for (int z = y + 1; z < size; z++) {
                    Integer first = lines.get(i);
                    Integer second = lines.get(y);
                    Integer third = lines.get(z);
                    if (first + second + third== 2020) {
                        return first * second * third;
                    }
                }
            }
        }

        return 0;
    }
}
