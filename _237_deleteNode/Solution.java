package _237_deleteNode;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*
 * 2022-10-17 21:23:56 -> 2022-10-17 21:32:26
 */
class Solution {
    public void deleteNode(ListNode node) {
        // pre check
        if (node == null) {
            return;
        }

        // check if the given node is the last node
        if (node.next == null) {
            return;
        }

        // make this node equal to the next
        node.val = node.next.val;

        // delete the next node
        node.next = node.next.next;

        return;
    }
}