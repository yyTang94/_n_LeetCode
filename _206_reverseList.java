class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class _206_reverseList {
    /*
     * 2022-10-17 22:15:25 -> 2022-10-17 22:35:59
     */
    public ListNode reverseList(ListNode head) {
        // pre check
        if (head == null) {
            return null;
        }

        // single node
        if (head.next == null) {
            return head;
        }

        // reverse
        ListNode bNode = head.next;
        head.next = null;
        ListNode cNode = head;
        ListNode sNode = bNode;
        while (sNode != null) {
            bNode = sNode.next;
            sNode.next = cNode;

            cNode = sNode;
            sNode = bNode;
        }

        // new head
        ListNode newHead = cNode;

        return newHead;
    }
}
