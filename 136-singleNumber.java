class Solution {
    public int fun1(int[] nums) {
        /*
         * 2022-10-03 18:57:42
         * 1 ms (99.97%)
         * 41.4 MB (63.17%)
         */
        int rslt = 0;
        for (int i = 0; i < nums.length; i++) {
            rslt = rslt ^ nums[i];
        }

        return rslt;
    }

    public int singleNumber(int[] nums) {
        return fun1(nums);
    }
}