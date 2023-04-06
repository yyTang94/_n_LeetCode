package _108_sortedArrayToBST;
import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /*
     * 2022-10-20 22:42:52 -> 2022-10-20 23:01:54
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        // pre check
        if (nums == null || nums.length == 0) {
            return null;
        }

        //
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else if (nums.length == 2) {
            return new TreeNode(nums[1], new TreeNode(nums[0]), null);
        } else if (nums.length == 3) {
            return new TreeNode(nums[1], new TreeNode(nums[0]), new TreeNode(nums[2]));
        } else {
            int mid = nums.length / 2;
            return new TreeNode(nums[mid], sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid)),
                    sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length)));
        }
    }
}
