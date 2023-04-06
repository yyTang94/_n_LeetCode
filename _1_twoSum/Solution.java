package _1_twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution { // 两数之和
    public int[] twoSum(int[] nums, int target) {
        int[] abIdx = new int[2];

        Map<Integer, Integer> num2Idx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int b = nums[i];
            int a = target - b;

            if (num2Idx.containsKey(a)) {
                abIdx[0] = num2Idx.get(a);
                abIdx[1] = i;
                break;
            } else {
                num2Idx.put(b, i);
            }

        }

        return abIdx;
    }

    public static void main(String[] args) {
        int[] inp = { 3, 3 };
        System.out.println("Hello World" + Arrays.toString(new Solution().twoSum(inp, 6)));
    }
}
