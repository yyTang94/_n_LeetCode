package medium.sortsearch._33_search;

class Solution {
    private int doSearch(int[] nums, int start, int length, int target) {
        if (length == 0) {
            return -1;
        }

        int mid = start + length / 2;
        if (nums[mid] == target) {
            return mid;
        } else {
            if (mid == start) {
                return doSearch(nums, mid + 1, length - (mid - start + 1), target);
            } else if (mid == start + length - 1) {
                return doSearch(nums, start, mid - start, target);
            } else if (nums[mid] < nums[nums.length - 1]) {
                if (nums[mid] < target && target <= nums[start + length - 1]) {
                    return doSearch(nums, mid + 1, length - (mid - start + 1), target);
                } else {
                    return doSearch(nums, start, mid - start, target);
                }
            } else {
                if (nums[mid] > target && target >= nums[start]) {
                    return doSearch(nums, start, mid - start, target);
                } else {
                    return doSearch(nums, mid + 1, length - (mid - start + 1), target);
                }
            }
        }
    }

    public int search(int[] nums, int target) {
        return doSearch(nums, 0, nums.length, target);
    }
}
