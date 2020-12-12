package day10;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdapterArrayTest {

    @Test
    void shouldWorkForExample1() throws IOException {

        String fileName = "src/test/resources/day10/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Integer> entireList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            entireList.add((Integer.valueOf(line)));
        }

        int differences = AdapterArray.calculateDifferences(entireList);
        assertThat(differences, is(35));

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(entireList));
        AdapterArray.calculateArrangements(entireList, sequences);
        assertThat(sequences.size(), is(8));
    }

    @Test
    void shouldWorkForExample2() throws IOException {

        String fileName = "src/test/resources/day10/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Integer> entireList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            entireList.add((Integer.valueOf(line)));
        }

        int differences = AdapterArray.calculateDifferences(entireList);
        assertThat(differences, is(220));

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(entireList));
        AdapterArray.calculateArrangements(entireList, sequences);
        assertThat(sequences.size(), is(19208));
    }

    @Test
    void shouldWorkForExample3() throws IOException {

        String fileName = "src/test/resources/day10/example3.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Integer> entireList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            entireList.add((Integer.valueOf(line)));
        }

        int differences = AdapterArray.calculateDifferences(entireList);
        assertThat(differences, is(2070));

        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(entireList));
        AdapterArray.calculateArrangements(entireList, sequences);
        assertThat(sequences.size(), is(19208));
    }
}
