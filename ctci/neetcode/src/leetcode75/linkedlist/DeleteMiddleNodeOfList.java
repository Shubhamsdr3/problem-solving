package leetcode75.linkedlist;

import easy.data.ListNode;

public class DeleteMiddleNodeOfList {


    /**
     * using two pointers(slow/fast)
     * @param head
     * @return
     */
    private static ListNode deleteMiddle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * Using three pointers.
     * @param head
     * @return
     */
    private static ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return prev.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 7);
        head.addToLast(head, 1);
        head.addToLast(head, 2);
        head.addToLast(head, 6);
        ListNode res = deleteMiddle2(head);
        res.printList(res);
    }
}
