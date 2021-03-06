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

        List<Row> initialConfiguration = loadFromFile("example1.txt");

        List<Row> applyRound1 = SeatingSystem.applyFirstRound(initialConfiguration);
        List<Row> expectedAfterRound1 = loadFromFile("expectedFirstRound.txt");
        assertThat(SeatingSystem.seatConfigurationsAreEqual(applyRound1, expectedAfterRound1), is(true));

        List<Row> applyRound2 = SeatingSystem.applySecondRound(applyRound1);
        List<Row> expectedAfterRound2 = loadFromFile("expectedSecondRound.txt");
        assertThat(SeatingSystem.seatConfigurationsAreEqual(applyRound2, expectedAfterRound2), is(true));

        List<Row> applyRound3 = SeatingSystem.applyFirstRound(applyRound2);
        List<Row> expectedAfterRound3 = loadFromFile("expectedThirdRound.txt");
        assertThat(SeatingSystem.seatConfigurationsAreEqual(applyRound3, expectedAfterRound3), is(true));

        List<Row> applyRound4 = SeatingSystem.applySecondRound(applyRound3);
        List<Row> expectedAfterRound4 = loadFromFile("expectedForthRound.txt");
        assertThat(SeatingSystem.seatConfigurationsAreEqual(applyRound4, expectedAfterRound4), is(true));

        List<Row> applyRound5 = SeatingSystem.applyFirstRound(applyRound4);
        List<Row> expectedAfterRound5 = loadFromFile("expectedFifthRound.txt");
        assertThat(SeatingSystem.seatConfigurationsAreEqual(applyRound5, expectedAfterRound5), is(true));

        int occupiedSeats =SeatingSystem.occupiedSeats(applyRound5);
        assertThat(occupiedSeats, is(37));
    }



    private List<Row> loadFromFile(String file) throws IOException {

        String fileName = "src/test/resources/day11/" + file;
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
