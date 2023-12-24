package leetcode150.linkedlist.medium;

import easy.data.ListNode;

public class RemoveNthNodeFromEndOfList {

    private static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        // fast will be ahead to n-position than slow.
        // as soon as fast reaches the end , slow will be at the n - len() position.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * O(n)
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        for (int i = 0; i < size - n; i++) {
            prev = prev.next;
            current = current.next;
        }
        prev.next = current.next;
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
