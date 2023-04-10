package easy.array._1_twoSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // pre check
        if (Objects.isNull(nums) || nums.length <= 1) {
            return null;
        }

        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums);

        boolean found = false;
        int smallNumPos = 0;
        int bigNumPos = nums.length - 1;
        while (true) {
            if (smallNumPos == bigNumPos) {
                break;
            }

            int smallBigSum = sortedNums[smallNumPos] + sortedNums[bigNumPos];
            if (smallBigSum == target) {
                found = true;
                break;
            } else {
                if (smallBigSum > target) {
                    bigNumPos--;
                } else {
                    smallNumPos++;
                }
            }
        }

        if (!found) {
            return null;
        }

        int[] twoNum = new int[] { sortedNums[smallNumPos], sortedNums[bigNumPos] };
        int[] twoNumPos = new int[2];
        Set<Integer> used = new HashSet<>();

        for (int i = 0; i < twoNum.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (!used.contains(j)) {
                    if (twoNum[i] == nums[j]) {
                        twoNumPos[i] = j;
                        used.add(j);
                        break;
                    }
                }
            }

        }

        return twoNumPos;
    }

    public static void main(String[] args) {
        int[] inp = { 2, 5, 5, 11 };
        System.out.println("Hello World" + Arrays.toString(new Solution().twoSum(inp, 10)));
    }
}
