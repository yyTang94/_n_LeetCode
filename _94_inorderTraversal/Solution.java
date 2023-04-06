package _94_inorderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }

        List<Integer> leftResult = inorderTraversal(root.left);
        List<Integer> rightResult = inorderTraversal(root.right);

        List<Integer> result = new ArrayList<>();
        if (Objects.nonNull(leftResult) && !leftResult.isEmpty()) {
            result.addAll(leftResult);
        }

        result.add(root.val);

        if (Objects.nonNull(rightResult) && !rightResult.isEmpty()) {
            result.addAll(rightResult);
        }

        return result;
    }
}
