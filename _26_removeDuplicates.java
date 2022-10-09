class _26_removeDuplicates {
    public int removeDuplicates(int[] nums) {

        /*
         * 2022-10-03 10:57:42
         * time: 0 ms (100.00%)
         * memory: 42.7 MB (96.84%)
         */

        int slow = -1;
        int fast = 0;

        while (fast < nums.length) {

            if (slow < 0) {
                slow++;
                fast++;
            } else {
                if (nums[fast] != nums[slow]) {
                    nums[slow + 1] = nums[fast];

                    slow++;
                    fast++;
                } else {
                    fast++;
                }
            }

        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] inp = { 1, 2, 3 };
        System.out.println("removeDuplicates: " + new _26_removeDuplicates().removeDuplicates(inp));
    }
}
