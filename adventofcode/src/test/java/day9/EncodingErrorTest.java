package day9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EncodingErrorTest {


    @Test
    void shouldWorkForExample1() throws IOException {

        String fileName = "src/test/resources/day9/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Long> entireList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            entireList.add((Long.valueOf(line)));
        }

        Long firstNumber = EncodingError.findFirstNumberForPreambleOf(entireList, 5);
        assertThat(firstNumber, is(127L));

        Long encryptionWeakness = EncodingError.findEncryptionWeakness(entireList, firstNumber);
        assertThat(encryptionWeakness, is(62L));
    }

    @Test
    void shouldWorkForExample2() throws IOException {

        String fileName = "src/test/resources/day9/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Long> entireList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            entireList.add((Long.valueOf(line)));
        }

        Long firstNumber = EncodingError.findFirstNumberForPreambleOf(entireList, 5);
        assertThat(firstNumber, is(127L));

        Long encryptionWeakness = EncodingError.findEncryptionWeakness(entireList, firstNumber);
        assertThat(encryptionWeakness, is(62L));
    }


    @Test
    void shouldWorkForExample3() throws IOException {

        String fileName = "src/test/resources/day9/example3.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Long> entireList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            entireList.add((Long.valueOf(line)));
        }

        Assertions.assertThrows(RuntimeException.class,
                () -> EncodingError.findFirstNumberForPreambleOf(entireList, 5));
    }


    @Test
    void shouldWorkForExample4() throws IOException {

        String fileName = "src/test/resources/day9/example4.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Long> entireList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            entireList.add((Long.valueOf(line)));
        }

        Long firstNumber = EncodingError.findFirstNumberForPreambleOf(entireList, 25);

        assertThat(firstNumber, is(10884537L));

        Long encryptionWeakness = EncodingError.findEncryptionWeakness(entireList, firstNumber);
        assertThat(encryptionWeakness, is(1261309L));
    }
}
