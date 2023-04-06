package _328_oddEvenList;

import java.util.Objects;

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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddRoot = new ListNode();
        ListNode evenRoot = new ListNode();

        ListNode current = head;
        ListNode oddCurrent = oddRoot;
        ListNode evenCurrent = evenRoot;

        while (true) {
            // odd
            if (Objects.isNull(current)) {
                break;
            }

            oddCurrent.next = current;
            current = current.next;

            oddCurrent = oddCurrent.next;
            oddCurrent.next = null;

            // even
            if (Objects.isNull(current)) {
                break;
            }

            evenCurrent.next = current;
            current = current.next;

            evenCurrent = evenCurrent.next;
            evenCurrent.next = null;

        }

        oddCurrent.next = evenRoot.next;

        return oddRoot.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5)))));
        new Solution().oddEvenList(head);
        return;
    }

}
