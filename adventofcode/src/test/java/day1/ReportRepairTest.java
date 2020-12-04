package day1;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportRepairTest {

    @Test
    public void shouldFixExpenseReportForExample1() throws IOException {

        // Given
        var fileName = "src/test/resources/day1/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(Integer.parseInt(line));
        }
        bufferedReader.close();

        // When
        int value = ReportRepair.fixExpenseReportForTwoEntries(lines);

        // Then
        assertThat(value, is(514579));
    }

    @Test
    public void shouldFixExpenseReportForExample2() throws IOException {

        // Given
        var fileName = "src/test/resources/day1/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(Integer.parseInt(line));
        }
        bufferedReader.close();

        // When
        int value = ReportRepair.fixExpenseReportForTwoEntries(lines);

        // Then
        assertThat(value, is(514579));
    }

    @Test
    public void shouldFixExpenseReportForExample3() throws IOException {

        // Given
        var fileName = "src/test/resources/day1/example3.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(Integer.parseInt(line));
        }
        bufferedReader.close();

        // When
        int value = ReportRepair.fixExpenseReportForTwoEntries(lines);

        // Then
        assertThat(value, is(888331));
    }

    @Test
    public void shouldFixExpenseReportForExample1With3Numbers() throws IOException {

        // Given
        var fileName = "src/test/resources/day1/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(Integer.parseInt(line));
        }
        bufferedReader.close();

        // When
        int value = ReportRepair.fixExpenseReportForThreeEntries(lines);

        // Then
        assertThat(value, is(241861950));
    }

    @Test
    public void shouldFixExpenseReportForExample2With3Numbers() throws IOException {

        // Given
        var fileName = "src/test/resources/day1/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(Integer.parseInt(line));
        }
        bufferedReader.close();

        // When
        int value = ReportRepair.fixExpenseReportForThreeEntries(lines);

        // Then
        assertThat(value, is(241861950));
    }

    @Test
    public void shouldFixExpenseReportForExample3With3Numbers() throws IOException {

        // Given
        var fileName = "src/test/resources/day1/example3.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(Integer.parseInt(line));
        }
        bufferedReader.close();

        // When
        int value = ReportRepair.fixExpenseReportForThreeEntries(lines);

        // Then
        assertThat(value, is(130933530));
    }

}
