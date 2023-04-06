package _141_hasCycle;

public class Solution {
    /*
     * 2022-10-19 21:36:24 ->
     */
    public boolean hasCycle(ListNode head) {
        // pre check
        if (head == null || head.next == null) {
            return false;
        }

        if (head.next == head) {
            return true;
        }

        // flag
        boolean flag = false;

        ListNode bNode = head.next;
        head.next = null;

        ListNode cNode = head;
        ListNode sNode = bNode;

        while (sNode != null) {
            bNode = sNode.next;
            sNode.next = cNode;

            cNode = sNode;
            sNode = bNode;

            if (sNode == head) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}