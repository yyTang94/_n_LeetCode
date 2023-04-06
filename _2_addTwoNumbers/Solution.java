package _2_addTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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

    public static void main(String[] args) {
    }
}
