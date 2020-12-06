package day6;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CustomCustomsTest {

    @Test
    void shouldWorkForExample1() throws IOException {

        String fileName = "src/test/resources/day6/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Group> groups = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        Group group = new Group(persons);

        while ((line = bufferedReader.readLine()) != null) {

            if (line.equals("")) {
                groups.add(group);
                persons = new ArrayList<>();
                group = new Group(persons);
            } else {
                char[] answers = line.toCharArray();
                Person person = new Person(answers);
                persons.add(person);
            }
        }

        groups.add(group);

        int sum = CustomCustoms.calculateCountFor(groups);

        assertThat(sum, is(3));
    }

    @Test
    void shouldWorkForExample2() throws IOException {

        String fileName = "src/test/resources/day6/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Group> groups = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        Group group = new Group(persons);

        while ((line = bufferedReader.readLine()) != null) {

            if (line.equals("")) {
                groups.add(group);
                persons = new ArrayList<>();
                group = new Group(persons);
            } else {
                char[] answers = line.toCharArray();
                Person person = new Person(answers);
                persons.add(person);
            }
        }

        groups.add(group);

        int sum = CustomCustoms.calculateCountFor(groups);

        assertThat(sum, is(6));
    }

    @Test
    void shouldWorkForExample3() throws IOException {

        String fileName = "src/test/resources/day6/example3.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Group> groups = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        Group group = new Group(persons);

        while ((line = bufferedReader.readLine()) != null) {

            if (line.equals("")) {
                groups.add(group);
                persons = new ArrayList<>();
                group = new Group(persons);
            } else {
                char[] answers = line.toCharArray();
                Person person = new Person(answers);
                persons.add(person);
            }
        }

        groups.add(group);

        int sum = CustomCustoms.calculateCountFor(groups);

        assertThat(sum, is(3323));
    }
}
