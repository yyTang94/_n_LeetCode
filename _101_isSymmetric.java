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

class _101_isSymmetric {
    /*
     * 2022-10-20 21:29:47 -> 2022-10-20 21:38:55
     */

    private boolean isSymmetricTree(TreeNode l, TreeNode r) {

        if (l == null && r == null) {
            return true;
        } else if (l != null && r == null) {
            return false;
        } else if (l == null && r != null) {
            return false;
        } else {
            return (l.val == r.val) && isSymmetricTree(l.left, r.right) && isSymmetricTree(l.right, r.left);
        }

    }

    public boolean isSymmetric(TreeNode root) {
        // precheck
        if (root == null) {
            return true;
        }

        return isSymmetricTree(root.left, root.right);
    }
}
