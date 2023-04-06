class Solution {
    private boolean leftLoopAndRightLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean leftFlag = false;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    leftFlag = true;
                    break;
                }
            }

            boolean rightFlag = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    rightFlag = true;
                    break;
                }
            }

            if (leftFlag && rightFlag) {
                return true;
            }
        }

        return false;
    }

    private boolean dynamic(int[] nums) {
        // rightMax
        int[] rightMaxArr = new int[nums.length];
        int rightMax = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightMaxArr[i] = rightMax;

            rightMax = nums[i] > rightMax ? nums[i] : rightMax;
        }

        // leftMin
        int[] leftMinArr = new int[nums.length];
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            leftMinArr[i] = leftMin;

            leftMin = nums[i] < leftMin ? nums[i] : leftMin;
        }

        // judge
        for (int i = 0; i < nums.length; i++) {
            if (leftMinArr[i] < nums[i] && nums[i] < rightMaxArr[i]) {
                return true;
            }
        }

        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        return dynamic(nums);
    }
}