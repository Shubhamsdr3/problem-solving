package medium;

import easy.data.ListNode;

public class RemoveDuplicatesFromSortedList2 {

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next; // skip all duplicates.
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
        ListNode res = deleteDuplicates(head);
        res.printList(res);
    }
}
