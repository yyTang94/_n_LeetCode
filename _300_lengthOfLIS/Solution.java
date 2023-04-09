package _300_lengthOfLIS;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lengthArr = new int[nums.length];

        for (int i = 0; i < lengthArr.length; i++) {
            lengthArr[i] = 1;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < lengthArr.length; j++) {
                int l = -1;
                if (nums[j] > nums[i]) {
                    l = lengthArr[j] + 1;
                }
                if (l > lengthArr[i]) {
                    lengthArr[i] = l;
                }
            }
        }
        return Arrays.stream(lengthArr).max().getAsInt();
    }
}
