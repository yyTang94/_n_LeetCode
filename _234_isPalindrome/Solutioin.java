package _234_isPalindrome;
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

public class Solutioin {
    /*
     * 2022-10-18 22:18:18 -> 2022-10-18 23:04:18
     */
    public boolean isPalindrome(ListNode head) {
        // pre check
        if (head == null || head.next == null) {
            return true;
        }

        // length
        int length;
        {
            ListNode cNode = head;
            length = 1;
            while (cNode.next != null) {
                cNode = cNode.next;
                length++;
            }
        }

        // split
        ListNode leftHead;
        ListNode rightHead;

        {
            ListNode bNode = head.next;
            head.next = null;

            ListNode cNode = head;
            ListNode sNode = bNode;

            for (int i = 1; i < length / 2; i++) {
                bNode = sNode.next;
                sNode.next = cNode;

                cNode = sNode;
                sNode = bNode;
            }

            leftHead = cNode;
            rightHead = (length % 2 == 0) ? sNode : sNode.next;
        }

        // judge
        boolean flag = true;
        {
            ListNode l = leftHead;
            ListNode r = rightHead;
            while (l != null && r != null) {
                if (l.val != r.val) {
                    flag = false;
                    break;
                }
                l = l.next;
                r = r.next;
            }
        }

        return flag;
    }
}
