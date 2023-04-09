package easy.array._189_rotate;

class Solution {
    public void rotate(int[] nums, int k) {
        int aggCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (aggCount >= nums.length) {
                break;
            }

            int source = i;
            int target = (source + k) % nums.length;

            int cache = nums[source];

            do {
                int temp;
                temp = nums[target];
                nums[target] = cache;
                cache = temp;

                source = target;
                target = (source + k) % nums.length;

                aggCount++;
            } while (source != i);
        }
    }
}
