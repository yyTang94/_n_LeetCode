class Solution {
    public void fun1(int[] nums) {
        /*
         * 2022-10-03 16:36:41
         * 1 ms (100.00%)
         * 43.5 MB (5.19%)
         */

        int slow = -1;
        int fast = 0;

        while (fast < nums.length) {

            if (nums[fast] != 0) {
                nums[slow +1] = nums[fast];

                slow ++;
                fast ++;
            } else {
                fast ++;
            }

        }

        for (int i=slow +1; i < nums.length; i++){
            nums[i] = 0;
        }

    }

    public void moveZeroes(int[] nums) {
        fun1(nums);
    }
}