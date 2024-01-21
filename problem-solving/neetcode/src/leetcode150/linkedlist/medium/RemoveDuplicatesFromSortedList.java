package leetcode150.linkedlist.medium;

import easy.data.ListNode;

public class RemoveDuplicatesFromSortedList {

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // if duplicate, keep moving
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if (prev.next == current) {
                prev = prev.next; // current.val is distinct, move pre to next node.
            } else {
                prev.next = current.next; // skip duplicates, but prev shouldn't move now.
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.addToLast(head1, 3);
        head1.addToLast(head1,3);
        head1.addToLast(head1, 4);
        head1.addToLast(head1, 4);
        head1.addToLast(head1, 5);
        ListNode result1 = deleteDuplicates(head1);
        result1.printList(head1);


        ListNode head = new ListNode(1);
        head.addToLast(head, 1);
        head.addToLast(head,1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
//        ListNode result = deleteDuplicates(head);
//        result.printList(head);

    }
}
