class _283_moveZeroes { // 移动零
    public void moveZeroes(int[] nums) {
        // pre check
        if (nums == null || nums.length == 0) {
            return;
        }

        // virtual head frame
        int slow = -1;
        int fast = -1;

        while (fast != nums.length - 1) {
            fast++;
            if (nums[fast] != 0) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        // pad zero
        for (int i = slow + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
