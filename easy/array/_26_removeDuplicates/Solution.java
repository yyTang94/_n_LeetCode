package easy.array._26_removeDuplicates;
class Solution {
    public int removeDuplicates(int[] nums) {
        // pre check
        if (nums.length <= 1) {
            return nums.length;
        }

        // first frame
        int slow = 0;
        int fast = 0;
        while (fast != nums.length - 1) {
            fast++;
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] inp = { 1, 1, 2, 2, 3, 4, 4 };
        System.out.println("removeDuplicates: " + new Solution().removeDuplicates(inp));
    }
}
