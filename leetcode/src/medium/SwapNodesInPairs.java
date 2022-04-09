package medium;

import easy.data.ListNode;

/**
Created at: 19/03/22
*/
public class SwapNodesInPairs {

    private static ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        ListNode prev = sentinel;
        while (head != null && head.next != null) {
            prev.next = head.next;
            ListNode next = head.next.next;
            head.next.next = head;
            prev = head;
            head = next;
        }
        prev.next = head;
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
        head.addToLast(head, 6);
        ListNode res = swapPairs(head);
        res.printList(res);
    }
}
