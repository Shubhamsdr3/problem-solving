package problemsolving.leetcode75.linkedlist;

import easy.data.ListNode;

public class ReverseLinkedList2 {

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode leftPre = dummy;
        ListNode current = head;

        // go to start position.
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            current = current.next;
        }

        ListNode subListHead = current; // store the last node of sublist to be reversed.

        // reverse as usually.
        ListNode prevNode = null;
        int n = right - left + 1; // number of nodes to be reversed.
        for (int i = 0; i < n; i++) {
            ListNode nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }

        // join the pieces
        leftPre.next = prevNode;
        subListHead.next = current;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
        int left = 2;
        int right = 4;
        ListNode res = reverseBetween(head, left, right);
        res.printList(res);
    }
}
