package medium;

import easy.data.ListNode;

public class RemoveDuplicatesFromSortedList2 {

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
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
