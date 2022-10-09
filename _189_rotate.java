class _189_rotate {
    public void rotate(int[] nums, int k) {
        /*
         * 2022-10-03 15:28:45
         * time: 1 ms (64.12%)
         * memory: 57.2 MB (30.20%)
         */

        k = k % nums.length;

        int[] bufK = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            bufK[i - (nums.length - k)] = nums[i];
        }

        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = bufK[i];
        }

    }
}
