/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

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

class Solution {
    public ListNode fun20221002(ListNode l1, ListNode l2) {
        /*
         * time: 1 ms (100.00%)
         * memory: 41.3 MB (86.31%)
         */
        ListNode rslt = new ListNode(-1);

        // carry, a, b -> r
        int carry = 0;

        ListNode a = l1;
        ListNode b = l2;

        ListNode r = rslt;

        while (a != null || b != null || carry != 0) {

            int aVal;
            if (a == null) {
                aVal = 0;
            } else {
                aVal = a.val;
            }

            int bVal;
            if (b == null) {
                bVal = 0;
            } else {
                bVal = b.val;
            }

            int sVal = aVal + bVal + carry;

            r.next = new ListNode(sVal % 10);

            carry = sVal / 10;

            if (a != null) {
                a = a.next;
            }

            if (b != null) {
                b = b.next;
            }

            r = r.next;

        }

        return rslt.next;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return fun20221002(l1, l2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] inp = { 9, 9, 9, 9, 9, 9, 9 };
    }
}
