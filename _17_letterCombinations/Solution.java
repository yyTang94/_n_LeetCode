package _17_letterCombinations;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    private final Map<String, List<String>> digitToLetter = Stream.of(
            new AbstractMap.SimpleEntry<>("2", Stream.of("a", "b", "c").collect(Collectors.toList())),
            new AbstractMap.SimpleEntry<>("3", Stream.of("d", "e", "f").collect(Collectors.toList())),
            new AbstractMap.SimpleEntry<>("4", Stream.of("g", "h", "i").collect(Collectors.toList())),
            new AbstractMap.SimpleEntry<>("5", Stream.of("j", "k", "l").collect(Collectors.toList())),
            new AbstractMap.SimpleEntry<>("6", Stream.of("m", "n", "o").collect(Collectors.toList())),
            new AbstractMap.SimpleEntry<>("7", Stream.of("p", "q", "r", "s").collect(Collectors.toList())),
            new AbstractMap.SimpleEntry<>("8", Stream.of("t", "u", "v").collect(Collectors.toList())),
            new AbstractMap.SimpleEntry<>("9", Stream.of("w", "x", "y", "z").collect(Collectors.toList())))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private List<String> doLetterCombinations(List<List<String>> listOfStrings) {
        if (listOfStrings.size() == 1) {
            return listOfStrings.get(0);
        }

        List<String> resultList = new ArrayList<>();
        List<String> subResultList = doLetterCombinations(listOfStrings.subList(1, listOfStrings.size()));
        for (String prefix : listOfStrings.get(0)) {
            for (String sub : subResultList) {
                resultList.add(prefix + sub);
            }
        }

        return resultList;
    }

    public List<String> letterCombinations(String digits) {
        // pre check
        if (Objects.isNull(digits) || digits.equals("")) {
            return new ArrayList<>();
        }

        List<List<String>> listOfStrings = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String s = String.valueOf(digits.charAt(i));
            listOfStrings.add(digitToLetter.get(s));
        }

        return doLetterCombinations(listOfStrings);
    }
}
