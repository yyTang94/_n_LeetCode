package _53_maxSubArray;
class Solution {
    public int maxSubArray(int[] nums) {
        // pre check
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //
        int result = 0;
        int[] maxSubSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxSubSum[i] = nums[i];

                result = maxSubSum[i];
            } else {
                if (maxSubSum[i - 1] > 0) {
                    maxSubSum[i] = maxSubSum[i - 1] + nums[i];
                } else {
                    maxSubSum[i] = nums[i];
                }

                if (maxSubSum[i] > result) {
                    result = maxSubSum[i];
                }
            }
        }

        return result;
    }
}
