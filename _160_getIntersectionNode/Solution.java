package _160_getIntersectionNode;

import java.util.Objects;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        while (Objects.nonNull(currA) && Objects.nonNull(currB)) {
            currA = currA.next;
            currB = currB.next;
        }

        if (Objects.nonNull(currA) && Objects.isNull(currB)) {
            // B
            currB = headB;

            // A
            ListNode temp = headA;
            while (Objects.nonNull(currA)) {
                currA = currA.next;
                temp = temp.next;
            }
            currA = temp;
        } else if (Objects.nonNull(currB) && Objects.isNull(currA)) {
            // A
            currA = headA;

            // B
            ListNode temp = headB;
            while (Objects.nonNull(currB)) {
                currB = currB.next;
                temp = temp.next;
            }
            currB = temp;
        } else {
            currA = headA;
            currB = headB;
        }

        while (Objects.nonNull(currA) && Objects.nonNull(currB)) {
            if (currA == currB) {
                return currA;
            }

            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}
