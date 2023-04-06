package _116_connect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {
    private void doConnect(List<Node> nodes) {
        List<Node> subLayer = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (i < nodes.size() - 1) {
                nodes.get(i).next = nodes.get(i + 1);
            } else {
                nodes.get(i).next = null;
            }
            if (Objects.nonNull(nodes.get(i).left)) {
                subLayer.add(nodes.get(i).left);
            }
            if (Objects.nonNull(nodes.get(i).right)) {
                subLayer.add(nodes.get(i).right);
            }
        }

        if (!subLayer.isEmpty()) {
            doConnect(subLayer);
        }
    }

    public Node connect(Node root) {
        if (Objects.isNull(root)) {
            return root;
        }
        doConnect(Arrays.asList(root));
        return root;
    }
}
