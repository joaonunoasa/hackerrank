package day4;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportProcessing {

    public static int validPassports(List<Passport> passportList) {
        int valid = 0;

        for (Passport passport : passportList) {

            boolean isPasswordValid;

            boolean isCidMissing = passport.getCountryID() == null;

            boolean allFieldsAreValid =
                    isBirthYearValid(passport) &&
                            isIssueYearValid(passport) &&
                            isExpirationYearValid(passport) &&
                            isHeightValid(passport) &&
                            isHairColorValid(passport) &&
                            isEyeColorValid(passport) &&
                            isPassportIDValid(passport)
                    ;

            if (isCidMissing && !allFieldsAreValid) {
                isPasswordValid = false;
            } else if (isCidMissing) {
                isPasswordValid = true;
            } else {
                isPasswordValid = allFieldsAreValid;
            }

            if (isPasswordValid) {
                valid++;
            }
        }

        return valid;
    }

    private static boolean isPassportIDValid(Passport passport) {

        String passportID = passport.getPassportID();

        if (passportID == null) {
            return false;
        }

        if (passportID.length() != 9) {
            return false;
        }

        Pattern pattern = Pattern.compile("[0-9]{9}");
        Matcher matcher = pattern.matcher(passportID);
        return matcher.find();
    }

    private static boolean isEyeColorValid(Passport passport) {

        String eyeColor = passport.getEyeColor();

        if (eyeColor == null) {
            return false;
        }

        if (eyeColor.equals("amb")) {
            return true;
        }

        if (eyeColor.equals("blu")) {
            return true;
        }

        if (eyeColor.equals("brn")) {
            return true;
        }

        if (eyeColor.equals("gry")) {
            return true;
        }

        if (eyeColor.equals("grn")) {
            return true;
        }

        if (eyeColor.equals("hzl")) {
            return true;
        }

        return eyeColor.equals("oth");
    }

    private static boolean isHairColorValid(Passport passport) {
        String hairColor = passport.getHairColor();

        if (hairColor == null) {
            return false;
        }

        Pattern pattern = Pattern.compile("^#([0-9a-f]{6})");
        return pattern.matcher(hairColor).find();
    }

    private static boolean isHeightValid(Passport passport) {
        String height = passport.getHeight();

        if (height == null) {
            return false;
        }

        if (height.contains("cm")) {
            int cm = Integer.parseInt(height.split("cm")[0]);
            return cm >= 150 && cm <= 193;
        }

        if (height.contains("in")) {
            int in = Integer.parseInt(height.split("in")[0]);
            return in >= 59 && in <= 76;
        }

        return false;
    }

    private static boolean isExpirationYearValid(Passport passport) {
        String expirationYear = passport.getExpirationYear();
        return expirationYear != null &&
                expirationYear.length() == 4 &&
                Integer.parseInt(expirationYear) >= 2020 &&
                Integer.parseInt(expirationYear) <= 2030;
    }

    private static boolean isIssueYearValid(Passport passport) {
        String issueYear = passport.getIssueYear();
        return issueYear != null &&
                issueYear.length() == 4 &&
                Integer.parseInt(issueYear) >= 2010 &&
                Integer.parseInt(issueYear) <= 2020;
    }

    private static boolean isBirthYearValid(Passport passport) {
        String birthYear = passport.getBirthYear();
        return birthYear != null &&
                birthYear.length() == 4 &&
                Integer.parseInt(birthYear) >= 1920 &&
                Integer.parseInt(birthYear) <= 2002;
    }
}
