package easy;

import easy.data.ListNode;

public class DeleteNodeLinkedList {

    private static void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            prev = node;

        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.addToLast(head, 5);
        head.addToLast(head, 1);
        head.addToLast(head, 9);
    }
}
