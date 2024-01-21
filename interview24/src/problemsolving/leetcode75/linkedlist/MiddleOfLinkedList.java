package problemsolving.leetcode75.linkedlist;

import easy.data.ListNode;

public class MiddleOfLinkedList {

    private static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
