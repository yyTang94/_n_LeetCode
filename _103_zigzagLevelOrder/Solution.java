package _103_zigzagLevelOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {
    private static final String POSITIVE_ORDER = "positive_order";
    private static final String NEGATIVE_ORDER = "negative_order";

    public List<List<Integer>> doZigzagLevelOrder(List<TreeNode> nodeList, String iterOrder) {

        if (Objects.isNull(nodeList) || nodeList.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> currentLayer = new ArrayList<>();
        List<TreeNode> sonNodes = new ArrayList<>();
        for (TreeNode n : nodeList) {
            if (Objects.isNull(n)) {
                continue;
            }

            currentLayer.add(n.val);

            if (Objects.nonNull(n.left)) {
                sonNodes.add(n.left);
            }
            if (Objects.nonNull(n.right)) {
                sonNodes.add(n.right);
            }

        }

        List<List<Integer>> subLayers = doZigzagLevelOrder(sonNodes,
                POSITIVE_ORDER.equals(iterOrder) ? NEGATIVE_ORDER : POSITIVE_ORDER);

        List<List<Integer>> layers = new ArrayList<>();
        if (NEGATIVE_ORDER.equals(iterOrder)) {
            Collections.reverse(currentLayer);
        }
        layers.add(currentLayer);
        layers.addAll(subLayers);

        return layers;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }

        return doZigzagLevelOrder(Arrays.asList(root), POSITIVE_ORDER);
    }
}
