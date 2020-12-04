package day2;

import java.util.List;

public class PasswordPhilosophy {


    public static int countValidPasswords(List<PasswordEntry> lines) {
        int valid = 0;
        for (PasswordEntry passwordEntry: lines) {
            String password = passwordEntry.getPassword();
            PasswordRule passwordRule = passwordEntry.getPasswordRule();
            Integer positionOne = passwordRule.getPositionOne();
            Integer positionTwo = passwordRule.getPositionTwo();
            char charAtPositionOne = password.charAt(positionOne - 1);
            char charAtPositionTwo = password.charAt(positionTwo - 1);

            int occurrences = 0;
            if (passwordEntry.getLetter().toCharArray()[0] == charAtPositionOne) {
                occurrences++;
            }
            if (passwordEntry.getLetter().toCharArray()[0] == charAtPositionTwo) {
                occurrences++;
            }

            if (occurrences == 1) {
                valid++;
            }
        }
        return valid;
    }
}
