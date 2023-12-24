package leetcode75.linkedlist;

import easy.data.ListNode;

import java.util.List;

public class ReverseLinkedList {

    private static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        while (head != null) {
            ListNode current = head.next;
            head.next = prev;
            prev = head;
            head = current;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addToLast(head, 2);
        head.addToLast(head, 3);
        head.addToLast(head, 4);
        head.addToLast(head, 5);
        ListNode res = reverseList(head);
        res.printList(res);
    }
}
