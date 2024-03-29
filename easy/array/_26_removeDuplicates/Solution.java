package easy.array._26_removeDuplicates;

import java.util.Objects;

class Solution {
    /*
     * 查找重复片段（fragment）
     */
    public int removeDuplicates(int[] nums) {
        // pre check
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }

        int cachePosition = 0; // cache position

        int fragStart = 0; // start of a fragment
        int fragLength = 1; // the length of a fragment
        while (true) {
            int fragEnd = fragStart + fragLength - 1;

            // exit
            if (fragEnd >= nums.length) {
                nums[cachePosition] = nums[fragStart];
                break;
            }

            // iter
            if (nums[fragEnd] == nums[fragStart]) {
                fragLength++;
            } else {
                nums[cachePosition] = nums[fragStart];
                cachePosition++;

                fragStart = fragStart + fragLength - 1;
                fragLength = 1;

            }
        }

        return cachePosition + 1;
    }

    public static void main(String[] args) {
        int[] inp = { 1, 1, 2 };
        System.out.println("removeDuplicates: " + new Solution().removeDuplicates(inp));
    }
}
