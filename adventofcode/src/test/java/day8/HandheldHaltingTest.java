package day8;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HandheldHaltingTest {

    @Test
    void shouldWorkForExample1() throws IOException {

        String fileName = "src/test/resources/day8/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Instruction> instructions = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            String[] operationAndArgument = line.split(" ");
            String operation = operationAndArgument[0];
            String argumentAbsolute = operationAndArgument[1];

            if (argumentAbsolute.charAt(0) == '+') {
                int argument = Integer.parseInt(argumentAbsolute.substring(1));
                instructions.add(new Instruction(operation, argument, false, false));
            }

            if (argumentAbsolute.charAt(0) == '-') {
                int argument = Integer.parseInt(argumentAbsolute.substring(1));
                instructions.add(new Instruction(operation, -argument, false, false));
            }
        }

        int accumulator = HandheldHalting.calculateAccumulatorFor(instructions);

        assertThat(accumulator, is(8));
    }

    @Test
    void shouldWorkForExample2() throws IOException {

        String fileName = "src/test/resources/day8/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Instruction> instructions = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            String[] operationAndArgument = line.split(" ");
            String operation = operationAndArgument[0];
            String argumentAbsolute = operationAndArgument[1];

            if (argumentAbsolute.charAt(0) == '+') {
                int argument = Integer.parseInt(argumentAbsolute.substring(1));
                instructions.add(new Instruction(operation, argument, false, false));
            }

            if (argumentAbsolute.charAt(0) == '-') {
                int argument = Integer.parseInt(argumentAbsolute.substring(1));
                instructions.add(new Instruction(operation, -argument, false, false));
            }
        }

        int accumulator = HandheldHalting.calculateAccumulatorFor(instructions);

        assertThat(accumulator, is(552));
    }
}
