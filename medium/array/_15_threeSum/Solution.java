package medium.array._15_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
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
