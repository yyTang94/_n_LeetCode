import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class _102_levelOrder {
    /*
     * 2022-10-20 21:41:30->
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // pre check
        if (root == null) {
            return new ArrayList<>();
        }

        //
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> hotQueue = new LinkedList<>();
        Queue<TreeNode> coldQueue = new LinkedList<>();

        hotQueue.add(root);

        List<Integer> layer = new ArrayList<>();
        while (!hotQueue.isEmpty() || !coldQueue.isEmpty()) {
            if (!hotQueue.isEmpty()) {
                TreeNode tn = hotQueue.remove();
                layer.add(tn.val);
                if (tn.left != null) {
                    coldQueue.add(tn.left);
                }
                if (tn.right != null) {
                    coldQueue.add(tn.right);
                }
            } else {
                hotQueue.addAll(coldQueue);
                coldQueue.clear();

                result.add(layer);
                layer = new ArrayList<>();
            }
        }

        result.add(layer);

        return result;
    }
}
