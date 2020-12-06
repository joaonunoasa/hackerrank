package day5;

import day4.Passport;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BinaryBoardingTest {

    @Test
    void shouldWorkForExample1() throws IOException {

        String fileName = "src/test/resources/day5/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Seat> seats = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            Seat seat = new Seat(line);
            seats.add(seat);
        }

        int highestSeatId = BinaryBoarding.seatIdFor(seats);

        assertThat(highestSeatId, is(357));
    }

    @Test
    void shouldWorkForExample2() throws IOException {

        String fileName = "src/test/resources/day5/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Seat> seats = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            Seat seat = new Seat(line);
            seats.add(seat);
        }

        int highestSeatId = BinaryBoarding.seatIdFor(seats);

        assertThat(highestSeatId, is(820));
    }

    @Test
    void shouldWorkForExample3() throws IOException {

        String fileName = "src/test/resources/day5/example3.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Seat> seats = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            Seat seat = new Seat(line);
            seats.add(seat);
        }

        int highestSeatId = BinaryBoarding.seatIdFor(seats);
        assertThat(highestSeatId, is(996));
    }
}
