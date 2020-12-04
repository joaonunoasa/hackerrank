package day2;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PasswordPhilosophyTest {

    @Test
    public void shouldWorkForExample1() throws IOException {

        // Given
        String fileName = "src/test/resources/day2/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<PasswordEntry> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] entry = line.split(" ");
            String[] passwordRule = entry[0].split("-");
            int positionOne = Integer.parseInt(passwordRule[0]);
            int positionTwo = Integer.parseInt(passwordRule[1]);
            String letter = entry[1].split(":")[0];
            String password = entry[2];
            PasswordEntry passwordEntry = new PasswordEntry(new PasswordRule(positionOne, positionTwo), letter, password);
            lines.add(passwordEntry);
        }
        bufferedReader.close();

        // When
        int value = PasswordPhilosophy.countValidPasswords(lines);

        // Then
        assertThat(value, is(1));
    }


    @Test
    public void shouldWorkForExample2() throws IOException {

        // Given
        String fileName = "src/test/resources/day2/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<PasswordEntry> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] entry = line.split(" ");
            String[] passwordRule = entry[0].split("-");
            int atLeast = Integer.parseInt(passwordRule[0]);
            int atMost = Integer.parseInt(passwordRule[1]);
            String letter = entry[1].split(":")[0];
            String password = entry[2];
            PasswordEntry passwordEntry = new PasswordEntry(new PasswordRule(atLeast, atMost), letter, password);
            lines.add(passwordEntry);
        }
        bufferedReader.close();

        // When
        int value = PasswordPhilosophy.countValidPasswords(lines);

        // Then
        assertThat(value, is(558));
    }

}
