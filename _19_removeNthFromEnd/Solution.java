package _19_removeNthFromEnd;

class Solution {
    /*
     * 2022-10-17 21:41:40 -> 2022-10-17 22:12:15
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // pre check
        if (head == null) {
            return null;
        }

        // set guard
        ListNode guard = new ListNode(-1, head);

        // cal length
        int length;
        {
            ListNode curNode = guard;
            length = 0;
            while (curNode.next != null) {
                curNode = curNode.next;
                length++;
            }
        }

        // find the father of lastN node
        if (n > length) {
            return null;
        }

        int fatherIndexOfTarget = length - n - 1;
        ListNode fatherOfTarget = null;
        {
            ListNode curNode = guard;
            int i = -1;
            while (i != fatherIndexOfTarget) {
                curNode = curNode.next;
                i++;
            }

            // found
            fatherOfTarget = curNode;
        }

        // delete target node
        fatherOfTarget.next = fatherOfTarget.next.next;

        return guard.next;
    }

}
