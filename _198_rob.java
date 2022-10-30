public class _198_rob {
    public int rob(int[] nums) {
        // precheck
        if (nums == null) {
            return 0;
        }

        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }

        //
        int result = -1;
        int[] maxWithCurrent = new int[nums.length];

        maxWithCurrent[0] = nums[0];
        maxWithCurrent[1] = nums[1];
        maxWithCurrent[2] = Math.max(nums[0] + nums[2], nums[1]);

        result = Math.max(maxWithCurrent[0], maxWithCurrent[1]);
        result = Math.max(result, maxWithCurrent[2]);

        for (int i = 3; i < nums.length; i++) {
            maxWithCurrent[i] = nums[i] + Math.max(maxWithCurrent[i - 2], maxWithCurrent[i - 3]);
            if (maxWithCurrent[i] > result) {
                result = maxWithCurrent[i];
            }
        }

        return result;

    }
}
