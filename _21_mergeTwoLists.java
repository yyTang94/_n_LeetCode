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

public class _21_mergeTwoLists {
    /*
     * 2022-10-18 21:48:41 -> 2022-10-18 22:13:47
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode guardNode = new ListNode(-1);
        ListNode curNode = guardNode;

        while (list1 != null || list2 != null) {
            if (list1 == null && list2 != null) {
                curNode.next = list2;
                break;
            } else if (list1 != null && list2 == null) {
                curNode.next = list1;
                break;
            } else { // both not null
                if (list2.val < list1.val) {
                    curNode.next = list2;
                    curNode = curNode.next;

                    list2 = list2.next;
                } else {
                    curNode.next = list1;
                    curNode = curNode.next;

                    list1 = list1.next;
                }
            }
        }

        return guardNode.next;
    }
}
