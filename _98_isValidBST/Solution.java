package _98_isValidBST;

class _98_isValidBST {
    /*
     * 2022-10-19 22:12:29 -> 2022-10-19 23:01:49
     */
    private boolean isValidNode(boolean hasLowerBound, int lowerBound, boolean hasUpperBound, int upperBound,
            TreeNode treeNode) {

        if (treeNode == null) {
            return true;
        }

        if ((!hasLowerBound || lowerBound < treeNode.val) && (!hasUpperBound || treeNode.val < upperBound)) {
            return isValidNode(hasLowerBound, lowerBound, true, treeNode.val, treeNode.left)
                    && isValidNode(true, treeNode.val, hasUpperBound, upperBound, treeNode.right);
        } else {
            return false;
        }

    }

    public boolean isValidBST(TreeNode root) {
        return isValidNode(false, 0, false, 0, root);
    }
}
