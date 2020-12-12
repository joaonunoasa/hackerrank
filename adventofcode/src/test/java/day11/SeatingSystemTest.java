package day11;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SeatingSystemTest {

    @Test
    void shouldWorkForExample1() throws IOException {

        List<Row> initialConfiguration = initialConfiguration();

        List<Row> applyRound1 = SeatingSystem.applyFirstRound(initialConfiguration);
        List<Row> expectedAfterRound1 = expectedAfterRound1();

        for (int row = 0; row < applyRound1.size(); row++) {
            for (int column = 0; column < applyRound1.get(row).getSeats().size(); column++) {
                assertThat(applyRound1.get(row).getSeats().get(column), is(expectedAfterRound1.get(row).getSeats().get(column)));
            }
        }



        List<Row> applyRound2 = SeatingSystem.applySecondRound(applyRound1);
        List<Row> expectedAfterRound2 = expectedAfterRound2();

        for (int row = 0; row < applyRound2.size(); row++) {
            for (int column = 0; column < applyRound2.get(row).getSeats().size(); column++) {
                assertThat(applyRound2.get(row).getSeats().get(column), is(expectedAfterRound2.get(row).getSeats().get(column)));
            }
        }


        //assertThat(occupiedSeats, is(37));
    }

    private List<Row> initialConfiguration() throws IOException {

        String fileName = "src/test/resources/day11/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Row> lines = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            List<Character> seats = new ArrayList<>();
            for (char seat : line.toCharArray()) {
                seats.add(seat);
            }
            lines.add(new Row(seats));
        }
        return lines;
    }

    private List<Row> expectedAfterRound1() throws IOException {

        String fileName = "src/test/resources/day11/expectedFirstRound.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Row> lines = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            List<Character> seats = new ArrayList<>();
            for (char seat : line.toCharArray()) {
                seats.add(seat);
            }
            lines.add(new Row(seats));
        }
        return lines;
    }

    private List<Row> expectedAfterRound2() throws IOException {

        String fileName = "src/test/resources/day11/expectedSecondRound.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Row> lines = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            List<Character> seats = new ArrayList<>();
            for (char seat : line.toCharArray()) {
                seats.add(seat);
            }
            lines.add(new Row(seats));
        }
        return lines;
    }
}
