package medium.sortsearch._34_searchRange;

class Solution {
    private int doSearchIn(int[] nums, int start, int length, int target) {
        if (length == 0) {
            return -1;
        }

        int mid = start + length / 2;
        if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {
            return mid;
        } else {
            if (nums[mid] < target) {
                return doSearchIn(nums, mid + 1, length - (mid - start + 1), target);
            } else {
                return doSearchIn(nums, start, mid - start, target);
            }
        }
    }

    private int doSearchOut(int[] nums, int start, int length, int target) {
        if (length == 0) {
            return -1;
        }

        int mid = start + length / 2;
        if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)) {
            return mid;
        } else {
            if (nums[mid] > target) {
                return doSearchOut(nums, start, mid - start, target);
            } else {
                return doSearchOut(nums, mid + 1, length - (mid - start + 1), target);
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] inOut = new int[2];
        inOut[0] = doSearchIn(nums, 0, nums.length, target);
        inOut[1] = doSearchOut(nums, 0, nums.length, target);
        return inOut;
    }
}
