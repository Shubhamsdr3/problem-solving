package interviewprep_23.linkedlist;

import easy.data.ListNode;

import java.util.List;

public class ReverseLinkedList {

    private static ListNode reverseListRecursive(ListNode head) {
        return putPreAfterNode(head, null);
    }

    private static ListNode putPreAfterNode(ListNode node, ListNode pre) {
        if (node == null) return pre;
        ListNode next = node.next; // store the next node.
        node.next = pre; // put pre in that.
        return putPreAfterNode(next, node);
    }

    /**
     * Iterative
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
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
