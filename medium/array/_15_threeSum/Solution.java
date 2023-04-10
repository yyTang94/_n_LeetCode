package medium.array._15_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // pre check
        if (Objects.isNull(nums) || nums.length <= 2) {
            return Collections.emptyList();
        }

        // sort
        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums);

        List<List<Integer>> threeList = new ArrayList<>();
        Set<String> used = new HashSet<>();
        for (int i = 1; i <= sortedNums.length - 2; i++) {
            int leftPos = 0;
            int rightPos = sortedNums.length - 1;
            while (true) {
                if (leftPos == i || rightPos == i) {
                    break;
                }

                int sumValue = sortedNums[leftPos] + sortedNums[i] + sortedNums[rightPos];
                String concat = String.valueOf(sortedNums[leftPos]) + "-" + String.valueOf(sortedNums[i]) + "-"
                        + String.valueOf(sortedNums[rightPos]);
                if (sumValue == 0) {
                    if (!used.contains(concat)) {
                        threeList.add(Arrays.asList(sortedNums[leftPos], sortedNums[i], sortedNums[rightPos]));
                        used.add(concat);
                    }

                    rightPos--;
                    leftPos++;
                } else {
                    if (sumValue > 0) {
                        rightPos--;
                    } else {
                        leftPos++;
                    }
                }
            }
        }

        return threeList;
    }

    public static List<List<Integer>> threeSumOld(int[] nums) {
        // sort nums
        Arrays.sort(nums);

        //
        List<List<Integer>> tripleList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // jump the repeat num
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // leftIndex & rightIndex
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                if (nums[leftIndex] + nums[rightIndex] == -nums[i]) {
                    List<Integer> triple = new ArrayList<>();
                    triple.add(nums[i]);
                    triple.add(nums[leftIndex]);
                    triple.add(nums[rightIndex]);
                    tripleList.add(triple);

                    while (leftIndex < nums.length - 1) {
                        leftIndex++;
                        if (nums[leftIndex] != nums[leftIndex - 1]) {
                            break;
                        }
                    }
                    while (rightIndex > i + 1) {
                        rightIndex--;
                        if (nums[rightIndex] != nums[rightIndex + 1]) {
                            break;
                        }
                    }
                } else {
                    if (nums[leftIndex] + nums[rightIndex] > -nums[i]) {
                        rightIndex--;
                    } else {
                        leftIndex++;
                    }
                }
            }

        }

        return tripleList;

    }
}
