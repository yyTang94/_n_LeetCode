package _104_maxDepth;
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
     * 2022-10-19 22:04:53->
     */
    public int maxDepth(TreeNode root) {
        //
        if (root == null) {
            return 0;
        }

        //
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
