package _78_subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // pre check
        if (Objects.isNull(nums)) {
            return Arrays.asList(Collections.emptyList());
        }

        // stop condition
        if (nums.length == 0) {
            return Arrays.asList(Collections.emptyList());
        }

        // array to list
        List<Integer> numList = new ArrayList<>();
        for (int n : nums) {
            numList.add(n);
        }

        // nums.length >= 2
        List<List<Integer>> currentSubsets = new ArrayList<>();
        int chosenNum = numList.get(0);
        List<Integer> otherNumList = numList.subList(1, numList.size());

        List<List<Integer>> nextSubsets = subsets(otherNumList.stream().mapToInt(Integer::intValue).toArray());

        currentSubsets.addAll(nextSubsets);
        for (List<Integer> list : nextSubsets) {
            List<Integer> addChosenNum = new ArrayList<>();
            addChosenNum.add(chosenNum);
            addChosenNum.addAll(list);

            currentSubsets.add(addChosenNum);
        }

        return currentSubsets;
    }
}
