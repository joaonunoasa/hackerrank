package day4;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PassportProcessingTest {

    @Test
    void shouldPassForFirstExample() throws IOException {

        String fileName = "src/test/resources/day4/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Passport> passportList = new ArrayList<>();
        Passport passport = new Passport();

        while ((line = bufferedReader.readLine()) != null) {

            if (line.equals("")) {
                passportList.add(passport);
                passport = new Passport();
            } else {
                String[] fields = line.split(" ");
                for (String field : fields) {
                    String[] keyValue = field.split(":");
                    String key = keyValue[0];
                    String value = keyValue[1];

                    if (key.equals("byr")) { passport.setBirthYear(value); }
                    if (key.equals("iyr")) { passport.setIssueYear(value); }
                    if (key.equals("eyr")) {passport.setExpirationYear(value); }
                    if (key.equals("hgt")) {passport.setHeight(value); }
                    if (key.equals("hcl")) {passport.setHairColor(value); }
                    if (key.equals("ecl")) {passport.setEyeColor(value); }
                    if (key.equals("pid")) {passport.setPassportID(value); }
                    if (key.equals("cid")) {passport.setCountryID(value); }

                }
            }
        }

        passportList.add(passport);

        int valid = PassportProcessing.validPassports(passportList);

        assertThat(valid, is(2));
    }

    @Test
    void shouldPassForSecondExample() throws IOException {

        String fileName = "src/test/resources/day4/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Passport> passportList = new ArrayList<>();
        Passport passport = new Passport();

        while ((line = bufferedReader.readLine()) != null) {

            if (line.equals("")) {
                passportList.add(passport);
                passport = new Passport();
            } else {
                String[] fields = line.split(" ");
                for (String field : fields) {
                    String[] keyValue = field.split(":");
                    String key = keyValue[0];
                    String value = keyValue[1];

                    if (key.equals("byr")) { passport.setBirthYear(value); }
                    if (key.equals("iyr")) { passport.setIssueYear(value); }
                    if (key.equals("eyr")) {passport.setExpirationYear(value); }
                    if (key.equals("hgt")) {passport.setHeight(value); }
                    if (key.equals("hcl")) {passport.setHairColor(value); }
                    if (key.equals("ecl")) {passport.setEyeColor(value); }
                    if (key.equals("pid")) {passport.setPassportID(value); }
                    if (key.equals("cid")) {passport.setCountryID(value); }

                }
            }
        }

        passportList.add(passport);

        int valid = PassportProcessing.validPassports(passportList);

        assertThat(valid, is(190));
    }
}
