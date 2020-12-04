package day3;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TobogganTrajectoryTest {

    @Test
    void shouldPassForFirstExample() throws IOException {

        int verticalPatternSize = 11;
        int horizontalPatternSize = 11;

        String fileName = "src/test/resources/day3/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[][] initialPattern = new String[verticalPatternSize][horizontalPatternSize];
        String line;
        int vertical = 0;
        while ((line = bufferedReader.readLine()) != null) {
            char[] chars = line.toCharArray();
            int horizontal = 0;
            for (char squareOrTree : chars) {
                if (squareOrTree == '.') {
                    initialPattern[vertical][horizontal] = Geology.SQUARE;
                }
                if (squareOrTree == '#') {
                    initialPattern[vertical][horizontal] = Geology.TREE;
                }
                horizontal++;
            }
            vertical++;
        }

        for (int i = 0; i < verticalPatternSize; i++) {
            for (int j = 0; j < horizontalPatternSize; j++) {
                System.out.print(initialPattern[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n\n");

        // repeat pattern
        int repeat = 10;
        int repeatHorizontalSize = verticalPatternSize * (repeat + 1);
        String[][] fullPath = new String[verticalPatternSize][repeatHorizontalSize];

        for (int i = 0; i <= repeat; i++) {
            for (int iniHorizontal = 0, fullHorizontal = 0; iniHorizontal < verticalPatternSize; iniHorizontal++, fullHorizontal++) {
                for (int iniVertical = 0, fullVertical = i * horizontalPatternSize; iniVertical < horizontalPatternSize; iniVertical++, fullVertical++) {
                    fullPath[fullHorizontal][fullVertical] = initialPattern[iniHorizontal][iniVertical];
                }
            }
        }

        int right1Down1 = TobogganTrajectory.howManyTrees(fullPath, 1, 1, verticalPatternSize);
        int right3Down1 = TobogganTrajectory.howManyTrees(fullPath, 3, 1, verticalPatternSize);
        int right5Down1 = TobogganTrajectory.howManyTrees(fullPath, 5, 1, verticalPatternSize);
        int right7Down1 = TobogganTrajectory.howManyTrees(fullPath, 7, 1, verticalPatternSize);
        int right1Down2 = TobogganTrajectory.howManyTrees(fullPath, 1, 2, verticalPatternSize);


        assertThat(right1Down1, is(2));
        assertThat(right3Down1, is(7));
        assertThat(right5Down1, is(3));
        assertThat(right7Down1, is(4));
        assertThat(right1Down2, is(2));

        assertThat(right1Down1*right3Down1*right5Down1*right7Down1*right1Down2, is(336));

    }


    @Test
    void shouldPassForSecondExample() throws IOException {

        int verticalPatternSize = 323;
        int horizontalPatternSize = 31;

        String fileName = "src/test/resources/day3/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[][] initialPattern = new String[verticalPatternSize][horizontalPatternSize];
        String line;
        int vertical = 0;
        while ((line = bufferedReader.readLine()) != null) {
            char[] chars = line.toCharArray();
            int horizontal = 0;
            for (char squareOrTree : chars) {
                if (squareOrTree == '.') {
                    initialPattern[vertical][horizontal] = Geology.SQUARE;
                }
                if (squareOrTree == '#') {
                    initialPattern[vertical][horizontal] = Geology.TREE;
                }
                horizontal++;
            }
            vertical++;
        }

        // repeat pattern
        int repeat = 90;
        int repeatHorizontalSize = verticalPatternSize * (repeat + 1);
        String[][] fullPath = new String[verticalPatternSize][repeatHorizontalSize];

        for (int i = 0; i <= repeat; i++) {
            for (int iniHorizontal = 0, fullHorizontal = 0; iniHorizontal < verticalPatternSize; iniHorizontal++, fullHorizontal++) {
                for (int iniVertical = 0, fullVertical = i * horizontalPatternSize; iniVertical < horizontalPatternSize; iniVertical++, fullVertical++) {
                    fullPath[fullHorizontal][fullVertical] = initialPattern[iniHorizontal][iniVertical];
                }
            }
        }

        int right1Down1 = TobogganTrajectory.howManyTrees(fullPath, 1, 1, verticalPatternSize);
        int right3Down1 = TobogganTrajectory.howManyTrees(fullPath, 3, 1, verticalPatternSize);
        int right5Down1 = TobogganTrajectory.howManyTrees(fullPath, 5, 1, verticalPatternSize);
        int right7Down1 = TobogganTrajectory.howManyTrees(fullPath, 7, 1, verticalPatternSize);
        int right1Down2 = TobogganTrajectory.howManyTrees(fullPath, 1, 2, verticalPatternSize);


        assertThat(right1Down1, is(63));
        assertThat(right3Down1, is(181));
        assertThat(right5Down1, is(55));
        assertThat(right7Down1, is(67));
        assertThat(right1Down2, is(30));

        assertThat(right1Down1*right3Down1*right5Down1*right7Down1*right1Down2, is(1260601650));

    }

}
