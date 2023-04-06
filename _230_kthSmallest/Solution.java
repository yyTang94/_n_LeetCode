package _230_kthSmallest;

import java.util.Objects;

class Solution {
    private int doKthSmallest(TreeNode root, int k, TreeNode theValue) {
        if (k == 0) {
            return 0;
        }

        // left
        int nextK = k;
        if (Objects.nonNull(root.left)) {
            nextK = doKthSmallest(root.left, nextK, theValue);
        }

        if (nextK == 0) {
            return 0;
        }

        // mid
        if (nextK == 1) {
            // theValue.valueOf(root.val);
            theValue.val = root.val;
            nextK = 0;
        } else {
            nextK--;
        }

        if (nextK == 0) {
            return 0;
        }

        // right
        if (Objects.nonNull(root.right)) {
            nextK = doKthSmallest(root.right, nextK, theValue);
        }

        if (nextK == 0) {
            return 0;
        }

        return nextK;
    }

    public int kthSmallest(TreeNode root, int k) {
        TreeNode theValue = new TreeNode(-1);
        doKthSmallest(root, k, theValue);
        return Objects.nonNull(theValue) ? theValue.val : -1;
    }
}