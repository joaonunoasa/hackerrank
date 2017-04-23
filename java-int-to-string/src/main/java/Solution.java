import java.util.Scanner;

public class Solution {

    public static OperationOutcome calculate(Object n) {

        try {
            int value = (Integer) n;
            if (value == Integer.parseInt(String.valueOf(n))) return OperationOutcome.GOOD_JOB;
            else {
                return OperationOutcome.WRONG_ANSWER;
            }
        } catch (ClassCastException e) {
            return OperationOutcome.UNSUCCESSFULL_TERMINATION;
        }
    }

}
