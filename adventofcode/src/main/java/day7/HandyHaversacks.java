package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandyHaversacks {

    public static int howManyBagColorsFor(String bagType, Map<String, List<BagRule>> bagEntries) {

        List<String> bagTypesThatCanContainBagType = new ArrayList<>();

        for (String bagEntryKey : bagEntries.keySet()) {
            List<BagRule> bagRules = bagEntries.get(bagEntryKey);
            for (BagRule bagRule : bagRules) {
                String bagRuleType = bagRule.getBagType();
                if (bagRuleType.equals(bagType)) {
                    if (!bagTypesThatCanContainBagType.contains(bagEntryKey)) {
                        bagTypesThatCanContainBagType.add(bagEntryKey);
                        recursiveFunctionFor(bagEntryKey, bagEntries, bagTypesThatCanContainBagType);
                    }
                }
            }
        }

        return bagTypesThatCanContainBagType.size();
    }

    private static void recursiveFunctionFor(String bagRuleType, Map<String, List<BagRule>> bagEntries, List<String> bagTypesThatCanContainBagType) {

        for (String bagEntryKey : bagEntries.keySet()) {
            List<BagRule> bagRules = bagEntries.get(bagEntryKey);
            for (BagRule bagRule : bagRules) {
                String newBagRuleType = bagRule.getBagType();
                if (newBagRuleType.equals(bagRuleType)) {
                    if (!bagTypesThatCanContainBagType.contains(bagEntryKey)) {
                        bagTypesThatCanContainBagType.add(bagEntryKey);
                        recursiveFunctionFor(bagEntryKey, bagEntries, bagTypesThatCanContainBagType);
                    }
                }
            }
        }
    }

    public static int howManyIndividualBagsFor(String bagType, Map<String, List<BagRule>> bagEntries) {

        List<BagRule> bagRules = bagEntries.get(bagType);

        if (bagRules.size() == 0) {
            return 1;
        }

        int sum = 0;
        for (BagRule bagRule : bagRules) {
            String bagRuleType = bagRule.getBagType();
            int bagRuleMaxQuantity = bagRule.getMaxQuantity();
            sum = sum + bagRuleMaxQuantity + (bagRuleMaxQuantity * bagsInsideBags(bagRuleType, bagEntries));
        }

        return sum;
    }

    private static int bagsInsideBags(String bagRuleType, Map<String, List<BagRule>> bagEntries) {

        List<BagRule> bagRules = bagEntries.get(bagRuleType);

        int sum = 0;
        for (BagRule bagRule : bagRules) {
            String newBagRuleType = bagRule.getBagType();
            int bagRuleMaxQuantity = bagRule.getMaxQuantity();
            if (bagEntries.get(newBagRuleType).size() == 0) {
                sum = sum + bagRuleMaxQuantity;
            } else {
                sum = sum + bagRuleMaxQuantity + (bagRuleMaxQuantity * bagsInsideBags(newBagRuleType, bagEntries));
            }
        }

        return sum;
    }

}
