package _105_buildTree;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (Objects.isNull(preorder) || Objects.isNull(inorder) || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int splitIndex = IntStream.range(0, inorder.length).filter(i -> inorder[i] == preorder[0]).findFirst()
                .orElse(-1);
        int leftSubTreeSize = splitIndex;
        // int rightSubTreeSize = inorder.length - leftSubTreeSize - 1;

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSubTreeSize);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSubTreeSize);

        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSubTreeSize, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, 1 + leftSubTreeSize, inorder.length);

        TreeNode tree = new TreeNode(preorder[0], buildTree(leftPreorder, leftInorder),
                buildTree(rightPreorder, rightInorder));

        return tree;
    }
}
