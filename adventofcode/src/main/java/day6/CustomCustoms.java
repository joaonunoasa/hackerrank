package day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomCustoms {

    public static int calculateCountFor(List<Group> groups) {

        int count = 0;
        for (Group group : groups) {
            Map<Character, Integer> countPositiveAnswersMap = new HashMap<>();
            List<Person> persons = group.getPersons();
            for (Person person : persons) {
                char[] answers = person.getAnswers();
                for (char answer : answers) {

                    if (countPositiveAnswersMap.containsKey(answer)) {
                        Integer occurrences = countPositiveAnswersMap.get(answer);
                        countPositiveAnswersMap.put(answer, occurrences + 1);
                    } else {
                        countPositiveAnswersMap.put(answer, 1);
                    }
                }
            }

            for (Character answer : countPositiveAnswersMap.keySet()) {
                Integer occurrences = countPositiveAnswersMap.get(answer);
                if (occurrences == persons.size()) {
                    count++;
                }
            }
        }

        return count;
    }
}
