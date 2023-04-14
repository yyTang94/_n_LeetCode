package medium.sortsearch._162_findPeakElement;

import java.util.Objects;

class Solution {
    private int doFind(int[] nums, int start, int length) {
        int mid = start + length / 2;
        if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] < nums[mid])) {
            return mid;
        } else {
            if (mid == 0) {
                return doFind(nums, 1, length - 1);
            } else if (mid == nums.length - 1) {
                return doFind(nums, start, length - 1);
            } else {
                if (nums[mid + 1] > nums[mid]) {
                    return doFind(nums, mid + 1, length - (mid - start + 1));
                } else {
                    return doFind(nums, start, mid - start);
                }
            }
        }
    }

    public int findPeakElement(int[] nums) {
        // pre check
        if (Objects.isNull(nums) || nums.length == 0) {
            return -1;
        }

        return doFind(nums, 0, nums.length);
    }
}
