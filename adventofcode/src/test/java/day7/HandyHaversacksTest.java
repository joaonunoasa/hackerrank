package day7;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HandyHaversacksTest {

    @Test
    void shouldWorkForExample1() throws IOException {

        String fileName = "src/test/resources/day7/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Map<String, List<BagRule>> bagEntries = new HashMap<>();

        while ((line = bufferedReader.readLine()) != null) {

            String[] words = line.split(" ");
            String bagTypeShape = words[0];
            String bagTypeColor = words[1];
            String bagType = bagTypeShape + " " + bagTypeColor;

            String firstQuantity = words[4];

            if (firstQuantity.equals("no")) {
                bagEntries.put(bagType, Collections.emptyList());
            } else {

                List<BagRule> bagRules = new ArrayList<>();
                int indexOfEndOfRule = 7;
                boolean isAComma = words[indexOfEndOfRule].contains(",");

                while (isAComma) {

                    int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                    String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                    String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                    String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                    BagRule bagRule = new BagRule(bagRuleType, quantity);
                    bagRules.add(bagRule);
                    indexOfEndOfRule = indexOfEndOfRule + 4;
                    isAComma = words[indexOfEndOfRule].contains(",");
                }

                int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                BagRule bagRule = new BagRule(bagRuleType, quantity);
                bagRules.add(bagRule);

                bagEntries.put(bagType, bagRules);
            }
        }

        int expectedCount = HandyHaversacks.howManyBagColorsFor("shiny gold", bagEntries);

        assertThat(expectedCount, is(4));
    }

    @Test
    void shouldWorkForExample1Part2() throws IOException {

        String fileName = "src/test/resources/day7/example1.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Map<String, List<BagRule>> bagEntries = new HashMap<>();

        while ((line = bufferedReader.readLine()) != null) {

            String[] words = line.split(" ");
            String bagTypeShape = words[0];
            String bagTypeColor = words[1];
            String bagType = bagTypeShape + " " + bagTypeColor;

            String firstQuantity = words[4];

            if (firstQuantity.equals("no")) {
                bagEntries.put(bagType, Collections.emptyList());
            } else {

                List<BagRule> bagRules = new ArrayList<>();
                int indexOfEndOfRule = 7;
                boolean isAComma = words[indexOfEndOfRule].contains(",");

                while (isAComma) {

                    int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                    String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                    String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                    String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                    BagRule bagRule = new BagRule(bagRuleType, quantity);
                    bagRules.add(bagRule);
                    indexOfEndOfRule = indexOfEndOfRule + 4;
                    isAComma = words[indexOfEndOfRule].contains(",");
                }

                int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                BagRule bagRule = new BagRule(bagRuleType, quantity);
                bagRules.add(bagRule);

                bagEntries.put(bagType, bagRules);
            }
        }

        // 1 + 1*7 + 2 + 2*11
        int expectedCount = HandyHaversacks.howManyIndividualBagsFor("shiny gold", bagEntries);

        assertThat(expectedCount, is(32));
    }

    @Test
    void shouldWorkForExample2() throws IOException {

        String fileName = "src/test/resources/day7/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Map<String, List<BagRule>> bagEntries = new HashMap<>();

        while ((line = bufferedReader.readLine()) != null) {

            String[] words = line.split(" ");
            String bagTypeShape = words[0];
            String bagTypeColor = words[1];
            String bagType = bagTypeShape + " " + bagTypeColor;

            String firstQuantity = words[4];

            if (firstQuantity.equals("no")) {
                bagEntries.put(bagType, Collections.emptyList());
            } else {

                List<BagRule> bagRules = new ArrayList<>();
                int indexOfEndOfRule = 7;
                boolean isAComma = words[indexOfEndOfRule].contains(",");

                while (isAComma) {

                    int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                    String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                    String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                    String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                    BagRule bagRule = new BagRule(bagRuleType, quantity);
                    bagRules.add(bagRule);
                    indexOfEndOfRule = indexOfEndOfRule + 4;
                    isAComma = words[indexOfEndOfRule].contains(",");
                }

                int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                BagRule bagRule = new BagRule(bagRuleType, quantity);
                bagRules.add(bagRule);

                bagEntries.put(bagType, bagRules);
            }
        }

        int expectedCount = HandyHaversacks.howManyBagColorsFor("shiny gold", bagEntries);

        assertThat(expectedCount, is(142));
    }

    @Test
    void shouldWorkForExample2Part2() throws IOException {

        String fileName = "src/test/resources/day7/example2.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Map<String, List<BagRule>> bagEntries = new HashMap<>();

        while ((line = bufferedReader.readLine()) != null) {

            String[] words = line.split(" ");
            String bagTypeShape = words[0];
            String bagTypeColor = words[1];
            String bagType = bagTypeShape + " " + bagTypeColor;

            String firstQuantity = words[4];

            if (firstQuantity.equals("no")) {
                bagEntries.put(bagType, Collections.emptyList());
            } else {

                List<BagRule> bagRules = new ArrayList<>();
                int indexOfEndOfRule = 7;
                boolean isAComma = words[indexOfEndOfRule].contains(",");

                while (isAComma) {

                    int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                    String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                    String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                    String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                    BagRule bagRule = new BagRule(bagRuleType, quantity);
                    bagRules.add(bagRule);
                    indexOfEndOfRule = indexOfEndOfRule + 4;
                    isAComma = words[indexOfEndOfRule].contains(",");
                }

                int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                BagRule bagRule = new BagRule(bagRuleType, quantity);
                bagRules.add(bagRule);

                bagEntries.put(bagType, bagRules);
            }
        }

        int expectedCount = HandyHaversacks.howManyIndividualBagsFor("shiny gold", bagEntries);

        assertThat(expectedCount, is(10219));
    }

    @Test
    void shouldWorkForExample3() throws IOException {

        String fileName = "src/test/resources/day7/example3.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Map<String, List<BagRule>> bagEntries = new HashMap<>();

        while ((line = bufferedReader.readLine()) != null) {

            String[] words = line.split(" ");
            String bagTypeShape = words[0];
            String bagTypeColor = words[1];
            String bagType = bagTypeShape + " " + bagTypeColor;

            String firstQuantity = words[4];

            if (firstQuantity.equals("no")) {
                bagEntries.put(bagType, Collections.emptyList());
            } else {

                List<BagRule> bagRules = new ArrayList<>();
                int indexOfEndOfRule = 7;
                boolean isAComma = words[indexOfEndOfRule].contains(",");

                while (isAComma) {

                    int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                    String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                    String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                    String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                    BagRule bagRule = new BagRule(bagRuleType, quantity);
                    bagRules.add(bagRule);
                    indexOfEndOfRule = indexOfEndOfRule + 4;
                    isAComma = words[indexOfEndOfRule].contains(",");
                }

                int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                BagRule bagRule = new BagRule(bagRuleType, quantity);
                bagRules.add(bagRule);

                bagEntries.put(bagType, bagRules);
            }
        }

        // 2 + (4 + (8 + (16 + 32 + 64))
        int expectedCount = HandyHaversacks.howManyIndividualBagsFor("shiny gold", bagEntries);

        assertThat(expectedCount, is(126));
    }

    @Test
    void shouldWorkForExample3Part2() throws IOException {

        String fileName = "src/test/resources/day7/example3.txt";
        FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        Map<String, List<BagRule>> bagEntries = new HashMap<>();

        while ((line = bufferedReader.readLine()) != null) {

            String[] words = line.split(" ");
            String bagTypeShape = words[0];
            String bagTypeColor = words[1];
            String bagType = bagTypeShape + " " + bagTypeColor;

            String firstQuantity = words[4];

            if (firstQuantity.equals("no")) {
                bagEntries.put(bagType, Collections.emptyList());
            } else {

                List<BagRule> bagRules = new ArrayList<>();
                int indexOfEndOfRule = 7;
                boolean isAComma = words[indexOfEndOfRule].contains(",");

                while (isAComma) {

                    int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                    String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                    String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                    String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                    BagRule bagRule = new BagRule(bagRuleType, quantity);
                    bagRules.add(bagRule);
                    indexOfEndOfRule = indexOfEndOfRule + 4;
                    isAComma = words[indexOfEndOfRule].contains(",");
                }

                int quantity = Integer.parseInt(words[indexOfEndOfRule - 3]);
                String bagRuleTypeShape = words[indexOfEndOfRule - 2];
                String bagRuleTypeColor = words[indexOfEndOfRule - 1];
                String bagRuleType = bagRuleTypeShape + " " + bagRuleTypeColor;
                BagRule bagRule = new BagRule(bagRuleType, quantity);
                bagRules.add(bagRule);

                bagEntries.put(bagType, bagRules);
            }
        }

        int expectedCount = HandyHaversacks.howManyBagColorsFor("shiny gold", bagEntries);

        assertThat(expectedCount, is(0));
    }


}
